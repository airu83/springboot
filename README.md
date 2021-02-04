# springboot

* 2021-02-04(1차)

- Gradle build
https://docs.gradle.org/current/userguide/intro_multi_project_builds.html#sec:multiproject_build_and_test

SpringBoot new
1. 설정 환경
 - Type: Gradle(Buildship 3.x)
 - packaging: War
 - Java Version: 8
 - Language: Java

2. setting.gradle
 - 하위 모듈 생성

rootProject.name = 'gradle_multi'

include 'module_admin', 'module_core', 'module_client'

3. build.gradle

/*
*******************************Before******************************************

plugins {
	id 'org.springframework.boot' version '2.4.2'
	id 'io.spring.dependency-management' version '1.0.11.RELEASE'
	id 'java'
	id 'war'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

test {
	useJUnitPlatform()
}
*/

/*
*******************************After******************************************
*/

buildscript {
    ext {
        springBootVersion = '2.4.2'
    }
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    }
}

allprojects {
    group = 'com.example'
    version = '0.0.1-SNAPSHOT'
}

subprojects {
    apply plugin: 'java'
    apply plugin: 'org.springframework.boot'
    apply plugin: 'io.spring.dependency-management'

    sourceCompatibility = '1.8'

    repositories {
        mavenCentral()
    }

    dependencies {
        testImplementation('org.springframework.boot:spring-boot-starter-test') {
            exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
        }
    }

    task initSourceFolders {
        sourceSets*.java.srcDirs*.each {
            if (!it.exists()) {
                it.mkdirs()
            }
        }
        sourceSets*.resources.srcDirs*.each {
            if (!it.exists()) {
                it.mkdirs()
            }
        }
    }
}

project(':module_admin') {
    dependencies {
        compile project(':module_core')
    }
}

project(':module_client') {
    dependencies {
        compile project(':module_core')
    }
}


4. build.gradle 마우스 우클릭 Refresh Gradle Project

5. sub Project 내 build.gradle 생성
- module_admin && module_client 내 
dependencies {
    compile('org.springframework.boot:spring-boot-starter-web')
    testCompile('org.springframework.boot:spring-boot-starter-test')
}

- module_core 내 
bootJar {
    enabled = false
}
jar {
    enabled = true
}

6. module_admin && module_client 내 boot Class & application.yml 생성
module_admin
	src/main/java
		module_admin
			AdminApplication
	src/main/resources
		application.yml

- AdminApplication
package module_admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);

	}

}

- application.yml
server:
  port: 9000

module_client
	src/main/java
		module_client
			ClientApplication
	src/main/resources
		application.yml


- ClientApplication
package module_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);

	}

}

- application.yml
server:
  port: 9000


* 2021-02-04(2차)

1. build.gradle (module_admin && module_client)
 developmentOnly("org.springframework.boot:spring-boot-devtools")
 
2. CommonController( module_admin && module_client -> controller(package) -> CommonController.java )
	@GetMapping("")
	public String index() {
		System.out.println(">>>Call Admin index");
		return "Hello this is Admin Controller~!";
	}

	@GetMapping("")
	public String index() {
		System.out.println(">>>Call Client Index");
		return "Hello this is Client Controller~!!";
	}

package module_admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
	
	@GetMapping("")
	public String index() {
		System.out.println(">>>Call Admin index");
		return "Hello this is Admin Controller~!";
	}
}

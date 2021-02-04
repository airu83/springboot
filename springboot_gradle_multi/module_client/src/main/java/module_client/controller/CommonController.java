package module_client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

	@GetMapping("")
	public String index() {
		System.out.println(">>>Call Client Index");
		return "Hello this is Client Controller~!!";
	}
}

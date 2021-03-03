package module_admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.module_core.User;

import module_admin.service.UserService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	private UserService userService;
	
	public TestController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/getData")
	public String getData() {
		User user = new User();
		user = userService.getData();
		return "result Count is " + user.getName();
	}
}

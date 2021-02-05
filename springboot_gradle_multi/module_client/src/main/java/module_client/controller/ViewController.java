package module_client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
	
	@GetMapping("/clientindex")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="world") String name, Model model) {
		System.out.println(">>>client ViewController");
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping({"/home"})
	public String home() {
		return "home";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}

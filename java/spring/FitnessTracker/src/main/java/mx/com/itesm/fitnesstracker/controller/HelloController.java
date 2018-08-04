package mx.com.itesm.fitnesstracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping(value = "/greeting")
	public String sayHello(Model model) {
		
		model.addAttribute("greeting","hello world");
		return "hello";
	}
}

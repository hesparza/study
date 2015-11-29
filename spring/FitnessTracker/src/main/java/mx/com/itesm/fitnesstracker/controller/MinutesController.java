package mx.com.itesm.fitnesstracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.itesm.fitnesstracker.model.Exercise;

@Controller
public class MinutesController {

	@RequestMapping(value = "/addMinutes")
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {
		final String METHOD_NAME = this.getClass().getName() + ".addMinutes";
		System.out.println("Inside " + METHOD_NAME);
		
		System.out.println("exercise: " + exercise.getMinutes());
		return "addMinutes";
	}
}

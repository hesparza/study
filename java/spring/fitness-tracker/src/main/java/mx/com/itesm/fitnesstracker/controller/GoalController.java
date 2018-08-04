package mx.com.itesm.fitnesstracker.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import mx.itesm.fitnesstracker.model.Goal;

@Controller
@SessionAttributes("goal") //Save goal as a session attribute
public class GoalController {

	@RequestMapping(value = "/addGoal", method = RequestMethod.GET)
	public String addGoal(Model model) {
		final String METHOD_NAME = this.getClass().getName() + ".addGoal";
		System.out.println("Inside " + METHOD_NAME);
		
		model.addAttribute("goal", new Goal(10));
		
		return "addGoal";
	}
	
	@RequestMapping(value = "/addGoal", method = RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result) {
		final String METHOD_NAME = this.getClass().getName() + ".updateGoal";
		System.out.println("Inside " + METHOD_NAME);
		
		System.out.println(METHOD_NAME + ": Result has errors: " + result.hasErrors());
		if(result.hasErrors()) {
			return "addGoal";
		}
		
		System.out.println(METHOD_NAME + ": Minutes updated: " + goal.getMinutes());
		
		return "redirect:addMinutes.html";
	}
}

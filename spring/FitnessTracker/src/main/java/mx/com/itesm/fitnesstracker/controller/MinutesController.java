package mx.com.itesm.fitnesstracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.itesm.fitnesstracker.model.Activity;
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
	
	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities() {
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity run = new Activity();
		run.setName("run");
		run.setDescription("Running on the  morning for 30 minutes");
		activities.add(run);
		
		Activity bike = new Activity();
		bike.setName("bike");
		bike.setDescription("Bikingon the mountains!");
		activities.add(bike);
		
		Activity swim = new Activity();
		swim.setName("swim");
		swim.setDescription("Swiming in the YMCA!");
		activities.add(swim);
		
		return activities;
	}
	
}

package com.kidob.sportgames.app.view.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kidob.sportgames.app.service.MatchService;

@Controller
public class MatchViewController {

	@Autowired
	private MatchService matchService;
	
	@GetMapping ("/")
	public String home(Model model) {
		model.addAttribute("messaage", "Fake content in page");
		model.addAttribute("title", "Hello Home");
		model.addAttribute("date", new Date());
		return "home";
	}
	
	@GetMapping ("/matches")
	public String findMatches(Model model) {
		model.addAttribute("matches", matchService.findMatches());
		return "matches";
	}	
}

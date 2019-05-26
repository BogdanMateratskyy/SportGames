package com.kidob.sportgames.app.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.kidob.sportgames.app.service.MatchService;
import com.kidob.sportgames.app.service.TeamService;

@Controller
public class ModelController {

	@Autowired
	TeamService teamService;
	@Autowired
	MatchService matchService;

	@GetMapping("/")
	public String index(Model model) {
		String message = "Hello, everyone";
		model.addAttribute("message", message);

		return "index";
	}

	@GetMapping("/matchList")
	public String matchList(Model model) {
		model.addAttribute("matchList", matchService.findMatches());

		return "matchList";
	}

	@GetMapping("/teamList")
	public String teamList(Model model) {
		model.addAttribute("teamList", teamService.findTeams());

		return "teamList";
	}
}

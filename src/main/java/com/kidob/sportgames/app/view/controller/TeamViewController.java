package com.kidob.sportgames.app.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kidob.sportgames.app.service.TeamService;

@Controller
public class TeamViewController {

	@Autowired
	private TeamService teamService;
	
	@GetMapping ("/teams")
	public String findTeams(Model model) {
		model.addAttribute("reams", teamService.findTeams());
		return "teams";
	}
}

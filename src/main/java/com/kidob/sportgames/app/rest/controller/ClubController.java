package com.kidob.sportgames.app.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kidob.sportgames.app.service.ClubService;

/**
 * {@link ClubController} is a REST service that handles club-related request
 * 
 * @author Bogdan
 *
 */
@RestController
@RequestMapping ("club")
public class ClubController {

	/**
	 * Underlying source of data
	 */
	private ClubService clubService;
	
}

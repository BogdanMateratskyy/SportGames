package com.kidob.sportgames.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.kidob.sportgames.app.model.entity.location.Place;
import com.kidob.sportgames.app.model.entity.sport.Matches;
import com.kidob.sportgames.app.model.entity.sport.TeamMatch;
import com.kidob.sportgames.app.persistence.repository.MatchesRepository;
import com.kidob.sportgames.app.persistence.repository.TeamMatchRepository;
import com.kidob.sportgames.app.rest.dto.MatchDTO;
import com.kidob.sportgames.app.service.MatchService;

public class MatchServiceImpl implements MatchService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private MatchesRepository matchesRepository;

	@Autowired
	private TeamMatchRepository teamMatchRepository;

	@Override
	public MatchDTO saveMatch(MatchDTO matchDto) {
		Matches matches = new Matches(matchDto.getSportId(), matchDto.getTournamentId(), matchDto.getDateOfMatch());
		TeamMatch temMatch;
		
		
		//matchesRepository.save();
		return null;
	}

	@Override
	public MatchDTO updateMatch(MatchDTO matchDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MatchDTO> findMatches() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MatchDTO> findMatchById(Long matchId) {
		// TODO Auto-generated method stub
		return null;
	}

	private MatchDTO convertToDto(Matches matches, TeamMatch teamMatch) {
		MatchDTO matchDto = new MatchDTO();
		
		if (matches.getId() == teamMatch.getMatch().getId()) {
			matchDto.transform(matches);
			matchDto.setSportId(matches.getSport().getId());
			matchDto.setTournamentId(matches.getTournament().getId());
			if (Place.HOME.equals(teamMatch.getPlace())) {
				matchDto.setHomeTeamId(teamMatch.getTeam().getId());
			}
			if (Place.AWAY.equals(teamMatch.getPlace())) {
				matchDto.setAwayTeamId(teamMatch.getTeam().getId());
			}
		}

		return matchDto;
	}

	
	  private Post convertToEntity(PostDto postDto) throws ParseException { Post
	  post = modelMapper.map(postDto, Post.class); post.setSubmissionDate(
	  postDto.getSubmissionDateConverted(userService.getCurrentUser().getPreference
	  ().getTimezone()));
	  
	  if (postDto.getId() != null) { Post oldPost =
	  postService.getPostById(postDto.getId());
	  post.setRedditID(oldPost.getRedditID()); post.setSent(oldPost.isSent()); }
	  return post; }
	 
}

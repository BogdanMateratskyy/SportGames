package com.kidob.sportgames.app.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.kidob.sportgames.app.infra.exception.PersistenceException;
import com.kidob.sportgames.app.model.entity.location.Place;
import com.kidob.sportgames.app.model.entity.sport.Matches;
import com.kidob.sportgames.app.model.entity.sport.Sport;
import com.kidob.sportgames.app.model.entity.sport.Team;
import com.kidob.sportgames.app.model.entity.sport.TeamMatch;
import com.kidob.sportgames.app.model.entity.sport.Tournament;
import com.kidob.sportgames.app.persistence.repository.MatchesRepository;
import com.kidob.sportgames.app.persistence.repository.SportRepository;
import com.kidob.sportgames.app.persistence.repository.TeamMatchRepository;
import com.kidob.sportgames.app.persistence.repository.TeamRepository;
import com.kidob.sportgames.app.persistence.repository.TournamentRepository;
import com.kidob.sportgames.app.rest.dto.MatchDTO;
import com.kidob.sportgames.app.service.MatchService;

public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchesRepository matchesRepository;

	@Autowired
	private SportRepository sportRepository;

	@Autowired
	private TournamentRepository tournamentRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private TeamMatchRepository teamMatchRepository;

	@Override
	public MatchDTO saveMatch(MatchDTO matchDto) {
		Matches match = getMatchFromDto(matchDto);
		TeamMatch homeTeamMatch = getTeamMatchFromDto(matchDto, match, true);
		TeamMatch awayTeamMatch = getTeamMatchFromDto(matchDto, match, false);

		matchesRepository.saveAndFlush(match);
		teamMatchRepository.saveAndFlush(homeTeamMatch);
		teamMatchRepository.saveAndFlush(awayTeamMatch);

		return convertToDto(match, homeTeamMatch, awayTeamMatch);
	}

	@Override
	public MatchDTO updateMatch(MatchDTO matchDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MatchDTO> findMatches() {
		List<MatchDTO> dtoList = new ArrayList<>();
		
		
		List<Matches> matches = matchesRepository.findAll();
		List<TeamMatch> teamMatches = teamMatchRepository.findAll();
		
		for (Matches match : matches) {
			for (TeamMatch teamMatch : teamMatches) {
				if(match.getId() == teamMatch.getMatch().getId()) {
					homeTeamMatch.
					dtoList.ad
				}
			}
		}
		dtoList.addAll(convertToDto(matches, homeTeamMatch, awayTeamMatch));
		return null;
	}

	@Override
	public Optional<MatchDTO> findMatchById(Long matchId) {
		// TODO Auto-generated method stub
		return null;
	}

	private MatchDTO convertToDto(Matches matches, TeamMatch homeTeamMatch, TeamMatch awayTeamMatch) {
		MatchDTO matchDto = new MatchDTO();

		if (matches.getId() == homeTeamMatch.getMatch().getId()
				&& matches.getId() == awayTeamMatch.getMatch().getId()) {

			matchDto.transform(matches);
			matchDto.setSportId(matches.getSport().getId());
			matchDto.setTournamentId(matches.getTournament().getId());
			matchDto.setDateOfMatch(matches.getDateMatch());
			matchDto.setHomeTeamId(homeTeamMatch.getMatch().getId());
			matchDto.setAwayTeamId(awayTeamMatch.getMatch().getId());
			matchDto.setHomeTeamScore(homeTeamMatch.getScoreTeamMatch());
			matchDto.setAwayTeamScore(awayTeamMatch.getScoreTeamMatch());
		}

		return matchDto;
	}

	private Matches getMatchFromDto(MatchDTO matchDto) {

		Sport sport = sportRepository.findById(matchDto.getSportId())
				.orElseThrow(() -> 
				new PersistenceException("Sport not found by Id: " + matchDto.getSportId()));

		Tournament tournament = tournamentRepository.findById(matchDto.getSportId())
				.orElseThrow(() -> 
				new PersistenceException("Tournament not found by Id: " + matchDto.getSportId()));

		LocalDateTime dateOfMatch = matchDto.getDateOfMatch();

		Matches match = new Matches(sport, tournament, dateOfMatch);
		matchDto.untransform(match);

		return match;
	}

	private TeamMatch getTeamMatchFromDto(MatchDTO matchDto, Matches match, boolean homeTeam) {
		if (match == null) {
			match = getMatchFromDto(matchDto);
		}
		Team team;
		Place place;
		int scoreTeam;

		if (homeTeam) {
			team = teamRepository.findById(matchDto.getHomeTeamId()).orElseThrow(
					() -> new PersistenceException("Home team not found by id: " + matchDto.getHomeTeamId()));
			place = Place.HOME;
			scoreTeam = matchDto.getHomeTeamScore();
		} else {
			team = teamRepository.findById(matchDto.getAwayTeamId()).orElseThrow(
					() -> new PersistenceException("Away team not found by id: " + matchDto.getAwayTeamId()));
			place = Place.AWAY;
			scoreTeam = matchDto.getAwayTeamScore();
		}

		return new TeamMatch(match, team, scoreTeam, place);
	}

	/*
	 * private Post convertToEntity(PostDto postDto) throws ParseException { Post
	 * post = modelMapper.map(postDto, Post.class); post.setSubmissionDate(
	 * postDto.getSubmissionDateConverted(userService.getCurrentUser().getPreference
	 * ().getTimezone()));
	 * 
	 * if (postDto.getId() != null) { Post oldPost =
	 * postService.getPostById(postDto.getId());
	 * post.setRedditID(oldPost.getRedditID()); post.setSent(oldPost.isSent()); }
	 * return post; }
	 */
}

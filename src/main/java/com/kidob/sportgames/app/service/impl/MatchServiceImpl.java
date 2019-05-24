package com.kidob.sportgames.app.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidob.sportgames.app.infra.exception.ConfigurationException;
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

/**
 * Default implementation of the {@link MatchService}
 * 
 * @author Bogdan
 *
 */
@Service
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
		TeamMatch homeTeamMatch = null;
		TeamMatch awayTeamMatch = null;
		
		if(matchesRepository.findById(match.getId()).isPresent()) {
			throw new ConfigurationException("The match by ID " + matchDto.getId() + " already exist");
		} else {
			match = getMatchFromDto(matchDto);
			homeTeamMatch = getTeamMatchFromDto(matchDto, match, true);
			awayTeamMatch = getTeamMatchFromDto(matchDto, match, false);
		
			matchesRepository.save(match);
			teamMatchRepository.save(homeTeamMatch);
			teamMatchRepository.save(awayTeamMatch);			
		}		
		return convertToDto(match, homeTeamMatch, awayTeamMatch);
	}

	@Override
	public MatchDTO updateMatch(MatchDTO matchDto) {

//		MatchDTO dto = findMatchById(matchDto.getId())
//				.orElseThrow(() -> new PersistenceException("Match not found by ID: " + matchDto.getId()));
//		
		Matches match = getMatchFromDto(matchDto);
		TeamMatch homeTeamMatch = teamMatchRepository.findTeamMatchByMatch(match, Place.HOME);		
		TeamMatch awayTeamMatch = teamMatchRepository.findTeamMatchByMatch(match, Place.AWAY);
////
////		matchesRepository.saveAndFlush(match);
////		teamMatchRepository.saveAndFlush(homeTeamMatch);
////		teamMatchRepository.saveAndFlush(awayTeamMatch);
//		return saveMatch(matchDto);
		Team homeTeam = teamRepository.findById(matchDto.getHomeTeamId())
				.orElseThrow(() ->new PersistenceException("Team not found by Id: "+matchDto.getHomeTeamId()));
		Team awayTeam = teamRepository.findById(matchDto.getAwayTeamId())
				.orElseThrow(() ->new PersistenceException("Team not found by Id: "+matchDto.getAwayTeamId()));
		
		homeTeamMatch.setMatch(match);
		awayTeamMatch.setMatch(match);
		homeTeamMatch.setTeam(homeTeam);
		awayTeamMatch.setTeam(awayTeam);
		homeTeamMatch.setScoreTeamMatch(matchDto.getHomeTeamScore());
		awayTeamMatch.setScoreTeamMatch(matchDto.getAwayTeamScore());
		
		matchesRepository.saveAndFlush(match);
		teamMatchRepository.saveAndFlush(homeTeamMatch);
		teamMatchRepository.saveAndFlush(awayTeamMatch);

		return convertToDto(match, homeTeamMatch, awayTeamMatch);
	}

	@Override
	public List<MatchDTO> findMatches() {
		List<MatchDTO> dtoList = new ArrayList<>();

		List<Matches> matches = matchesRepository.findAll();
		List<TeamMatch> teamMatches = teamMatchRepository.findAll();
		TeamMatch homeTeamMatch = new TeamMatch();
		TeamMatch awayTeamMatch = new TeamMatch();
		for (Matches match : matches) {
			for (TeamMatch teamMatch : teamMatches) {
				if (match.getId() == teamMatch.getMatch().getId()) {
					if (Place.HOME.equals(teamMatch.getPlace())) {
						homeTeamMatch.setMatch(match);
						homeTeamMatch.setTeam(teamMatch.getTeam());
						homeTeamMatch.setScoreTeamMatch(teamMatch.getScoreTeamMatch());
						homeTeamMatch.setPlace(Place.HOME);
					} else {
						awayTeamMatch.setMatch(match);
						awayTeamMatch.setTeam(teamMatch.getTeam());
						awayTeamMatch.setScoreTeamMatch(teamMatch.getScoreTeamMatch());
						awayTeamMatch.setPlace(Place.AWAY);
					}
				}
			}
			dtoList.add(convertToDto(match, homeTeamMatch, awayTeamMatch));
		}
		return dtoList;
	}

	@Override
	public Optional<MatchDTO> findMatchById(Long matchId) {
		Matches match = matchesRepository.findById(matchId)
				.orElseThrow(() -> new PersistenceException("Match not found by ID: " + matchId));
			
		TeamMatch homeTeamMatch = teamMatchRepository.findTeamMatchByMatch(match, Place.HOME);
		
		TeamMatch awayTeamMatch = teamMatchRepository.findTeamMatchByMatch(match, Place.AWAY);

		return Optional.of(convertToDto(match, homeTeamMatch, awayTeamMatch));
	}	

	private MatchDTO convertToDto(Matches matches, TeamMatch homeTeamMatch, TeamMatch awayTeamMatch) {
		MatchDTO matchDto = new MatchDTO();

		if (matches == null || homeTeamMatch == null || awayTeamMatch == null) {
			throw new ConfigurationException("All parameters must be not-null");
		}
		if (matches.getId() == homeTeamMatch.getMatch().getId()
				&& matches.getId() == awayTeamMatch.getMatch().getId()) {

			matchDto.transform(matches);
			matchDto.setSportId(matches.getSport().getId());
			matchDto.setTournamentId(matches.getTournament().getId());
			matchDto.setDateOfMatch(matches.getDateMatch());
			matchDto.setHomeTeamId(homeTeamMatch.getTeam().getId());
			matchDto.setAwayTeamId(awayTeamMatch.getTeam().getId());
			matchDto.setHomeTeamScore(homeTeamMatch.getScoreTeamMatch());
			matchDto.setAwayTeamScore(awayTeamMatch.getScoreTeamMatch());
		}

		return matchDto;
	}

	private Matches getMatchFromDto(MatchDTO matchDto) {

		Sport sport = sportRepository.findById(matchDto.getSportId())
				.orElseThrow(() -> new PersistenceException("Sport not found by Id: " + matchDto.getSportId()));

		Tournament tournament = tournamentRepository.findById(matchDto.getTournamentId()).orElseThrow(
				() -> new PersistenceException("Tournament not found by Id: " + matchDto.getTournamentId()));

		LocalDateTime dateOfMatch = matchDto.getDateOfMatch();

		Matches match = new Matches(sport, tournament, dateOfMatch);
		matchDto.untransform(match);

		return match;
	}

	private TeamMatch getTeamMatchFromDto(MatchDTO matchDto, Matches match, boolean homeTeam) {
		Team team;
		Place place;
		int scoreTeam;

		if (match == null) {
			match = getMatchFromDto(matchDto);
		}
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
}

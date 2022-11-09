package com.rafeed.wcteaminfodemo.ServiceImplementation;

import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityAlreadyExistsException;
import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityNotFoundException;
import com.rafeed.wcteaminfodemo.Enity.Country;
import com.rafeed.wcteaminfodemo.Enity.Team;
import com.rafeed.wcteaminfodemo.Repository.CountryRepository;
import com.rafeed.wcteaminfodemo.Repository.TeamRepository;
import com.rafeed.wcteaminfodemo.Service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImplementation implements TeamService {

    private TeamRepository teamRepository;
    private CountryRepository countryRepository;

    public TeamServiceImplementation(TeamRepository teamRepository,
                                     CountryRepository countryRepository) {
        this.teamRepository = teamRepository;
        this.countryRepository = countryRepository;
    }

    //save
    @Override
    public Team saveTeam(Team team) throws EntityNotFoundException, EntityAlreadyExistsException {
        Country country = countryRepository.getCountryByCountryNameIgnoreCase(team.getCountry().getCountryName());
        if(country == null){
            throw new EntityNotFoundException("Country with name: " + team.getCountry().getCountryName() + " does not exist!");
        }
        else{
            Team checkTeam = teamRepository.getTeamByTeamNameIgnoreCase(team.getTeamName());
            if(checkTeam != null){
                throw new EntityAlreadyExistsException("Team with name: " + team.getTeamName() + " already exist!");
            }
            else{
                checkTeam = teamRepository.save(team);
            }
            return checkTeam;
        }
    }

    //get team by id
    @Override
    public Team getTeamById(int teamId) throws EntityNotFoundException {
        Team checkTeam = teamRepository.getTeamByTeamId(teamId);
        if(checkTeam ==  null){
            throw new EntityNotFoundException("Team with id: " + teamId + " does not exist!");
        }
        return checkTeam;
    }

    //get team by name
    @Override
    public Team getTeamByName(String teamName) throws EntityNotFoundException {
        Team checkTeam = teamRepository.getTeamByTeamNameIgnoreCase(teamName);
        if(checkTeam == null){
            throw new EntityNotFoundException("Team with name: " + teamName + " does not exist!");
        }
        return checkTeam;
    }

    //get team by country
    @Override
    public Team getTeamByCountry(String countryName) throws EntityNotFoundException {
        Country checkCountry = countryRepository.getCountryByCountryNameIgnoreCase(countryName);
        if(checkCountry == null){
            throw new EntityNotFoundException("Country with name: " + countryName + " does not exist!");
        }
        else{
            Team team = teamRepository.getTeamByCountry(checkCountry);
            if(team == null){
                throw new EntityNotFoundException("Team with country: " + countryName + " does not exist!");
            }
            else{
                return team;
            }
        }
    }

    //update
    @Override
    public Team updateTeam(int teamId, Team team) throws EntityNotFoundException {
        Team checkTeam = teamRepository.getTeamByTeamId(teamId);
        if(checkTeam ==  null){
            throw new EntityNotFoundException("Team with id: " + teamId + " does not exist!");
        }
        else{
            checkTeam.setTeamName(team.getTeamName());
            checkTeam.setTeamPoints(team.getTeamPoints());
            checkTeam.setTeamPosition(team.getTeamPosition());
            checkTeam.setTeamGroup(team.getTeamGroup());
            checkTeam.setCountryId(team.getCountryId());
            return teamRepository.save(checkTeam);
        }
    }

    //get all teams
    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    //delete
    @Override
    public void deleteTeam(int teamId) throws EntityNotFoundException {
        Team checkTeam = teamRepository.getTeamByTeamId(teamId);
        if(checkTeam == null){
            throw new EntityNotFoundException("Team with id: " + teamId + " does not exist!");
        }
        teamRepository.delete(checkTeam);
    }
}

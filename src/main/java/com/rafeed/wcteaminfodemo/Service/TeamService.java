package com.rafeed.wcteaminfodemo.Service;

import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityAlreadyExistsException;
import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityNotFoundException;
import com.rafeed.wcteaminfodemo.Enity.Team;

import java.util.List;

public interface TeamService {
    Team saveTeam(Team team) throws EntityNotFoundException, EntityAlreadyExistsException;
    Team getTeamById(int teamId) throws EntityNotFoundException;
    Team getTeamByName(String teamName) throws EntityNotFoundException;
    Team getTeamByCountry(String countryName) throws EntityNotFoundException;
    Team updateTeam(int teamId, Team team) throws EntityNotFoundException;
    List<Team> getAllTeams();
    void deleteTeam(int teamId) throws EntityNotFoundException;
}

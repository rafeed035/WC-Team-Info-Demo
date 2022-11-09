package com.rafeed.wcteaminfodemo.Controller;

import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityAlreadyExistsException;
import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityNotFoundException;
import com.rafeed.wcteaminfodemo.Enity.Team;
import com.rafeed.wcteaminfodemo.Service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/team")
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/save")
    public Team saveTeam(@RequestBody Team team) throws EntityAlreadyExistsException, EntityNotFoundException {
        return teamService.saveTeam(team);
    }

    @GetMapping("/getById")
    public Team getTeamById(@RequestParam int teamId) throws EntityNotFoundException {
        return teamService.getTeamById(teamId);
    }

    @GetMapping("/getByName")
    public Team getTeamByName(@RequestParam String teamName) throws EntityNotFoundException {
        return teamService.getTeamByName(teamName);
    }

    @GetMapping("/getByCountry")
    public Team getTeamByCountryName(@RequestParam String countryName) throws EntityNotFoundException {
        return teamService.getTeamByCountry(countryName);
    }

    @PutMapping("/update")
    public Team updateTeam(@RequestParam int teamId,
                           @RequestBody Team team) throws EntityNotFoundException {
        return teamService.updateTeam(teamId, team);
    }

    @GetMapping("/getAll")
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @DeleteMapping("/delete")
    public String deleteTeam(@RequestParam int teamId) throws EntityNotFoundException {
        teamService.deleteTeam(teamId);
        return "Deleted Successfully!";
    }
}

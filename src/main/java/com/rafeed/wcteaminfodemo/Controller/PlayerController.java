package com.rafeed.wcteaminfodemo.Controller;

import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityAlreadyExistsException;
import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityNotFoundException;
import com.rafeed.wcteaminfodemo.Enity.Player;
import com.rafeed.wcteaminfodemo.Service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/save")
    public Player savePlayer(@RequestBody Player player) throws EntityAlreadyExistsException, EntityNotFoundException {
        return playerService.savePlayer(player);
    }

    @GetMapping("/by-id")
    public Player getPlayerByPlayerId(@RequestParam int playerId) throws EntityNotFoundException {
        return playerService.getPlayerByPlayerId(playerId);
    }

    @GetMapping("/by-name")
    public List<Player> getPlayersByName(@RequestParam String playerName) throws EntityNotFoundException {
        return playerService.getPlayersByName(playerName);
    }

    @GetMapping("/by-team")
    public List<Player> getPlayersByTeam(@RequestParam String teamName) throws EntityNotFoundException {
        return playerService.getPlayersByTeam(teamName);
    }

    @GetMapping("/by-country")
    public List<Player> getPlayersByCountry(@RequestParam String countryName) throws EntityNotFoundException {
        return playerService.getPlayersByCountry(countryName);
    }

    @GetMapping("/by-score")
    public List<Player> getPlayersByScoreGreaterThan(@RequestParam int score){
        return playerService.getPlayersByScoreGreaterThan(score);
    }

    @GetMapping("/all")
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @PutMapping("/update")
    public Player updatePlayer(@RequestParam int playerId,
                               @RequestBody Player player) throws EntityNotFoundException {
        return playerService.updatePlayer(playerId, player);
    }

    @DeleteMapping("/delete")
    public String deletePlayer(@RequestParam int playerId) throws EntityNotFoundException {
        playerService.deletePlayer(playerId);
        return "Deleted Successfully";
    }
}

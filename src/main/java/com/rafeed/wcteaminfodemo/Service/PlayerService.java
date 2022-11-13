package com.rafeed.wcteaminfodemo.Service;

import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityAlreadyExistsException;
import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityNotFoundException;
import com.rafeed.wcteaminfodemo.Enity.Player;

import java.util.List;

public interface PlayerService {
    Player savePlayer(Player player) throws EntityAlreadyExistsException, EntityNotFoundException;
    Player getPlayerByPlayerId(int playerId) throws EntityNotFoundException;
    List<Player> getPlayersByName(String playerName) throws EntityNotFoundException;
    List<Player> getPlayersByCountry(String countryName) throws EntityNotFoundException;
    List<Player> getPlayersByTeam(String teamName) throws EntityNotFoundException;
    List<Player> getPlayersByScoreGreaterThan(int score);
    List<Player> getAllPlayers();
    Player updatePlayer(int playerId, Player player) throws EntityNotFoundException;
    void deletePlayer(int playerId) throws EntityNotFoundException;
}

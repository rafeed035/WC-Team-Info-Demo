package com.rafeed.wcteaminfodemo.ServiceImplementation;

import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityAlreadyExistsException;
import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityNotFoundException;
import com.rafeed.wcteaminfodemo.Enity.Country;
import com.rafeed.wcteaminfodemo.Enity.Player;
import com.rafeed.wcteaminfodemo.Enity.Team;
import com.rafeed.wcteaminfodemo.Repository.CountryRepository;
import com.rafeed.wcteaminfodemo.Repository.PlayerRepository;
import com.rafeed.wcteaminfodemo.Repository.TeamRepository;
import com.rafeed.wcteaminfodemo.Service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImplementation implements PlayerService {

    private PlayerRepository playerRepository;
    private CountryRepository countryRepository;
    private TeamRepository teamRepository;

    public PlayerServiceImplementation(PlayerRepository playerRepository,
                                       CountryRepository countryRepository,
                                       TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.countryRepository = countryRepository;
        this.teamRepository = teamRepository;
    }

    //save
    @Override
    public Player savePlayer(Player player) throws EntityAlreadyExistsException, EntityNotFoundException {
        Country checkCountry = countryRepository.getCountryByCountryId(player.getCountryId());
        Team checkTeam = teamRepository.getTeamByTeamId(player.getTeamId());
        if(checkCountry == null || checkTeam == null){
            throw new EntityNotFoundException("Team or Country not found!");
        }
        else{
            List<Player> checkPlayers = playerRepository.getPlayersByPlayerNameIgnoreCase(player.getPlayerName());
            if(checkPlayers.isEmpty()){
                return playerRepository.save(player);
            }
            else{
                for(int i = 0; i < checkPlayers.size(); i++ ){
                    if(checkPlayers.get(i).equals(player)){
                        throw new EntityAlreadyExistsException("Player already exists!");
                    }
                }
                return playerRepository.save(player);
            }
        }
    }

    //get player by id
    @Override
    public Player getPlayerByPlayerId(int playerId) throws EntityNotFoundException {
        Player checkPlayer = playerRepository.getPlayerByPlayerId(playerId);
        if(checkPlayer == null){
            throw new EntityNotFoundException("Player with id: " + playerId + " does not exist1");
        }
        return checkPlayer;
    }

    //get players by name
    @Override
    public List<Player> getPlayersByName(String playerName) throws EntityNotFoundException {
        List<Player> checkPlayers = playerRepository.getPlayersByPlayerNameIgnoreCase(playerName);
        if(checkPlayers.isEmpty()){
            throw new EntityNotFoundException("Players with name: " + playerName + " does not exist!");
        }
        return checkPlayers;
    }

    //get players by country
    @Override
    public List<Player> getPlayersByCountry(String countryName) throws EntityNotFoundException {
        Country country = countryRepository.getCountryByCountryNameIgnoreCase(countryName);
        if(country == null){
            throw new EntityNotFoundException("Country with name: " + countryName + " does not exist!");
        }
        else{
            List<Player> checkPlayers = playerRepository.getPlayersByCountry(country);
            if(checkPlayers.isEmpty()){
                throw new EntityNotFoundException("Players of country: " + country.getCountryName() + " do not exist!");
            }
            else{
                return checkPlayers;
            }
        }
    }

    //get players by team
    @Override
    public List<Player> getPlayersByTeam(String teamName) throws EntityNotFoundException {
        Team team = teamRepository.getTeamByTeamNameIgnoreCase(teamName);
        if(team == null){
            throw new EntityNotFoundException("Team with name: " + teamName + " does not exist!");
        }
        else{
            List<Player> checkPlayers = playerRepository.getPlayersByTeam(team);
            if(checkPlayers.isEmpty()){
                throw new EntityNotFoundException("Players of Team: " + teamName + " do not exist!");
            }
            else{
                return checkPlayers;
            }
        }
    }

    //get players by score
    @Override
    public List<Player> getPlayersByScoreGreaterThan(int score) {
        List<Player> checkPlayers = playerRepository.getPlayersByPlayerScoreGreaterThan(score);
        return checkPlayers;
    }

    //get all players
    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    //update
    @Override
    public Player updatePlayer(int playerId,
                               Player player) throws EntityNotFoundException {
        Player checkPlayer = playerRepository.getPlayerByPlayerId(playerId);
        if(checkPlayer == null){
            throw new EntityNotFoundException("Player with id: " + playerId + " does not exist!");
        }
        else{
            checkPlayer.setPlayerName(player.getPlayerName());
            checkPlayer.setPlayerScore(player.getPlayerScore());
            checkPlayer.setPlayerSpecification(player.getPlayerSpecification());
            checkPlayer.setPlayerStrikeRate(player.getPlayerStrikeRate());
            checkPlayer.setTeamId(player.getTeamId());
            checkPlayer.setCountryId(player.getCountryId());
            return playerRepository.save(checkPlayer);
        }
    }

    //delete
    @Override
    public void deletePlayer(int playerId) throws EntityNotFoundException {
        Player checkPlayer = playerRepository.getPlayerByPlayerId(playerId);
        if(checkPlayer == null){
            throw new EntityNotFoundException("Player with id: " + playerId + " does not exist!");
        }
        playerRepository.delete(checkPlayer);
    }
}

package com.rafeed.wcteaminfodemo.Repository;

import com.rafeed.wcteaminfodemo.Enity.Country;
import com.rafeed.wcteaminfodemo.Enity.Player;
import com.rafeed.wcteaminfodemo.Enity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Player getPlayerByPlayerId(int playerId);
    List<Player> getPlayersByPlayerName(String playerName);
    List<Player> getPlayersByCountry(Country country);
    List<Player> getPlayersByTeam(Team team);
    List<Player> getPlayersByPlayerScoreGreaterThan(int score);
}

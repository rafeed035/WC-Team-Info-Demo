package com.rafeed.wcteaminfodemo.Service;

import com.rafeed.wcteaminfodemo.Enity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Player getPlayerByPlayerId(int playerId);
    List<Player> getPlayersByPlayerName(String playerName);
}

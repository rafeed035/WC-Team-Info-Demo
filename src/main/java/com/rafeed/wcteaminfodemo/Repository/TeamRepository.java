package com.rafeed.wcteaminfodemo.Repository;

import com.rafeed.wcteaminfodemo.Enity.Country;
import com.rafeed.wcteaminfodemo.Enity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
    Team getTeamByTeamId(int teamId);
    Team getTeamByTeamNameIgnoreCase(String teamName);
    Team getTeamByCountry(Country country);
}

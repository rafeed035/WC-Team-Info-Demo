package com.rafeed.wcteaminfodemo.Repository;

import com.rafeed.wcteaminfodemo.Enity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country getCountryByCountryId(int countryId);
    Country getCountryByCountryName(String countryName);
}

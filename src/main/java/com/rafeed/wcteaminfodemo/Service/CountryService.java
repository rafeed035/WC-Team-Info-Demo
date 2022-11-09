package com.rafeed.wcteaminfodemo.Service;

import com.rafeed.wcteaminfodemo.Enity.Country;

import java.util.List;

public interface CountryService {
    Country saveCountry(Country country);
    Country getCountryById(int countryId);
    Country getCountryByName(String countryName);
    Country updateCountry(int countryId, Country country);
    List<Country> getAllCountries();
    void deleteCountry(int countryId);
}

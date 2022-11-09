package com.rafeed.wcteaminfodemo.Service;

import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityAlreadyExistsException;
import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityNotFoundException;
import com.rafeed.wcteaminfodemo.Enity.Country;

import java.util.List;

public interface CountryService {
    Country saveCountry(Country country) throws EntityAlreadyExistsException;
    Country getCountryById(int countryId) throws EntityNotFoundException;
    Country getCountryByName(String countryName) throws EntityNotFoundException;
    Country updateCountry(int countryId, Country country) throws EntityNotFoundException;
    List<Country> getAllCountries();
    void deleteCountry(int countryId) throws EntityNotFoundException;
}

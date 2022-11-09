package com.rafeed.wcteaminfodemo.ServiceImplementation;

import com.rafeed.wcteaminfodemo.Enity.Country;
import com.rafeed.wcteaminfodemo.Repository.CountryRepository;
import com.rafeed.wcteaminfodemo.Service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImplementation implements CountryService {

    private CountryRepository countryRepository;

    public CountryServiceImplementation(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country saveCountry(Country country) {
        return null;
    }

    @Override
    public Country getCountryById(int countryId) {
        return null;
    }

    @Override
    public Country getCountryByName(String countryName) {
        return null;
    }

    @Override
    public Country updateCountry(int countryId, Country country) {
        return null;
    }

    @Override
    public List<Country> getAllCountries() {
        return null;
    }

    @Override
    public void deleteCountry(int countryId) {

    }
}

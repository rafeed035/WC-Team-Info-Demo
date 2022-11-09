package com.rafeed.wcteaminfodemo.ServiceImplementation;

import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityAlreadyExistsException;
import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityNotFoundException;
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

    //save country
    @Override
    public Country saveCountry(Country country) throws EntityAlreadyExistsException {
        Country checkCountry = countryRepository.getCountryByCountryName(country.getCountryName());
        if(checkCountry != null){
            throw new EntityAlreadyExistsException("Country with name: " + country.getCountryName() + " already exist!");
        }
        else{
            return countryRepository.save(country);
        }
    }

    //get country by id
    @Override
    public Country getCountryById(int countryId) throws EntityNotFoundException {
        Country checkCountry = countryRepository.getCountryByCountryId(countryId);
        if(checkCountry == null){
            throw new EntityNotFoundException("Country with id: " + countryId + " does not exist!");
        }
        return checkCountry;
    }

    //get country by name
    @Override
    public Country getCountryByName(String countryName) throws EntityNotFoundException {
        Country checkCountry = countryRepository.getCountryByCountryName(countryName);
        if(checkCountry == null){
            throw new EntityNotFoundException("Entity with name: " + countryName + " does not exist!");
        }
        return checkCountry;
    }

    //update
    @Override
    public Country updateCountry(int countryId,
                                 Country country) throws EntityNotFoundException {
        Country checkCountry = countryRepository.getCountryByCountryId(countryId);
        if(checkCountry == null){
            throw new EntityNotFoundException("Country with id: " + countryId + " does not exist!");
        }
        else{
            checkCountry.setCountryName(country.getCountryName());
            countryRepository.save(checkCountry);
            return checkCountry;
        }
    }

    //get All Countries
    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    //delete
    @Override
    public void deleteCountry(int countryId) throws EntityNotFoundException {
        Country checkCountry = countryRepository.getCountryByCountryId(countryId);
        if(checkCountry == null){
            throw new EntityNotFoundException("Country with id: " + countryId + " does not exist!");
        }
        countryRepository.delete(checkCountry);
    }
}

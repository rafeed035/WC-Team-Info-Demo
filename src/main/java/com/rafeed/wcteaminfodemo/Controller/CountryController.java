package com.rafeed.wcteaminfodemo.Controller;

import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityAlreadyExistsException;
import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityNotFoundException;
import com.rafeed.wcteaminfodemo.Enity.Country;
import com.rafeed.wcteaminfodemo.Service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {

    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/save")
    public Country saveCountry(@RequestBody Country country) throws EntityAlreadyExistsException{
        return countryService.saveCountry(country);
    }

    @GetMapping("/by-id")
    public Country getCountryById(@RequestParam int countryId) throws EntityNotFoundException {
        return countryService.getCountryById(countryId);
    }

    @GetMapping("/by-name")
    public Country getCountryByName(@RequestParam String countryName) throws EntityNotFoundException {
        return countryService.getCountryByName(countryName);
    }

    @GetMapping("/all")
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }

    @PutMapping("/update")
    public Country updateCountry(@RequestParam int countryId,
                                 @RequestBody Country country) throws EntityNotFoundException {
        return countryService.updateCountry(countryId, country);
    }

    @DeleteMapping("/delete")
    public String deleteCountry(@RequestParam int countryId) throws EntityNotFoundException {
        countryService.deleteCountry(countryId);
        return "Deleted Successfully";
    }
}

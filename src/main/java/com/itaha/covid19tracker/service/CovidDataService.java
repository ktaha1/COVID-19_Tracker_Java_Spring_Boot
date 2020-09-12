package com.itaha.covid19tracker.service;


import com.itaha.covid19tracker.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CovidDataService {

    @Autowired
    private RestTemplate restTemplate;

    private static String COVID_DATA_GLOBAL_URL="https://disease.sh/v3/covid-19/all";
    private static String COVID_DATA_COUNTRY_URL="https://disease.sh/v3/covid-19/countries/";


    // Fetch data of all countries
    public Country fetchGlobal() {
        Country global=restTemplate.getForObject(COVID_DATA_GLOBAL_URL, Country.class);
        global.setCountry("Global");  // set a value that came empty
        return global;
    }

    // Fetch data of a selected country
    public Country getCountry(String iso3){
        Country country = restTemplate.getForObject(COVID_DATA_COUNTRY_URL+iso3, Country.class);
        return country;
    }




}

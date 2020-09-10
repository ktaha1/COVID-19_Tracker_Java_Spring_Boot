package com.itaha.covid19tracker.service;


import com.itaha.covid19tracker.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CovidDataService {

    @Autowired
    private RestTemplate restTemplate;

    public Country fetchGlobal() {
        String url = "https://disease.sh/v3/covid-19/all";
        Country global=restTemplate.getForObject(url, Country.class);
        global.setCountry("Global");
        return global;
    }

    public Country getCountry(String iso3){
        String url = "https://disease.sh/v3/covid-19/countries/"+iso3;
        Country country = restTemplate.getForObject(url, Country.class);
        return country;
    }




}

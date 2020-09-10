package com.itaha.covid19tracker.service;


import com.itaha.covid19tracker.model.Country;
import com.itaha.covid19tracker.model.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CovidDataService {

    @Autowired
    private RestTemplate restTemplate;

    public Global fetchGlobal() {
        String url = "https://disease.sh/v3/covid-19/all";
        Global global=restTemplate.getForObject(url, Global.class);
        return global;
    }

    public Country getCountry(String iso3){
        String url = "https://disease.sh/v3/covid-19/countries/"+iso3;
        Country country = restTemplate.getForObject(url, Country.class);
        return country;
    }




}

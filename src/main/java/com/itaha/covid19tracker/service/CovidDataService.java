package com.itaha.covid19tracker.service;


import com.itaha.covid19tracker.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CovidDataService {

    @Autowired
    private RestTemplate restTemplate;

    private static String COVID_DATA_GLOBAL_URL="https://disease.sh/v3/covid-19/all";
    private static String COVID_DATA_COUNTRY_URL="https://disease.sh/v3/covid-19/countries/";



    // Fetch the global data
    public Country getGlobalData(){
        Country country = restTemplate.getForObject(COVID_DATA_GLOBAL_URL, Country.class);
        country.setCountry("Global");
        return country;
    }


    // Fetch data of a country
    public Country getCountry(String iso3) {
        ResponseEntity resp =
                restTemplate.getForEntity(COVID_DATA_COUNTRY_URL+iso3, Country.class);

        if (resp.getStatusCode() == HttpStatus.OK) return (Country) resp.getBody();
        else return getGlobalData();
    }







}

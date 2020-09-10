package com.itaha.covid19tracker.controller;

import com.itaha.covid19tracker.service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/myapp")
public class CovidDataController {

   @Autowired
    private CovidDataService covidDataService;

    @GetMapping("/")
    public ModelAndView getAll(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("data",covidDataService.fetchGlobal());
        mv.setViewName("display");
        return mv;
    }

    @GetMapping("/country/{iso3}")
    public ModelAndView getCountry(@PathVariable("iso3") String iso3){
        ModelAndView mv = new ModelAndView();
        mv.addObject("data",covidDataService.getCountry(iso3));
        mv.setViewName("display");
        return mv;
    }
}

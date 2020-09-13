package com.itaha.covid19tracker.controller;

import com.itaha.covid19tracker.service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/covid19tracker")
public class CovidDataController {

   @Autowired
    private CovidDataService covidDataService;

    @RequestMapping("/home")
    public ModelAndView getAll(@RequestParam(required = false) String iso3){
        ModelAndView mv = new ModelAndView();
        if(iso3==null || iso3=="")
            mv.addObject("data",covidDataService.getGlobalData());
        else
            mv.addObject("data",covidDataService.getCountry(iso3));
        mv.setViewName("display");
        return mv;
    }


}

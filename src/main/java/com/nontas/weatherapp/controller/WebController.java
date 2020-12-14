package com.nontas.weatherapp.controller;

import com.nontas.weatherapp.model.OpenWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class WebController {

    @Autowired
    private OpenWeather openWeatherAndros;

    @GetMapping("/weather")
    public String weather(Model model){
//        System.out.println(openWeatherAndros.toString());
        model.addAttribute("openWeather",openWeatherAndros);
        return "/weather";
    }

    @GetMapping("/andros")
    public String weatherInAndros(Model model){
//        System.out.println(openWeatherAndros.toString());
        model.addAttribute("openWeather",openWeatherAndros);
        return "/andros";
    }

}

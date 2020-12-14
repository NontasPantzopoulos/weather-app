package com.nontas.weatherapp.controller;

import com.nontas.weatherapp.model.OpenWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @Autowired
    private OpenWeather openWeatherAndros;

    @GetMapping("/andros-rest")
    public OpenWeather androsWeather(){
        return openWeatherAndros;
    }

}

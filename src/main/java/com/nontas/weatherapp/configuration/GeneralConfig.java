package com.nontas.weatherapp.configuration;

import com.nontas.weatherapp.model.City;
import com.nontas.weatherapp.model.OpenWeather;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class GeneralConfig {
    @Bean
    public OpenWeather openWeatherAndros(){
        return new OpenWeather();
    }

}

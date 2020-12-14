package com.nontas.weatherapp.configuration;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nontas.weatherapp.model.City;
import com.nontas.weatherapp.model.OpenWeather;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class GeneralConfig {
    @Bean
    public OpenWeather openWeatherAndros(){
        return new OpenWeather();
    }

    @Bean
    public HashMap<Integer,City> listOfGreekCities(){
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("city.list.json").getFile());
            HashMap<Integer,City> greekCities = new HashMap<>();
            ObjectMapper mapper = new ObjectMapper();
            List<City> cities = new ArrayList<>();
            JsonFactory factory = new JsonFactory();
            JsonParser parser = factory.createParser(file);
            TypeReference<List<City>> tRef = new TypeReference<List<City>>() {};
            cities = mapper.readValue(parser, tRef);

            for(City city : cities){
                if(city.getCountry().equals("GR")){
                    greekCities.put(city.getId(), city);
                }
            }
            return greekCities;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

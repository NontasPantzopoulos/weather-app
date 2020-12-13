package com.nontas.weatherapp;

import com.nontas.weatherapp.model.OpenWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@EnableScheduling
public class AppStartupRunner implements ApplicationRunner {

    @Autowired
    private OpenWeather openWeatherAndros;

    @Value("${openweather.api.key}")
    private String myapikey;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

    @Scheduled(initialDelay = 2000, fixedDelayString = "60000")
    void getWeather(){
        String url = "http://api.openweathermap.org/data/2.5/weather?q=Andros&units=metric&lang=el&appid="+myapikey;
        OpenWeather openWeather = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            openWeather = restTemplate.getForObject(url, OpenWeather.class);
            openWeatherAndros.setCoord(openWeather.getCoord());
            openWeatherAndros.setWeather(openWeather.getWeather());
            openWeatherAndros.setBase(openWeather.getBase());
            openWeatherAndros.setClouds(openWeather.getClouds());
            openWeatherAndros.setMain(openWeather.getMain());
            openWeatherAndros.setSys(openWeather.getSys());
            openWeatherAndros.setWind(openWeatherAndros.getWind());

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

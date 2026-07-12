package idk.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idk.example.demo.dto.weatherDtos.MonthlyWeatherResponse;
import idk.example.demo.dto.weatherDtos.WeatherResponse;
import idk.example.demo.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {

private final WeatherService wService;

public WeatherController(WeatherService wService){
    this.wService=wService;
}


@GetMapping("/temperature")    
public double getTemp(@RequestParam String city){
return wService.getTemp(city);    
}

@GetMapping("")
public WeatherResponse getWheather(@RequestParam String city){
    return wService.getWeather(city);
}



@GetMapping("/monthly")
public MonthlyWeatherResponse gMonthlyWeatherResponse(@RequestParam String city, @RequestParam int month ){
    return wService.getMonthlyData(city, month);
}


}

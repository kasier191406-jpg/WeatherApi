package idk.example.demo.controller;

import idk.example.demo.service.HistoryService;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idk.example.demo.dto.weatherDtos.HistoryDto;
import idk.example.demo.dto.weatherDtos.MonthlyWeatherResponse;
import idk.example.demo.dto.weatherDtos.WeatherResponse;
import idk.example.demo.entity.User;
import idk.example.demo.entity.UserHistory;
import idk.example.demo.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {

private final HistoryService historyService;
private final WeatherService wService;

public WeatherController(WeatherService wService, HistoryService historyService){
    this.wService=wService;
    this.historyService = historyService;
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


@GetMapping("/history")
public List<HistoryDto> history(){
   return historyService.getRecentHistory();
}


}

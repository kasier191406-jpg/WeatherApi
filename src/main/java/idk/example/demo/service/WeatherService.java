package idk.example.demo.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import idk.example.demo.dto.weatherDtos.MonthlyWeatherResponse;
import idk.example.demo.dto.weatherDtos.WeatherResponse;
import idk.example.demo.entity.User;
import idk.example.demo.entity.UserHistory;
import idk.example.demo.repo.UserRepo;

@Service
public class WeatherService {

    @Autowired
    UserRepo userRepo;

    private final HistoryService historyService;
    private final RestClient restClient;
    private final UserHistory uHistory;
    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherService(RestClient restClient,UserHistory uHistory, HistoryService historyService){
            this.restClient=restClient;
            this.uHistory=uHistory;
            this.historyService = historyService;
    }



    public double getTemp(String city){
   
    WeatherResponse wheatherResponse= getWeather(city);
     double temp=wheatherResponse.getMain().getTemperature(); 
     return temp;
    }


    public WeatherResponse getWeather(String city){

        String username = SecurityContextHolder.getContext()
        .getAuthentication()
        .getName();

User user = userRepo.findByUsername(username)
        .orElseThrow();

historyService.saveHistory(user, city);
URI uri = UriComponentsBuilder.newInstance()
        .scheme("https")
        .host("api.openweathermap.org")
        .path("/data/2.5/weather")
        .queryParam("q", city)
        .queryParam("appid", apiKey)
        .build()
        .toUri();

System.out.println(uri);

return restClient.get()
        .uri(uri)
        .retrieve()
        .body(WeatherResponse.class);
    }

    public MonthlyWeatherResponse getMonthlyData(String city,int month){
        String username = SecurityContextHolder.getContext()
        .getAuthentication()
        .getName();

User user = userRepo.findByUsername(username)
        .orElseThrow();

historyService.saveHistory(user, city);
         MonthlyWeatherResponse monthlyWheatherResponse =restClient.get().uri(uriBuilder->uriBuilder
            .scheme("https").host("history.openweathermap.org").
            path("/data/2.5/aggregated/month").
            queryParam("q", city).
            queryParam("month", month).
            queryParam("appid",apiKey).build())
            .retrieve().body(MonthlyWeatherResponse.class);
        return monthlyWheatherResponse;
    }


}

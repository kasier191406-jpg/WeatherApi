package idk.example.demo.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import idk.example.demo.dto.MonthlyWeatherResponse;
import idk.example.demo.dto.WeatherResponse;

@Service
public class WeatherService {

    private final RestClient restClient;

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherService(RestClient restClient){
            this.restClient=restClient;
    }



    public double getTemp(String city){
        
    WeatherResponse wheatherResponse= getWeather(city);
     double temp=wheatherResponse.getMain().getTemperature(); 
     return temp;
    }


    public WeatherResponse getWeather(String city){
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

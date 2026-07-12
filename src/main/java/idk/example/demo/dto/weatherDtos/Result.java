package idk.example.demo.dto.weatherDtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private int month;
    @JsonProperty("temp")
    private Temperature temperature;
    
    private Pressure pressure;

    private Humidity humidity;

    private Wind wind;

    private Cloud clouds;

    @JsonProperty("sunshine_hours")
    private double sunnyHrs;
}

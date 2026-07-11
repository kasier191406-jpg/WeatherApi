package idk.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse {
    @JsonProperty("main")
    private Main main;

    @JsonProperty("base")
    private String base;

    private int visibility;

    private Wind wind;

    private Rain rain;

}

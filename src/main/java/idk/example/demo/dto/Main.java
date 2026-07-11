package idk.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Main{

 @JsonProperty("temp")    
private double temperature;
@JsonProperty("feels_like")
private double feelsLike;
@JsonProperty("temp_min")
private double tempMin;
@JsonProperty("temp_max")
private double tempMax;
@JsonProperty("pressure")
private int pressure;
@JsonProperty("humidity")
private int humidity;
@JsonProperty("sea_level")
private int seaLevel;
@JsonProperty("grnd_level")
private int groundLevel;
}

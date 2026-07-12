package idk.example.demo.dto.weatherDtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wind {
    private double speed;
    @JsonProperty("deg")
    private int degreeOfTemprature;
    private double gust;

    
   

}

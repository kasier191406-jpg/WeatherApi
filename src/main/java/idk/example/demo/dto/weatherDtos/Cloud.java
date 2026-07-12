package idk.example.demo.dto.weatherDtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cloud {
    @JsonProperty("all")
    private int cloudCoverage;

    
    private double min;
    private double max;

    private double median;
    private double mean;


}

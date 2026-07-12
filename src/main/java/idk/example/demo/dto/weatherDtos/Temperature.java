package idk.example.demo.dto.weatherDtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Temperature {
    @JsonProperty("record_min")
    private double min;
    @JsonProperty("record_max")
    private double max;
    @JsonProperty("average_min")
    private double avgMin;
    @JsonProperty("average_max")
    private double avgMax;
    private double median;
    private double mean;
    
}

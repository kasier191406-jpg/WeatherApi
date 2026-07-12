package idk.example.demo.dto.weatherDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Humidity {

    private double min;
    private double max;

    private double median;
    private double mean;

}

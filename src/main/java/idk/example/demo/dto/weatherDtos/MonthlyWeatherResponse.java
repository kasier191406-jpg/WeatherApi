package idk.example.demo.dto.weatherDtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyWeatherResponse {

private List<Result> result;

}

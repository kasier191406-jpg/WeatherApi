package idk.example.demo.dto.weatherDtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDto {

    private String city;
    private LocalDateTime searchedAt;

}
package idk.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import idk.example.demo.dto.weatherDtos.HistoryDto;
import idk.example.demo.entity.User;
import idk.example.demo.entity.UserHistory;
import idk.example.demo.repo.HistoryRepo;
import idk.example.demo.repo.UserRepo;

@Service
public class HistoryService {

    private final HistoryRepo hRepo;

    @Autowired
    UserRepo userRepo;
    public HistoryService(HistoryRepo hRepo){
        this.hRepo=hRepo;
    }  

    public void saveHistory(User user,String city){
        UserHistory uHistory = new UserHistory();
        uHistory.setUser(user);
        uHistory.setCity(city);
        uHistory.setSearchedAt(LocalDateTime.now());
        hRepo.save(uHistory);
    }

public List<HistoryDto> getRecentHistory() {
     String username = SecurityContextHolder.getContext()
        .getAuthentication()
        .getName();

User user = userRepo.findByUsername(username)
        .orElseThrow();

        List<UserHistory> history =
            hRepo.findTop10ByUserOrderBySearchedAtDesc(user);

    return history.stream()
            .map(h -> new HistoryDto(
                    h.getCity(),
                    h.getSearchedAt()
            ))
            .toList();
}

}

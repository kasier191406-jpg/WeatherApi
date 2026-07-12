package idk.example.demo.service;

import java.time.LocalDateTime;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Service;

import idk.example.demo.entity.UserHistory;
import idk.example.demo.repo.HistoryRepo;

@Service
public class HistoryService {

    private final HistoryRepo hRepo;

    public HistoryService(HistoryRepo hRepo){
        this.hRepo=hRepo;
    }  




}

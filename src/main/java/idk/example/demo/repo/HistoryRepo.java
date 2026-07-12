package idk.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idk.example.demo.entity.UserHistory;

@Repository
public interface HistoryRepo extends JpaRepository<UserHistory,Integer> {

}

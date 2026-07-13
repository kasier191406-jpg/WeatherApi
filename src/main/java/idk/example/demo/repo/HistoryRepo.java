package idk.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idk.example.demo.entity.User;
import idk.example.demo.entity.UserHistory;

@Repository
public interface HistoryRepo extends JpaRepository<UserHistory,Integer> {
 List<UserHistory> findTop10ByUserOrderBySearchedAtDesc(User user);
}

package idk.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idk.example.demo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

   public Optional<User> findByUsername(String username);

   public Optional<User> findByEmail(String email);

}

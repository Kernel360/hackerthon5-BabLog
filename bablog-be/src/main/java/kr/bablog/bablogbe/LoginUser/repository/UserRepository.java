package kr.bablog.bablogbe.LoginUser.repository;

import kr.bablog.bablogbe.LoginUser.DTO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

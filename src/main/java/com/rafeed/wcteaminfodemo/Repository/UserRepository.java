package com.rafeed.wcteaminfodemo.Repository;

import com.rafeed.wcteaminfodemo.Enity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByUserId(int userId);
    User getUserByEmailIgnoreCase(String email);
}

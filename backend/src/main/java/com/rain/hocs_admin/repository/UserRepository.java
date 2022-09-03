package com.rain.hocs_admin.repository;

import com.rain.hocs_admin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rain
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  public User findUserByUsername(String username);
}

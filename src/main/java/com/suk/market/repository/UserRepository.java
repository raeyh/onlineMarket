package com.suk.market.repository;

import com.suk.market.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
    @Query(value = "Select * from User where username = ? LIMIT 1", nativeQuery = true)
    public User findUserByUsername(@Param("username") String username);
    @Query(value = "Select * from User where username = ? and password = ? LIMIT 1", nativeQuery = true)
    public User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}

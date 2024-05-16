package com.System_Design_Project.repo;



import com.System_Design_Project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {

        Optional<User> findOneByTelNumberAndPassword(String telNumber, String password);

        User findUserByTelNumber(String telNumber);
}

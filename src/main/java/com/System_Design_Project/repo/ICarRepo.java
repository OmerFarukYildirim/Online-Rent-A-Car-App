package com.System_Design_Project.repo;

import com.System_Design_Project.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

//import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface ICarRepo extends JpaRepository<Car, Integer> {

    Car findCarByType(String type);
}

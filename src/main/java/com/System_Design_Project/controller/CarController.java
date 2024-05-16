package com.System_Design_Project.controller;

import com.System_Design_Project.dto.CarDTO;
import com.System_Design_Project.entity.Car;
import com.System_Design_Project.response.Response;
import com.System_Design_Project.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class CarController {

    @Autowired
    private ICarService carService;

    @PostMapping("/saveCar")
    public ResponseEntity<?> saveCar(@RequestBody CarDTO carDto) {
        Response response = carService.addCar(carDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deleteCar/{carId}")
    public ResponseEntity<?> deleteCar(@PathVariable Long carId) {
        Response response = carService.deleteCar(carId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/allCar")
    public ResponseEntity<?> getAllCar() {
        Response response = carService.getAllCar();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/updateCarPayment/{userId}")
    public ResponseEntity<?> updateCar(@PathVariable Long userId, @RequestBody CarDTO updatedCarDTO) {
        Response updatedCarResponse = carService.updateCar(userId,updatedCarDTO);
        return ResponseEntity.ok(updatedCarResponse); // Güncellenen aracı geri dön
    }

    @PutMapping("/updateCar1")
    public ResponseEntity<?> updateCar1(@RequestBody CarDTO updatedCarDTO) {
        Response updatedCarResponse = carService.updateCar1(updatedCarDTO);
        return ResponseEntity.ok(updatedCarResponse); // Güncellenen aracı geri dön
    }

    @PutMapping("/updateCar2")
    public ResponseEntity<?> updateCar2(@RequestBody CarDTO updatedCarDTO) {
        Response updatedCarResponse = carService.updateCar2(updatedCarDTO);
        return ResponseEntity.ok(updatedCarResponse); // Güncellenen aracı geri dön
    }

    @PutMapping("/updateCar3")
    public ResponseEntity<?> updateCar3(@RequestBody CarDTO updatedCarDTO) {
        Response updatedCarResponse = carService.updateCar3(updatedCarDTO);
        return ResponseEntity.ok(updatedCarResponse); // Güncellenen aracı geri dön
    }

    @PutMapping("/updateCar4")
    public ResponseEntity<?> updateCar4(@RequestBody CarDTO updatedCarDTO) {
        Response updatedCarResponse = carService.updateCar4(updatedCarDTO);
        return ResponseEntity.ok(updatedCarResponse); // Güncellenen aracı geri dön
    }

    @PutMapping("/updateCar5")
    public ResponseEntity<?> updateCar5(@RequestBody CarDTO updatedCarDTO) {
        Response updatedCarResponse = carService.updateCar5(updatedCarDTO);
        return ResponseEntity.ok(updatedCarResponse); // Güncellenen aracı geri dön
    }

}

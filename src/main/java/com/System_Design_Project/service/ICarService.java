package com.System_Design_Project.service;

import com.System_Design_Project.dto.CarDTO;
import com.System_Design_Project.response.Response;

public interface ICarService {
    Response addCar(CarDTO carDto);
    Response deleteCar(Long carId);
    Response getAllCar();
    Response updateCar(Long userId, CarDTO updatedCarDTO);
    Response updateCar1(CarDTO updatedCarDTO);
    Response updateCar2(CarDTO updatedCarDTO);

    Response updateCar3(CarDTO updatedCarDTO);

    Response updateCar4(CarDTO updatedCarDTO);

    Response updateCar5(CarDTO updatedCarDTO);
}

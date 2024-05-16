package com.System_Design_Project.service.Impl;

import com.System_Design_Project.dto.CarDTO;
import com.System_Design_Project.entity.Car;
import com.System_Design_Project.repo.ICarRepo;
import com.System_Design_Project.response.Response;
import com.System_Design_Project.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements ICarService{

    @Autowired
    public ICarRepo carRepo;

    @Override
    public Response addCar(CarDTO carDTO) {

        Car car = new Car(
                carDTO.getCarId(),
                carDTO.getType(),
                carDTO.getCarPrice(),
                carDTO.getCarKilometer(),
                carDTO.getX(),
                carDTO.getY(),
                carDTO.getLastServiceDateMonth(),
                carDTO.getStatue(),
                carDTO.getPreviousDriver(),
                carDTO.getAmountOfFuel(),
                carDTO.getIsRented()
        );
        try {
            car.setIsRented(false); // ilk araç eklendiğinde kiralanmadı olarak işaretler
            carRepo.save(car);
            return new Response(car.getType() + " model araba başarı ile eklendi",true);
        }catch (Exception e){
            return new Response(" model araba  eklenemedi",false);
        }
    }
    @Override
    public Response deleteCar(Long carId) {

        try {
             carRepo.deleteById(carId.intValue());
            return new Response("Araba başarı ile silindi",true);
        }catch (Exception e){
            return new Response("Araba  silinemedi",false);
        }
    }

    @Override
    public Response getAllCar() {
        Response response = new Response("All Car List",true);
        List<Car> cars=carRepo.findAll();
        response.setData(cars);
        return response;
    }

    @Override
    public Response updateCar(Long userId, CarDTO updatedCarDTO) {
        Car existingCar = carRepo.findCarByType(updatedCarDTO.getType());
        if(existingCar!=null) {
            existingCar.setCarKilometer(updatedCarDTO.getCarKilometer());
            existingCar.setX(updatedCarDTO.getX());
            existingCar.setY(updatedCarDTO.getY());
            existingCar.setPreviousDriver(Math.toIntExact(userId));
            existingCar.setAmountOfFuel(updatedCarDTO.getAmountOfFuel());
            existingCar.setIsRented(updatedCarDTO.getIsRented());
            carRepo.save(existingCar);
            return new Response(updatedCarDTO.getType() + " model arabanın bilgileri başarı ile güncellendi",true);

        }else{
            return new Response(updatedCarDTO.getType() + " model arabanın bilgileri güncellenemedi",false);
        }

    }

    @Override
    public Response updateCar1(CarDTO updatedCarDTO) {
        Car existingCar = carRepo.findCarByType(updatedCarDTO.getType());
        if(existingCar!=null) {
            existingCar.setAmountOfFuel(updatedCarDTO.getAmountOfFuel());
            carRepo.save(existingCar);
            return new Response(updatedCarDTO.getType() + " model arabanın yakıtı başarı ile güncellendi",true);

        }else{
            return new Response(updatedCarDTO.getType() + " model arabanın yakıtı güncellenemedi",false);
        }
    }

    @Override
    public Response updateCar2(CarDTO updatedCarDTO) {
        Car existingCar = carRepo.findCarByType(updatedCarDTO.getType());
        if(existingCar!=null) {
            existingCar.setCarPrice(updatedCarDTO.getCarPrice());
            carRepo.save(existingCar);
            return new Response(updatedCarDTO.getType() + " model arabanın ücreti başarı ile güncellendi",true);

        }else{
            return new Response(updatedCarDTO.getType() + " model arabanın ücreti güncellenemedi",false);
        }
    }

    @Override
    public Response updateCar3(CarDTO updatedCarDTO) {
        Car existingCar = carRepo.findCarByType(updatedCarDTO.getType());
        if(existingCar!=null) {
            existingCar.setLastServiceDateMonth(updatedCarDTO.getLastServiceDateMonth());
            carRepo.save(existingCar);
            return new Response(updatedCarDTO.getType() + " model arabanın servis tarihi başarı ile güncellendi",true);

        }else{
            return new Response(updatedCarDTO.getType() + " model arabanın servis tarihi güncellenemedi",false);
        }
    }

    @Override
    public Response updateCar4(CarDTO updatedCarDTO) {
        Car existingCar = carRepo.findCarByType(updatedCarDTO.getType());
        if(existingCar!=null) {
            existingCar.setIsRented(updatedCarDTO.getIsRented());
            carRepo.save(existingCar);
            return new Response(updatedCarDTO.getType() + " model arabanın müsaitliği başarı ile güncellendi",true);

        }else{
            return new Response(updatedCarDTO.getType() + " model arabanın müsaitliği güncellenemedi",false);
        }
    }

    @Override
    public Response updateCar5(CarDTO updatedCarDTO) {
        Car existingCar = carRepo.findCarByType(updatedCarDTO.getType());
        if(existingCar!=null) {
            existingCar.setIsRented(updatedCarDTO.getIsRented());
            carRepo.save(existingCar);
            return new Response(updatedCarDTO.getType() + " model araba başarı ile onarıldı",true);

        }else{
            return new Response(updatedCarDTO.getType() + " model araba onarılamadı",false);
        }
    }



}

package com.System_Design_Project.service.Impl;

import com.System_Design_Project.dto.LoginDTO;
import com.System_Design_Project.dto.UserDTO;
import com.System_Design_Project.entity.User;
import com.System_Design_Project.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.System_Design_Project.repo.IUserRepo;
import com.System_Design_Project.service.IUserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    public IUserRepo userRepo;

    @Override
    public Response addUser(UserDTO userDTO) {

        User user = new User(
                userDTO.getUserId(),
                userDTO.getName(),
                userDTO.getSurname(),
                userDTO.getTelNumber(),
                userDTO.getPassword(),
                userDTO.getMoney(),
                userDTO.getDrivingPoint(),
                userDTO.getDrivingLicense()
        );
        try {
            userRepo.save(user);

            return new Response(user.getName() + " başarı ile kayıt yaptı",true);
        }catch (Exception e){
            return new Response("Register not success",false);
        }
        // return redirect: -->> gideceği pathi yaz
    }

    @Override
    public Response loginUser(LoginDTO loginDTO) {
        User user1 = userRepo.findUserByTelNumber(loginDTO.getTelNumber());
        if (user1 != null) {
            if (user1.getPassword().equals(loginDTO.getPassword())) {
                Optional<User> user = userRepo.findOneByTelNumberAndPassword(loginDTO.getTelNumber(), loginDTO.getPassword());
                if(user.isPresent()) {
                    return new Response("Login succes", true);
                } else
                    return new Response("Login not succes", false);

            } else return new Response("Password not match!", false);
        }else return new Response("Telephone number or Password not match!", false);
    }

    @Override
    public Response getUserInfo(String telNumber) {
        User currentUser =userRepo.findUserByTelNumber(telNumber);
        Response response = new Response("User Info",true);
        response.setData(currentUser);
        return response;
    }
}

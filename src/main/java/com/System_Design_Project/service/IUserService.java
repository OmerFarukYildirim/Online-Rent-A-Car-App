package com.System_Design_Project.service;

import com.System_Design_Project.dto.LoginDTO;
import com.System_Design_Project.dto.UserDTO;
import com.System_Design_Project.response.Response;

public interface IUserService {
    Response addUser(UserDTO userDto);
    Response loginUser(LoginDTO loginDTO);
    Response getUserInfo(String telNumber);
}

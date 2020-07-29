package com.bosssoft.springcloud.service;

import com.bosssoft.springcloud.DTO.LoginDTO;

import javax.servlet.http.HttpSession;

public interface LoginService {
    LoginDTO login(String username, String password);
}

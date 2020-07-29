package com.bosssoft.springcloud.service;

import com.bosssoft.springcloud.entity.DTO.LoginDTO;

public interface LoginService {
    LoginDTO login(String username, String password);
}

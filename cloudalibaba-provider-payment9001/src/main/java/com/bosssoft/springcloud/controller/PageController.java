package com.bosssoft.springcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    @GetMapping("/payment/{page}")
    public String toMemberPage(@PathVariable("page") String page)
    {
        return "/payment/"+page;
    }
}

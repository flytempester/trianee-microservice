package com.bosssoft.RBAC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    @GetMapping("/rbac/{page}")
    public String toMemberPage(@PathVariable("page") String page)
    {
        return "/rbac/"+page;
    }

}

package com.bosssoft.springcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    @GetMapping("/{page}")
    public String toPage(@PathVariable("page") String page)
    {
        return page;
    }
}

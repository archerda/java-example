package com.github.archerda.spring.mvc.javaconfig.dispatcherconfig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Create by archerda on 2017/11/24.
 */
@Controller
@RequestMapping(value = {"/", "/homePage"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}

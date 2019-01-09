package com.github.archerda.spring.mvc.javaconfig.dispatcherconfig.controller;

import com.github.archerda.spring.mvc.javaconfig.dispatcherconfig.respository.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Create by archerda on 2017/11/24.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpittleController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
        model.addAttribute(spitterRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }
}

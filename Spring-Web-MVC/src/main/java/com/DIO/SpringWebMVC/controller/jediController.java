package com.DIO.SpringWebMVC.controller;

import com.DIO.SpringWebMVC.Repository.JediRepository;
import com.DIO.SpringWebMVC.model.Jedi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class jediController {

    @Autowired
    private JediRepository repository;

    @GetMapping ("/jedi")
    public ModelAndView jedi(){

        final ModelAndView modelAndView = new ModelAndView ();
        modelAndView.setViewName ("Jedi");

        modelAndView.addObject ("allJedi",repository.getAllJEdi ());

        return modelAndView;
    }
    @GetMapping("/new-jedi")
    public ModelAndView newJedi(){

        final ModelAndView modelAndView = new ModelAndView ();
        modelAndView.setViewName ("new-jedi");

        modelAndView.addObject ("jedi", new Jedi());

        return modelAndView;
    }
    @PostMapping("/api/jedi")
    public Jedi createJedi(@Validated @ModelAttribute Jedi jedi){
        return repository.save(jedi);
    }

}

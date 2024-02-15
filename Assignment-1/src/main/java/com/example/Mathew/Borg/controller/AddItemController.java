package com.example.Mathew.Borg.controller;

import jakarta.validation.ClockProvider;
import jakarta.validation.Valid;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.example.Mathew.Borg.model.Clothing;
import com.example.Mathew.Borg.model.Clothing.Brand;
import com.example.Mathew.Borg.repository.impl.JdbcClothingRepository;


import java.util.EnumSet;

@Controller
@RequestMapping("/add")
public class AddItemController {

    @Autowired
    private JdbcClothingRepository clothingRepository;
    @GetMapping
    public String add() {return "add";}

    @ModelAttribute
    public void brand(Model model){
        var brand = EnumSet.allOf(Brand.class);
        model.addAttribute("brand", brand);
    }

    @ModelAttribute
    public Clothing clothing(){
        return Clothing
                .builder()
                .build();
    }

    @PostMapping
    public String addClothingItem(@Valid Clothing clothing, BindingResult result) {
        if(result.hasErrors()){
            return "add";
        }
        clothingRepository.save(clothing);
        return "redirect:/add";
    }
}

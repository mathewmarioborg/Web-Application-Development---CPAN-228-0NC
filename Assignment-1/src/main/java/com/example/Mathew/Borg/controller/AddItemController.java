package com.example.Mathew.Borg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddItemController {
    @GetMapping("/add")
    public String add() {return "addItem";}
}

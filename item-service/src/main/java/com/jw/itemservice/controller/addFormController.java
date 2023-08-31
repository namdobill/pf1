package com.jw.itemservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("items/new")
public class addFormController {
    @GetMapping
    public String addItem(){
        return "addForm";
    }
}

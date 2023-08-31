package com.jw.itemservice.controller;


import com.jw.itemservice.domain.Item;
import com.jw.itemservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ItemsController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String mainMove1(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "items";
    }

    @GetMapping("items")
    public String mainMove2(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "items";
    }

}

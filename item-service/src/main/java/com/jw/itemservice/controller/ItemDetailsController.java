package com.jw.itemservice.controller;

import com.jw.itemservice.domain.Item;
import com.jw.itemservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("items/item")
public class ItemDetailsController {

    private final ItemRepository itemRepository;

    @GetMapping("{id}")
    public String itemDetails(@PathVariable Long id, Model model){
        Item item = itemRepository.findById(id);
        model.addAttribute("item", item);
        return "item";
    }
}

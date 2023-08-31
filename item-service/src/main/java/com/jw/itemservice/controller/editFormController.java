package com.jw.itemservice.controller;

import com.jw.itemservice.domain.Item;
import com.jw.itemservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class editFormController {
    private final ItemRepository itemRepository;

    @GetMapping("items/edit/{id}")
    public String itemUpdate(@PathVariable Long id, Model model){
        Item item = itemRepository.findById(id);
        model.addAttribute("targetItem", item);
        return "editForm";
    }
}

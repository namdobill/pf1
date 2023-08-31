package com.jw.itemservice.controller;

import com.jw.itemservice.domain.Item;
import com.jw.itemservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequiredArgsConstructor
@RequestMapping("items/newItem")
public class addItemController {
    private final ItemRepository itemRepository;

    @PostMapping
    public String createItem(Item item){
        if (item.getProductName() == null || item.getPrice() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        itemRepository.save(item);
        return "redirect:/items";
    }
}

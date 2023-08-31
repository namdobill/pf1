package com.jw.itemservice.controller;

import com.jw.itemservice.domain.Item;
import com.jw.itemservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class editItemController {
    private final ItemRepository itemRepository;

    @PostMapping("items/edit/{id}/update")
    public String updateItem(@PathVariable Long id, Item item){
        itemRepository.updateId(id, item);
        return "redirect:/items/item/"+id;
    }
}

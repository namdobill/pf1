package com.jw.itemservice.repository;

import com.jw.itemservice.domain.Item;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

public class MemoryItemRepository implements ItemRepository{

    private static Map<Long, Item> memory = new HashMap<>();
    private static Long productId = 0L;

    @Override
    public Item save(Item item) {
        productId++;
        item.setId(productId);
        memory.put(item.getId(), item);
        return memory.get(productId);
    }

    @Override
    public Item findById(Long id) {
        Optional<Item> item = Optional.ofNullable(memory.get(id));
        if(item.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return item.get();
    }

    @Override
    public List<Item> findAll() {
        return new ArrayList<>(memory.values());
    }

    @Override
    public Item updateId(Long id, Item item) {
        Optional<Item> targetItem = Optional.ofNullable(memory.get(id));
        if(targetItem.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        memory.put(id,item);
        return memory.get(id);
    }

    @Override
    public Item deleteId(Long id) {
        Optional<Item> item = Optional.ofNullable(memory.get(id));
        if(item.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return memory.remove(id);
    }

    @Override
    public void clear() {
        memory.clear();
    }
}

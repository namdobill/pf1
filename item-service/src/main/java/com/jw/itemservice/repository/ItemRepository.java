package com.jw.itemservice.repository;

import com.jw.itemservice.domain.Item;

import java.util.List;

public interface ItemRepository {
    public Item save(Item item);
    public Item findById(Long id);
    public List<Item> findAll();
    public Item updateId(Long id, Item item);
    public Item deleteId(Long id);
    public void clear();
}

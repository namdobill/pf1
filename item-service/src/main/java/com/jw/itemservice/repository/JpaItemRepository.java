package com.jw.itemservice.repository;

import com.jw.itemservice.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional
public class JpaItemRepository implements ItemRepository{

    private final EntityManager em;

    @Override
    public Item save(Item item) {
        em.persist(item);
        return item;
    }

    @Override
    public Item findById(Long id) {
        Item item = em.find(Item.class, id);
        Optional<Item> target = Optional.ofNullable(item);
        if(target.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return target.get();
    }

    @Override
    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }

    @Override
    public Item updateId(Long id, Item newItem) {
        Item item = em.find(Item.class, id);
        Optional<Item> target = Optional.ofNullable(item);

        if (target.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Item updatedItem = target.get();
        updatedItem.setProductName(newItem.getProductName());
        updatedItem.setPrice(newItem.getPrice());
        updatedItem.setQuantity(newItem.getQuantity());

        return em.merge(updatedItem);
    }

    @Override
    public Item deleteId(Long id) {
        Item item = em.find(Item.class, id);
        Optional<Item> target = Optional.ofNullable(item);

        if (target.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        em.remove(item);
        return item;
    }

    @Override
    public void clear() {
        em.createQuery("DELETE FROM Item").executeUpdate();
    }
}

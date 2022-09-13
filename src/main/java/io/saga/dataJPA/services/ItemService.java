package io.saga.dataJPA.services;

import io.saga.dataJPA.models.Item;
import io.saga.dataJPA.models.Person;
import io.saga.dataJPA.repositories.ItemsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Sagadat Kuandykov
 */
@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Item> findByItemName(String itemName){

        return itemsRepository.findByItemName(itemName);
    }
    public List<Item> findByOwner(Person owner){
        return itemsRepository.findByOwner(owner);
    }
}

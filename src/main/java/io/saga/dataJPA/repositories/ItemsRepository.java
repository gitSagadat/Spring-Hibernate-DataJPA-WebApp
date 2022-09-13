package io.saga.dataJPA.repositories;

import io.saga.dataJPA.models.Item;
import io.saga.dataJPA.models.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sagadat Kuandykov
 */

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {
    List<Item> findByItemName(String itemName);

    List<Item> findByOwner(Person owner);
}

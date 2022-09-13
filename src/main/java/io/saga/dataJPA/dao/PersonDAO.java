package io.saga.dataJPA.dao;

import io.saga.dataJPA.models.Person;
import io.saga.dataJPA.repositories.PeopleRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonDAO {

    private final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional(readOnly = true)
    public void testNPlus1(){

        Session session = entityManager.unwrap(Session.class);
        //###### Данный метод вызывает проблемы с производительностью и занимает огромное количество времени
  //    //1 Request to DB
  //    List<Person> people = session.createQuery("select p from Person p",Person.class).getResultList();

  //    //N Request to DB
  //    for(Person person: people)
  //        System.out.println("Person "+person.getName() +" items: "+ person.getItems());

        // Solution: Оптимизация функции
        Set<Person> people = new HashSet<>(session.createQuery("select p from Person p left join fetch p.items", Person.class)
                .getResultList());
        for(Person person: people)
            System.out.println("User"+ person.getName() + " items: " + person.getItems());
    }
}

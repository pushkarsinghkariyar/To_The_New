package com.bootcamp.events.jdbc;

public interface PersonDao {

    void insert(Person p);
    Person getAllPersons();

}
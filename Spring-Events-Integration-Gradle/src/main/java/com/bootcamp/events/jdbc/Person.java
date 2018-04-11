package com.bootcamp.events.jdbc;

/**
 * Created by nidhi on 28/3/17.
 */
public class Person {

    private int pid;
    private String firstName;
    private String surName;

    public Person() {
    }

    public Person(int pid, String firstName, String surName) {
        this.pid = pid;
        this.firstName = firstName;
        this.surName = surName;
    }

    public int getPid() {
        return pid;
    }

    public Person setPid(int pid) {
        this.pid = pid;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getSurName() {
        return surName;
    }

    public Person setSurName(String surName) {
        this.surName = surName;
        return this;
    }
}
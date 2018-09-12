package com.example.thread.atomicreference;

import lombok.Data;

@Data
public class Person {
    volatile long id;

    public Person(long id) {
        this.id = id;
    }

    public String toString() {
        return "id:" + id;
    }
}
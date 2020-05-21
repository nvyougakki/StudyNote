package com.heyu.jdk8;

import java.io.BufferedInputStream;

public class Person {

    @Field(field = "NAME", order = 1)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        java.lang.reflect.Field field = new Person().getClass().getDeclaredField("name");
        System.out.println(field.getAnnotation(Field.class).field());
    }
}

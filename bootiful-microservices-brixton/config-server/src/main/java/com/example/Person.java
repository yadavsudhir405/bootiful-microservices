package com.example;

import java.io.Serializable;

/**
 * @author sudhir
 *         Date:22/11/16
 *         Time:12:27 PM
 *         Project:config-server
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -5768896963543719921L;
    private String name;


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

package com.gvssimux.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {

    private String id;
    private String name;
    private String password;
    private String age;


    public Person(String id, String name, String password, String age) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }
//提供set和get方法
}
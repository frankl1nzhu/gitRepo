package com.mycom.boot3demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties("person")
public class Person {
    private String name;
    private Integer age;
    private Date birthday;
    private boolean like;
    private Sheep sheep;
    private List<Dog> dogs;
    private Map<String, Cat> cats;

}

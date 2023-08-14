package com.faimdeloup.takeout.dto;

import com.faimdeloup.takeout.entity.Dish;
import lombok.Data;

@Data
public class DishDto extends Dish {

    private String categoryName;

    private Integer copies;
}

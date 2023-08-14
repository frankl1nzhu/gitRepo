package com.faimdeloup.takeout.dto;

import com.faimdeloup.takeout.entity.Setmeal;
import com.faimdeloup.takeout.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}

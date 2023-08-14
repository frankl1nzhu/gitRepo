package com.faimdeloup.takeout.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.faimdeloup.takeout.dto.DishDto;
import com.faimdeloup.takeout.entity.Dish;

public interface DishService extends IService<Dish> {
    //新增菜品
    public void saveDish(DishDto dishDto);
    //根据id查询菜品信息
    public DishDto getDishById(Long id);
    //更新菜品信息
    public void updateDish(DishDto dishDto);

}

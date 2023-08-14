package com.faimdeloup.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faimdeloup.takeout.dto.DishDto;
import com.faimdeloup.takeout.entity.Dish;
import com.faimdeloup.takeout.mapper.DishMapper;
import com.faimdeloup.takeout.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author Franklin
 */
@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    /*新增菜品*/
    public void saveDish(DishDto dishDto){
        //保存菜品的基本信息到菜品表dish
        this.save(dishDto);
        Long dishId = dishDto.getId();//菜品id
    }

    /*根据id查询菜品信息*/
    public DishDto getDishById(Long id) {
        //查询菜品基本信息，从dish表查询
        Dish dish = this.getById(id);

        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish,dishDto);

        return dishDto;
    }

    @Override
    public void updateDish(DishDto dishDto) {
        //更新dish表基本信息
        this.updateById(dishDto);
    }

}

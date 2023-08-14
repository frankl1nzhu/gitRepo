package com.faimdeloup.takeout.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faimdeloup.takeout.common.R;
import com.faimdeloup.takeout.dto.DishDto;
import com.faimdeloup.takeout.entity.Category;
import com.faimdeloup.takeout.entity.Dish;
import com.faimdeloup.takeout.service.CategoryService;
import com.faimdeloup.takeout.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Franklin
 */
@RestController
@RequestMapping("/dish")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;
    @Autowired
    private CategoryService categoryService;

    /*新增菜品*/
    @PostMapping
    public R<String> save(@RequestBody DishDto dishDto){
        log.info("接收的dishDto数据：{}",dishDto.toString());
        dishService.saveDish(dishDto);
        return R.success("Add successfully");
    }

    /*菜品分页查询*/
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name){
        //分页构造器
        Page<Dish> pageInfo = new Page<>(page, pageSize);
        Page<DishDto> dishDtoPage = new Page<>();

        //条件构造器
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(name != null, Dish::getName, name);
        //添加排序条件
        queryWrapper.orderByDesc(Dish::getUpdateTime);

        //执行分页查询
        dishService.page(pageInfo,queryWrapper);

        //对象拷贝
        BeanUtils.copyProperties(pageInfo, dishDtoPage, "records");

        List<Dish> records = pageInfo.getRecords();

        List<DishDto> list = records.stream().map((item) -> {
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(item,dishDto);

            Long categoryId = item.getCategoryId(); //分类id
            Category category = categoryService.getById(categoryId);

            if(categoryId != null){
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);

            }
            return dishDto;
        }).collect(Collectors.toList());

        dishDtoPage.setRecords(list);

        return R.success(dishDtoPage);
    }

    /*根据id查询菜品信息*/
    @GetMapping("/{id}")
    public R<DishDto> get(@PathVariable Long id){

        DishDto dishDto = dishService.getDishById(id);
        return R.success(dishDto);
    }

    /*修改菜品*/
    @PutMapping
    public R<String> update(@RequestBody DishDto dishDto){
        log.info("接收的dishDto数据：{}",dishDto.toString());
        dishService.updateDish(dishDto);
        return R.success("Modification successfully");
    }

    /*根据条件查询菜品*/
    @GetMapping("/list")
    public R<List<Dish>> list(Dish dish){
        //查询条件
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(dish.getCategoryId()!=null, Dish::getCategoryId, dish.getCategoryId());
        //查询状态为1，启售状态的菜品
        queryWrapper.eq(Dish::getStatus, 1);
        //排序条件
        queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);

        List<Dish> list = dishService.list(queryWrapper);
        return  R.success(list);
    }
}

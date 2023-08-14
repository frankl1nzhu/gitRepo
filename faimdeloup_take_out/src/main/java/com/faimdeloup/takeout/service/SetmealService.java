package com.faimdeloup.takeout.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.faimdeloup.takeout.dto.SetmealDto;
import com.faimdeloup.takeout.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {

    /*新增套餐*/
    public void saveWithDish(SetmealDto setmealDto);

    /*删除套餐*/
    public void removeWithDish(List<Long> ids);

}

package com.suzhoushui.mapper;

import com.suzhoushui.domain.Food;
import com.suzhoushui.domain.FoodAddress;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FoodMapper {


    @Select("SELECT * FROM food")
    List<Food> getAllFood();

    @Select("SELECT * FROM food where id=#{id}")
    Food findById(Long id);


    @Select("SELECT * FROM food_address where food_id=#{food_id}")
    List<FoodAddress> findFoodAddress(Long food_id);

    @Select("SELECT * FROM food_address where id=#{id}")
    FoodAddress findOneAddress(Long id);
}

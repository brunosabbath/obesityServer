package com.sbbi.obesity.dao;


import org.springframework.data.repository.CrudRepository;

import com.sbbi.obesity.model.Food;

public interface FoodRespository extends CrudRepository<Food, Long>{

}

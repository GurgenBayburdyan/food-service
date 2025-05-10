package org.example.foodservice.service;

import org.example.foodservice.entity.Dish;
import org.example.foodservice.service.params.CreateDishParams;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */
public interface DishService {

    List<Dish> getAll();

    Dish create(CreateDishParams params);

}

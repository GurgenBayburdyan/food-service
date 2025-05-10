package org.example.foodservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.foodservice.entity.Category;
import org.example.foodservice.entity.Dish;
import org.example.foodservice.repository.DishRepository;
import org.example.foodservice.service.CategoryService;
import org.example.foodservice.service.DishService;
import org.example.foodservice.service.params.CreateDishParams;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@Service
@AllArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository repository;
    private final CategoryService categoryService;

    @Override
    @Transactional(readOnly = true)
    public List<Dish> getAll() {
        log.debug("Executing get all dishes");

        final List<Dish> dishes = repository.findAll();

        log.debug("Successfully executed get all dishes, {}", dishes);
        return dishes;
    }

    @Override
    @Transactional
    public Dish create(CreateDishParams params) {
        Assert.notNull(params, "the params must not be null");
        log.debug("Executing create dish, params-{}", params);

        final Dish dish = new Dish();

        final Category category = categoryService.getById(params.getCategoryId());

        dish.setName(params.getName());
        dish.setDescription(params.getDescription());
        dish.setPrice(params.getPrice());
        dish.setCategory(category);
        dish.setImageUrl(params.getImageUrl());

        final Dish saved = repository.save(dish);

        log.debug("Successfully executed create dish, {}", saved);
        return saved;
    }
}

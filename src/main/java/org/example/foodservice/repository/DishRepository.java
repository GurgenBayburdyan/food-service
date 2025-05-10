package org.example.foodservice.repository;

import org.example.foodservice.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gurgen Bayburdyan
 */
public interface DishRepository extends JpaRepository<Dish, Long> {
}

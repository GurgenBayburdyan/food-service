package org.example.foodservice.service;

import org.example.foodservice.entity.Category;
import org.example.foodservice.service.params.CreateCategoryParams;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */
public interface CategoryService {

    List<Category> getAll();

    Category create(CreateCategoryParams params);

    Boolean existsById(Long id);

    Category getById(Long id);

}

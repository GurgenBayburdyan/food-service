package org.example.foodservice.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.foodservice.entity.Category;
import org.example.foodservice.repository.CategoryRepository;
import org.example.foodservice.service.CategoryService;
import org.example.foodservice.service.params.CreateCategoryParams;
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
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    @Override
    @Transactional(readOnly = true)
    public List<Category> getAll() {
        log.debug("Executing get all categories");

        final List<Category> categories = repository.findAll();

        log.debug("Successfully executed get all categories, {}", categories);
        return categories;
    }

    @Override
    @Transactional
    public Category create(CreateCategoryParams params) {
        Assert.notNull(params, "the params must not be null");
        log.debug("Executing create category, params-{}", params);

        final Category category = new Category();

        category.setName(params.getName());

        final Category saved  = repository.save(category);

        log.debug("Successfully executed create category, {}", saved);
        return saved;
    }

    @Override
    public Boolean existsById(Long id) {
        log.debug("Executing exists category by id, id-{}", id);

        final Boolean response = repository.existsById(id);

        log.debug("Successfully executed exists category by id, {}", response);
        return response;
    }

    @Override
    public Category getById(Long id) {
        log.debug("Executing get category by id, id-{}", id);

        Category category = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Category not found with id: " + id)
        );

        log.debug("Successfully executed get category by id, {}", category);
        return category;
    }
}

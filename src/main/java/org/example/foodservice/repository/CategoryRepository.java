package org.example.foodservice.repository;

import org.example.foodservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gurgen Bayburdyan
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

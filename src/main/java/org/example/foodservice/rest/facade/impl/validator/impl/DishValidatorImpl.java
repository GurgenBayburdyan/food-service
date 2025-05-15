package org.example.foodservice.rest.facade.impl.validator.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.foodservice.rest.dto.request.CreateDishRequestDto;
import org.example.foodservice.rest.dto.response.ErrorType;
import org.example.foodservice.rest.facade.impl.validator.DishValidator;
import org.example.foodservice.service.CategoryService;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */

@Component
@Slf4j
@AllArgsConstructor
class DishValidatorImpl implements DishValidator {

    private final CategoryService categoryService;

    @Override
    public Optional<ErrorType> validateCreate(CreateDishRequestDto requestDto) {
        log.debug("Executing validate create for request-{}", requestDto);

        if (ObjectUtils.isEmpty(requestDto.getName())) {
            log.debug("Validation failed: Missing or empty name");
            return Optional.of(ErrorType.MISSING_NAME);
        }

        if (ObjectUtils.isEmpty(requestDto.getCategoryId())) {
            log.debug("Validation failed: Missing or empty category id");
            return Optional.of(ErrorType.MISSING_CATEGORY_ID);
        }

        if (ObjectUtils.isEmpty(requestDto.getDescription())) {
            log.debug("Validation failed: Missing or empty description");
            return Optional.of(ErrorType.MISSING_DESCRIPTION);
        }

        if (ObjectUtils.isEmpty(requestDto.getImageUrl())) {
            log.debug("Validation failed: Missing or empty image url");
            return Optional.of(ErrorType.MISSING_IMAGE_URL);
        }

        if (ObjectUtils.isEmpty(requestDto.getPrice())) {
            log.debug("Validation failed: Missing or empty price");
            return Optional.of(ErrorType.MISSING_PRICE);
        }

        if (!categoryService.existsById(requestDto.getCategoryId())) {
            log.debug("Validation failed: Category not found");
            return Optional.of(ErrorType.CATEGORY_NOT_FOUND);
        }

        log.debug("Validation executed successfully");
        return Optional.empty();
    }
}

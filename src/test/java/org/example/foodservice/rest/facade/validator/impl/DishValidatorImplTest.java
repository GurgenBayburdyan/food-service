package org.example.foodservice.rest.facade.validator.impl;

import org.example.foodservice.rest.dto.request.CreateDishRequestDto;
import org.example.foodservice.rest.dto.response.ErrorType;
import org.example.foodservice.rest.facade.validator.DishValidator;
import org.example.foodservice.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author Gurgen Bayburdyan
 */

@ExtendWith(MockitoExtension.class)
class DishValidatorImplTest {

    @Mock
    private DishValidator validator;

    @Mock
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        validator = new DishValidatorImpl(categoryService);
    }

    @Test
    void validateCreate_success() {
        final CreateDishRequestDto requestDto = new CreateDishRequestDto();
        requestDto.setName("name");
        requestDto.setDescription("description");
        requestDto.setImageUrl("imageUrl");
        requestDto.setPrice(1);
        requestDto.setCategoryId(1L);

        when(categoryService.existsById(1L)).thenReturn(true);

        final Optional<ErrorType> errorType = validator.validateCreate(requestDto);
        assertThat(errorType).isEmpty();
    }

    @Test
    void validateCreate_MissingName() {
        final CreateDishRequestDto requestDto = new CreateDishRequestDto();
        requestDto.setName(null);
        requestDto.setDescription("description");
        requestDto.setImageUrl("imageUrl");
        requestDto.setPrice(1);
        requestDto.setCategoryId(1L);

        final Optional<ErrorType> errorType = validator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.MISSING_NAME);
    }

    @Test
    void validateCreate_MissingDescription() {
        final CreateDishRequestDto requestDto = new CreateDishRequestDto();
        requestDto.setName("name");
        requestDto.setDescription(null);
        requestDto.setImageUrl("imageUrl");
        requestDto.setPrice(1);
        requestDto.setCategoryId(1L);

        final Optional<ErrorType> errorType = validator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.MISSING_DESCRIPTION);
    }

    @Test
    void validateCreate_MissingImageUrl() {
        final CreateDishRequestDto requestDto = new CreateDishRequestDto();
        requestDto.setName("name");
        requestDto.setDescription("description");
        requestDto.setImageUrl(null);
        requestDto.setPrice(1);
        requestDto.setCategoryId(1L);

        final Optional<ErrorType> errorType = validator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.MISSING_IMAGE_URL);
    }

    @Test
    void validateCreate_MissingPrice() {
        final CreateDishRequestDto requestDto = new CreateDishRequestDto();
        requestDto.setName("name");
        requestDto.setDescription("description");
        requestDto.setImageUrl("imageUrl");
        requestDto.setPrice(null);
        requestDto.setCategoryId(1L);

        final Optional<ErrorType> errorType = validator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.MISSING_PRICE);
    }

    @Test
    void validateCreate_MissingCategoryId() {
        final CreateDishRequestDto requestDto = new CreateDishRequestDto();
        requestDto.setName("name");
        requestDto.setDescription("description");
        requestDto.setImageUrl("imageUrl");
        requestDto.setPrice(1);
        requestDto.setCategoryId(null);

        final Optional<ErrorType> errorType = validator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.MISSING_CATEGORY_ID);
    }

    @Test
    void validateCreate_CategoryNotFound() {
        final CreateDishRequestDto requestDto = new CreateDishRequestDto();
        requestDto.setName("name");
        requestDto.setCategoryId(1L);
        requestDto.setDescription("description");
        requestDto.setImageUrl("imageUrl");
        requestDto.setPrice(1);

        when(categoryService.existsById(1L)).thenReturn(false);

        final Optional<ErrorType> errorType = validator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.CATEGORY_NOT_FOUND);
    }

}
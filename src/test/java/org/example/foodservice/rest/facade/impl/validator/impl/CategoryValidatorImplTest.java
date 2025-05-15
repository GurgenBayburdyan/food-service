package org.example.foodservice.rest.facade.impl.validator.impl;

import org.example.foodservice.AbstractUnitTest;
import org.example.foodservice.rest.dto.request.CreateCategoryRequestDto;
import org.example.foodservice.rest.dto.response.ErrorType;
import org.example.foodservice.rest.facade.impl.validator.CategoryValidator;
import org.example.foodservice.rest.facade.impl.validator.impl.CategoryValidatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Gurgen Bayburdyan
 */

class CategoryValidatorImplTest extends AbstractUnitTest {

    private CategoryValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CategoryValidatorImpl();
    }

    @Test
    void validateCreate_success() {
        final CreateCategoryRequestDto requestDto = new CreateCategoryRequestDto();
        requestDto.setName("name");

        final Optional<ErrorType> errorType = validator.validateCreate(requestDto);
        assertThat(errorType).isEmpty();
    }

    @Test
    void validateCreate_MissingName() {
        final CreateCategoryRequestDto requestDto = new CreateCategoryRequestDto();
        requestDto.setName(null);

        final Optional<ErrorType> errorType = validator.validateCreate(requestDto);
        assertThat(errorType).contains(ErrorType.MISSING_NAME);
    }
}
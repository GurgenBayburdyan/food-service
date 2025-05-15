package org.example.foodservice.rest.facade.validator.impl;

import org.example.foodservice.rest.dto.request.CreateCategoryRequestDto;
import org.example.foodservice.rest.dto.response.ErrorType;
import org.example.foodservice.rest.facade.validator.CategoryValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Gurgen Bayburdyan
 */

//todo create AbstractUnitTest class annotated with @ExtendWith(MockitoExtension.class) to not put that annotation in every unit test
@ExtendWith(MockitoExtension.class)
class CategoryValidatorImplTest {

    //we mock only constructor injected dependencies
    @Mock
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

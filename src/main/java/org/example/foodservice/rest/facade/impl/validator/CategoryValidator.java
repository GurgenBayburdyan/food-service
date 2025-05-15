package org.example.foodservice.rest.facade.impl.validator;

import org.example.foodservice.rest.dto.request.CreateCategoryRequestDto;
import org.example.foodservice.rest.dto.response.ErrorType;

import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */
public interface CategoryValidator {

    Optional<ErrorType> validateCreate(CreateCategoryRequestDto requestDto);

}

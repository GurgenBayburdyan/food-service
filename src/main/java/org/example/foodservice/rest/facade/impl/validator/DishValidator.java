package org.example.foodservice.rest.facade.impl.validator;

import org.example.foodservice.rest.dto.request.CreateDishRequestDto;
import org.example.foodservice.rest.dto.response.ErrorType;

import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */

public interface DishValidator {

    Optional<ErrorType> validateCreate(CreateDishRequestDto requestDto);

}

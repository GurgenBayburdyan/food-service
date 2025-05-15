package org.example.foodservice.rest.facade.validator;

import org.example.foodservice.rest.dto.request.CreateDishRequestDto;
import org.example.foodservice.rest.dto.response.ErrorType;

import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */
//todo validator package should be in impl package
public interface DishValidator {

    Optional<ErrorType> validateCreate(CreateDishRequestDto requestDto);

}

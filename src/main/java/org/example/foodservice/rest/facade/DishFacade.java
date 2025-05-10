package org.example.foodservice.rest.facade;

import org.example.foodservice.rest.dto.request.CreateDishRequestDto;
import org.example.foodservice.rest.dto.response.DishDetailsDto;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */
public interface DishFacade {

    List<DishDetailsDto> getAll();

    DishDetailsDto create(CreateDishRequestDto requestDto);
}

package org.example.foodservice.rest.facade;

import org.example.foodservice.rest.dto.request.CreateCategoryRequestDto;
import org.example.foodservice.rest.dto.response.CategoryDetailsDto;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */
public interface CategoryFacade {

    List<CategoryDetailsDto> getAll();

    CategoryDetailsDto create(CreateCategoryRequestDto requestDto);

}

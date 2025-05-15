package org.example.foodservice.rest.facade.impl.mapper;

import lombok.extern.slf4j.Slf4j;
import org.example.foodservice.entity.Category;
import org.example.foodservice.rest.dto.request.CreateCategoryRequestDto;
import org.example.foodservice.rest.dto.response.CategoryDetailsDto;
import org.example.foodservice.service.params.CreateCategoryParams;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@Component
public class CategoryMapper {

    public CategoryDetailsDto toDetailsDto(Category category) {
        log.trace("Mapping category - {} to category details dto", category);

        final CategoryDetailsDto dto = new CategoryDetailsDto();
        dto.setId(category.getId());
        dto.setName(category.getName());

        log.trace("Mapped category {}", dto);
        return dto;
    }

    public List<CategoryDetailsDto> toDetailsDtoList(List<Category> categories) {
        List<CategoryDetailsDto> dtos = categories.stream()
                .map(this::toDetailsDto)
                .toList();

        return dtos;
    }

    public CreateCategoryParams toCreateParams(CreateCategoryRequestDto requestDto) {
        log.trace("Mapping create category request dto - {} to create category params", requestDto);

        final CreateCategoryParams params = new CreateCategoryParams(
                requestDto.getName()
        );

        log.trace("Mapped create category request dto {}", params);
        return params;
    }
}

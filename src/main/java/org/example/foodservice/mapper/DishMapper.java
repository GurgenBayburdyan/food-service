package org.example.foodservice.mapper;

import lombok.extern.slf4j.Slf4j;
import org.example.foodservice.entity.Dish;
import org.example.foodservice.rest.dto.request.CreateDishRequestDto;
import org.example.foodservice.rest.dto.response.DishDetailsDto;
import org.example.foodservice.service.params.CreateDishParams;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@Component
public class DishMapper {

    public DishDetailsDto toDetailsDto(Dish dish) {
        log.trace("Mapping dish - {} to dish details dto", dish);

        final DishDetailsDto dto = new DishDetailsDto();

        dto.setName(dish.getName());
        dto.setDescription(dish.getDescription());
        dto.setCategoryId(dish.getCategory().getId());
        dto.setImageUrl(dish.getImageUrl());
        dto.setPrice(dish.getPrice());

        log.trace("Mapped dish {}", dto);
        return dto;
    }

    public List<DishDetailsDto> toDetailsDtoList(List<Dish> dishes) {
        final List<DishDetailsDto> dtos = new ArrayList<>();

        for (final Dish dish : dishes) {
            dtos.add(toDetailsDto(dish));
        }

        return dtos;
    }

    public CreateDishParams toCreateParams(CreateDishRequestDto requestDto) {
        log.trace("Mapping create dish request dto - {} to create dish params", requestDto);

        final CreateDishParams params = new CreateDishParams(
                requestDto.getCategoryId(),
                requestDto.getName(),
                requestDto.getPrice(),
                requestDto.getDescription(),
                requestDto.getImageUrl()
        );

        log.trace("Mapped create dish request dto {}", params);
        return params;
    }

}

package org.example.foodservice.rest.facade.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.foodservice.entity.Dish;
import org.example.foodservice.mapper.DishMapper;
import org.example.foodservice.rest.dto.request.CreateDishRequestDto;
import org.example.foodservice.rest.dto.response.DishDetailsDto;
import org.example.foodservice.rest.dto.response.ErrorType;
import org.example.foodservice.rest.facade.DishFacade;
import org.example.foodservice.rest.facade.validator.DishValidator;
import org.example.foodservice.service.DishService;
import org.example.foodservice.service.params.CreateDishParams;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */

@Service
@Slf4j
@AllArgsConstructor
public class DishFacadeImpl implements DishFacade {

    private final DishService service;
    private final DishMapper mapper;
    private final DishValidator validator;

    @Override
    public List<DishDetailsDto> getAll() {
        log.info("Executing get all dishes rest API");

        final List<Dish> dishes = service.getAll();

        final List<DishDetailsDto> detailsDtos = mapper.toDetailsDtoList(dishes);

        log.info("Successfully executed get all dishes rest API, response - {}", detailsDtos);
        return detailsDtos;
    }

    @Override
    public DishDetailsDto create(CreateDishRequestDto requestDto) {
        log.info("Executing create dish for the provided request to - {}:", requestDto);

        final Optional<ErrorType> optionalErrorType = validator.validateCreate(requestDto);

        if (optionalErrorType.isPresent()) {
            final DishDetailsDto detailsDto = new DishDetailsDto(optionalErrorType.get());
            log.info("Executing create dish failed, error-{}", optionalErrorType.get());
            return detailsDto;
        }

        //todo mapper should be in facade-> impl package
        final CreateDishParams params = mapper.toCreateParams(requestDto);

        final Dish dish = service.create(params);

        final DishDetailsDto detailsDto = mapper.toDetailsDto(dish);

        log.info("Successfully executed create dish rest API, response - {}", detailsDto);
        return detailsDto;
    }
}

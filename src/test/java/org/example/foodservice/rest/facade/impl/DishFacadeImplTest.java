package org.example.foodservice.rest.facade.impl;

import org.example.foodservice.AbstractUnitTest;
import org.example.foodservice.entity.Dish;
import org.example.foodservice.rest.facade.impl.mapper.DishMapper;
import org.example.foodservice.rest.dto.request.CreateDishRequestDto;
import org.example.foodservice.rest.dto.response.DishDetailsDto;
import org.example.foodservice.rest.dto.response.ErrorType;
import org.example.foodservice.rest.facade.DishFacade;
import org.example.foodservice.rest.facade.impl.validator.DishValidator;
import org.example.foodservice.service.DishService;
import org.example.foodservice.service.params.CreateDishParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Gurgen Bayburdyan
 */

class DishFacadeImplTest extends AbstractUnitTest {

    @Mock
    private DishService service;

    @Mock
    private DishMapper mapper;

    @Mock
    private DishValidator validator;

    private DishFacade facade;

    @BeforeEach
    void setUp() {
        facade = new DishFacadeImpl(service, mapper, validator);
    }

    @Test
    void getAll() {
        final List<Dish> dishes = new ArrayList<>();
        final List<DishDetailsDto> detailsDtos = new ArrayList<>();

        when(service.getAll()).thenReturn(dishes);
        when(mapper.toDetailsDtoList(dishes)).thenReturn(detailsDtos);

        final List<DishDetailsDto> result = facade.getAll();

        assertEquals(detailsDtos, result);

        verify(service).getAll();
        verify(mapper).toDetailsDtoList(dishes);
    }

    @Test
    void create_success() {
        final CreateDishRequestDto requestDto = new CreateDishRequestDto();
        final Dish category = new Dish();
        final DishDetailsDto detailsDto = new DishDetailsDto();

        final CreateDishParams params = new CreateDishParams(
                1L,
                "name",
                1,
                "description",
                "imageUrl"
        );

        when(validator.validateCreate(requestDto)).thenReturn(Optional.empty());
        when(mapper.toCreateParams(requestDto)).thenReturn(params);
        when(service.create(params)).thenReturn(category);
        when(mapper.toDetailsDto(category)).thenReturn(detailsDto);

        final DishDetailsDto result = facade.create(requestDto);

        assertEquals(detailsDto, result);

        verify(validator).validateCreate(requestDto);
        verify(service).create(params);
        verify(mapper).toCreateParams(requestDto);
    }

    @Test
    void create_MissingName() {
        final CreateDishRequestDto requestDto = new CreateDishRequestDto();

        when(validator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.MISSING_NAME));

        final DishDetailsDto result = facade.create(requestDto);

        assertEquals(ErrorType.MISSING_NAME, result.getErrorType());

        verify(validator).validateCreate(requestDto);
    }

    @Test
    void create_MissingDescription() {
        final CreateDishRequestDto requestDto = new CreateDishRequestDto();

        when(validator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.MISSING_DESCRIPTION));

        final DishDetailsDto result = facade.create(requestDto);

        assertEquals(ErrorType.MISSING_DESCRIPTION, result.getErrorType());

        verify(validator).validateCreate(requestDto);
    }

    @Test
    void create_MissingPrice() {
        final CreateDishRequestDto requestDto = new CreateDishRequestDto();

        when(validator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.MISSING_PRICE));

        final DishDetailsDto result = facade.create(requestDto);

        assertEquals(ErrorType.MISSING_PRICE, result.getErrorType());

        verify(validator).validateCreate(requestDto);
    }

    @Test
    void create_MissingImageUrl() {
        final CreateDishRequestDto requestDto = new CreateDishRequestDto();

        when(validator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.MISSING_IMAGE_URL));

        final DishDetailsDto result = facade.create(requestDto);

        assertEquals(ErrorType.MISSING_IMAGE_URL, result.getErrorType());

        verify(validator).validateCreate(requestDto);
    }

    @Test
    void create_MissingCategoryId() {
        final CreateDishRequestDto requestDto = new CreateDishRequestDto();

        when(validator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.MISSING_CATEGORY_ID));

        final DishDetailsDto result = facade.create(requestDto);

        assertEquals(ErrorType.MISSING_CATEGORY_ID, result.getErrorType());

        verify(validator).validateCreate(requestDto);
    }

    @Test
    void create_CategoryNotFound() {
        final CreateDishRequestDto requestDto = new CreateDishRequestDto();

        when(validator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.CATEGORY_NOT_FOUND));

        final DishDetailsDto result = facade.create(requestDto);

        assertEquals(ErrorType.CATEGORY_NOT_FOUND, result.getErrorType());

        verify(validator).validateCreate(requestDto);
    }

}
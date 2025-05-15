package org.example.foodservice.rest.facade.impl;

import org.example.foodservice.AbstractUnitTest;
import org.example.foodservice.entity.Category;
import org.example.foodservice.rest.facade.impl.mapper.CategoryMapper;
import org.example.foodservice.rest.dto.request.CreateCategoryRequestDto;
import org.example.foodservice.rest.dto.response.CategoryDetailsDto;
import org.example.foodservice.rest.dto.response.ErrorType;
import org.example.foodservice.rest.facade.CategoryFacade;
import org.example.foodservice.rest.facade.impl.validator.CategoryValidator;
import org.example.foodservice.service.CategoryService;
import org.example.foodservice.service.params.CreateCategoryParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Gurgen Bayburdyan
 */

class CategoryFacadeImplTest extends AbstractUnitTest {

    @Mock
    private CategoryService service;

    @Mock
    private CategoryMapper mapper;

    @Mock
    private CategoryValidator validator;

    private CategoryFacade facade;

    @BeforeEach
    void setUp() {
        facade = new CategoryFacadeImpl(service, mapper, validator);
    }

    @Test
    void getAll() {
        final List<Category> categories = new ArrayList<>();
        final List< CategoryDetailsDto> detailsDtos = new ArrayList<>();

        when(service.getAll()).thenReturn(categories);
        when(mapper.toDetailsDtoList(categories)).thenReturn(detailsDtos);

        final List<CategoryDetailsDto> result = facade.getAll();

        assertEquals(detailsDtos, result);

        verify(service).getAll();
        verify(mapper).toDetailsDtoList(categories);
    }

    @Test
    void create_success() {
        final CreateCategoryRequestDto requestDto = new CreateCategoryRequestDto();
        final Category category = new Category();
        final CategoryDetailsDto detailsDto = new CategoryDetailsDto();

        final CreateCategoryParams params = new CreateCategoryParams(
                "name"
        );

        when(validator.validateCreate(requestDto)).thenReturn(Optional.empty());
        when(mapper.toCreateParams(requestDto)).thenReturn(params);
        when(service.create(params)).thenReturn(category);
        when(mapper.toDetailsDto(category)).thenReturn(detailsDto);

        final CategoryDetailsDto result = facade.create(requestDto);

        assertEquals(detailsDto, result);

        verify(validator).validateCreate(requestDto);
        verify(service).create(params);
        verify(mapper).toCreateParams(requestDto);
    }

    @Test
    void create_MissingName() {
        final CreateCategoryRequestDto requestDto = new CreateCategoryRequestDto();

        when(validator.validateCreate(requestDto)).thenReturn(Optional.of(ErrorType.MISSING_NAME));

        final CategoryDetailsDto result = facade.create(requestDto);

        assertEquals(ErrorType.MISSING_NAME, result.getErrorType());

        verify(validator).validateCreate(requestDto);
    }

}
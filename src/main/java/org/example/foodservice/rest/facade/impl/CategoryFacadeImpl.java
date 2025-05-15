package org.example.foodservice.rest.facade.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.foodservice.entity.Category;
import org.example.foodservice.rest.facade.impl.mapper.CategoryMapper;
import org.example.foodservice.rest.dto.request.CreateCategoryRequestDto;
import org.example.foodservice.rest.dto.response.CategoryDetailsDto;
import org.example.foodservice.rest.dto.response.ErrorType;
import org.example.foodservice.rest.facade.CategoryFacade;
import org.example.foodservice.rest.facade.impl.validator.CategoryValidator;
import org.example.foodservice.service.CategoryService;
import org.example.foodservice.service.params.CreateCategoryParams;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */

@Service
@Slf4j
@AllArgsConstructor
class CategoryFacadeImpl implements CategoryFacade {

    private final CategoryService service;
    private final CategoryMapper mapper;
    private final CategoryValidator validator;

    @Override
    public List<CategoryDetailsDto> getAll() {
        log.info("Getting all categories rest API");

        final List<Category> categories = service.getAll();

        final List<CategoryDetailsDto> detailsDtos = mapper.toDetailsDtoList(categories);

        log.info("Successfully got all categories rest API, response - {}", detailsDtos);
        return detailsDtos;
    }

    @Override
    public CategoryDetailsDto create(CreateCategoryRequestDto requestDto) {
        log.info("Creating category for the provided request to - {}:", requestDto);

        final Optional<ErrorType> optionalErrorType = validator.validateCreate(requestDto);

        if (optionalErrorType.isPresent()) {
            final CategoryDetailsDto detailsDto = new CategoryDetailsDto(optionalErrorType.get());
            log.info("Creating category failed, error-{}", optionalErrorType.get());
            return detailsDto;
        }

        final CreateCategoryParams params = mapper.toCreateParams(requestDto);

        final Category category = service.create(params);

        final CategoryDetailsDto detailsDto = mapper.toDetailsDto(category);

        log.info("Successfully created category rest API, response - {}", detailsDto);
        return detailsDto;
    }
}

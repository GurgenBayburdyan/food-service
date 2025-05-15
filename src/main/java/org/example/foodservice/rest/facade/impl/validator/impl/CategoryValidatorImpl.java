package org.example.foodservice.rest.facade.impl.validator.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.foodservice.rest.dto.request.CreateCategoryRequestDto;
import org.example.foodservice.rest.dto.response.ErrorType;
import org.example.foodservice.rest.facade.impl.validator.CategoryValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

/**
 * @author Gurgen Bayburdyan
 */

@Component
@Slf4j
@AllArgsConstructor
class CategoryValidatorImpl implements CategoryValidator {
    @Override
    public Optional<ErrorType> validateCreate(CreateCategoryRequestDto requestDto) {
        log.debug("Executing validate create for request-{}", requestDto);

        if (ObjectUtils.isEmpty(requestDto.getName())) {
            log.debug("Validation failed: Missing or empty name");
            return Optional.of(ErrorType.MISSING_NAME);
        }

        log.debug("Validation executed successfully");
        return Optional.empty();
    }
}

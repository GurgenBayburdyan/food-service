package org.example.foodservice.rest.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.foodservice.rest.dto.request.CreateCategoryRequestDto;
import org.example.foodservice.rest.dto.response.CategoryDetailsDto;
import org.example.foodservice.rest.facade.CategoryFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryFacade facade;

    @GetMapping
    public ResponseEntity<List<CategoryDetailsDto>> getAll() {
        log.info("Executing find all votes rest API");

        ResponseEntity<List<CategoryDetailsDto>> responseEntity = ResponseEntity.ok(facade.getAll());

        log.info("Successfully executed get all categories, response entity-{}", responseEntity);
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<CategoryDetailsDto> create(@RequestBody CreateCategoryRequestDto requestDto) {
        log.info("Executing create votes rest API, request-{}", requestDto);

        ResponseEntity<CategoryDetailsDto> responseEntity = ResponseEntity.ok(facade.create(requestDto));

        log.info("Successfully executed create category, response entity-{}", responseEntity);
        return responseEntity;
    }
}

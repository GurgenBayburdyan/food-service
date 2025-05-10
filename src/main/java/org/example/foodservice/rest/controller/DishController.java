package org.example.foodservice.rest.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.foodservice.rest.dto.request.CreateDishRequestDto;
import org.example.foodservice.rest.dto.response.DishDetailsDto;
import org.example.foodservice.rest.facade.DishFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gurgen Bayburdyan
 */

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/dishes")
public class DishController {

    private final DishFacade facade;

    @GetMapping
    public ResponseEntity<List<DishDetailsDto>> getAll() {
        log.info("Executing get all votes rest API");

        ResponseEntity<List<DishDetailsDto>> responseEntity = ResponseEntity.ok(facade.getAll());

        log.info("Successfully executed get all dishes, response entity-{}", responseEntity);
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<DishDetailsDto> create(@RequestBody CreateDishRequestDto requestDto) {
        log.info("Executing create dish rest API, request-{}", requestDto);

        ResponseEntity<DishDetailsDto> responseEntity = ResponseEntity.ok(facade.create(requestDto));

        log.info("Successfully executed create dish, response entity-{}", responseEntity);
        return responseEntity;
    }
}

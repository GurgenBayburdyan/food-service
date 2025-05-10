package org.example.foodservice.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Gurgen Bayburdyan
 */

@Getter
@Setter
@ToString
public class CreateCategoryRequestDto {

    @JsonProperty("name")
    private String name;

}

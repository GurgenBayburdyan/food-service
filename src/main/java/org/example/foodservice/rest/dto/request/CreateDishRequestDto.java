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
public class CreateDishRequestDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private Integer price;

    @JsonProperty("description")
    private String description;

    @JsonProperty("categoryId")
    private Long categoryId;

    @JsonProperty("imageUrl")
    private String imageUrl;

}

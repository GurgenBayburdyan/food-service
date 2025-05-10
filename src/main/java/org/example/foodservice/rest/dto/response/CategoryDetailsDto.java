package org.example.foodservice.rest.dto.response;

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
public class CategoryDetailsDto extends AbstractErrorAwareDetailsDto {


    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    public CategoryDetailsDto(ErrorType errorType) {
        super(errorType);
    }

    public CategoryDetailsDto() {
        super(null);
    }
}

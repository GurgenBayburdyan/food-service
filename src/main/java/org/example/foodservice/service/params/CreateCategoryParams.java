package org.example.foodservice.service.params;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.Assert;

/**
 * @author Gurgen Bayburdyan
 */

@Getter
@Setter
@ToString
public class CreateCategoryParams {

    private final String name;

    public CreateCategoryParams(String name) {
        Assert.notNull(name, "the name should not be null");
        this.name = name;
    }

}

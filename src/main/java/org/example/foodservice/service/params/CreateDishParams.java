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
public class CreateDishParams {

    private final String name;
    private final Integer price;
    private final String description;
    private final Long categoryId;
    private final String imageUrl;

    public CreateDishParams(Long categoryId, String name, Integer price, String description, String imageUrl) {
        Assert.notNull(name, "the name should not be null");
        this.name = name;
        Assert.notNull(price, "the price should not be null");
        this.price = price;
        Assert.notNull(description, "the description should not be null");
        this.description = description;
        Assert.notNull(categoryId, "the category id should not be null");
        this.categoryId = categoryId;
        Assert.notNull(imageUrl, "the image url should not be null");
        this.imageUrl = imageUrl;
    }
}

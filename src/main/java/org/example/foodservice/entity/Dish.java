package org.example.foodservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Gurgen Bayburdyan
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 15)
    private String name;

    @Column(name = "price", nullable = false, length = 15)
    private Integer price;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, foreignKey = @ForeignKey(name = "FK_DISH_CATEGORY_ID"))
    private Category category;

    @Column(name = "image_Url", nullable = false)
    private String imageUrl;

}

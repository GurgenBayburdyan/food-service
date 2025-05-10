package org.example.foodservice.rest.dto.response;

/**
 * @author Gurgen Bayburdyan
 */

public enum ErrorType {
    MISSING_NAME,

    MISSING_CATEGORY_ID,
    MISSING_PRICE,
    MISSING_DESCRIPTION,
    MISSING_IMAGE_URL,
    CATEGORY_NOT_FOUND,
}

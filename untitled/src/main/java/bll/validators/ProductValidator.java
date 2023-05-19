package bll.validators;

import models.Product;
/**
 * The ProductValidator class is responsible for validating Product objects.
 * It implements the Validator interface.
 */
public class ProductValidator implements Validator<Product> {
    /**
     * Validates the given Product object.
     * Checks if the product's name, price, and stock are valid.
     *
     * @param product the Product object to be validated
     * @throws IllegalArgumentException if the product's name, price, or stock is invalid
     */
    public void validate(Product product) {
        String error = "";
        if (product.getName().length() == 0)
            error += "invalid name!\n";
        if (product.getPrice() < 0)
            error += "invalid price!\n";
        if (product.getStock() < 0)
            error += "invalid stock!\n";
        if (error.length()!=0)
            throw new IllegalArgumentException(error);
    }
}

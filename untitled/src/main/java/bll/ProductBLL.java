package bll;

/**

 The ProductBLL class represents the business logic layer for handling Product-related operations.
 It provides methods to interact with the data access layer (ProductDAO) and perform operations
 such as inserting, updating, deleting, and finding products.
 */
import DAO.ClientDAO;
import DAO.ProductDAO;
import bll.validators.ClientValidator;
import bll.validators.ProductValidator;
import bll.validators.Validator;
import models.Client;
import models.Product;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductBLL {

    private ProductValidator validator;
    private ProductDAO productDAO;
    /**
     * Constructs a new instance of the ProductBLL class.
     * Initializes the ProductValidator and ProductDAO objects.
     */
    public ProductBLL() {
        validator= new ProductValidator();
        productDAO = new ProductDAO();
    }
    /**
     * Inserts a new product into the database.
     *
     * @param product the product object to be inserted
     */
    public void insert(Product product) {

        validator.validate(product);
        productDAO.insert(product);
    }
    /**
     * Retrieves all products from the database.
     *
     * @return a 2D array representation of the products
     * @throws NoSuchElementException if the table is empty
     */
    public String[][] findAll() {
        List<Product> productsList = productDAO.findAll();
        if (productsList.isEmpty()) {
            throw new NoSuchElementException("The table is empty!");
        }
        String[][] productsArray = new String[productsList.size()][];
        AtomicInteger numberOfClients = new AtomicInteger();
        for (Product product : productsList) {
            productsArray[numberOfClients.getAndIncrement()] = product.getFieldValues();
        }
        return productsArray;
    }
    /**
     * Updates a product's field with the specified value.
     *
     * @param object     the name of the object/table to update
     * @param field      the name of the field to update
     * @param fieldValue the new value of the field
     * @param id         the ID of the product to update
     * @throws SQLException              if an error occurs during the database operation
     * @throws IntrospectionException    if an error occurs during introspection
     * @throws InvocationTargetException if an error occurs during method invocation
     * @throws IllegalAccessException    if access to a field, method, or constructor is denied
     */
    public void update(String object,String field, String fieldValue, int id) throws SQLException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        productDAO.update(object,field,fieldValue,id);
    }

    /**
     * Deletes a product from the database.
     *
     * @param product the product object to be deleted
     * @param id      the ID of the product to be deleted
     * @throws SQLException              if an error occurs during the database operation
     * @throws IntrospectionException    if an error occurs during introspection
     * @throws InvocationTargetException if an error occurs during method invocation
     * @throws IllegalAccessException    if access to a field, method, or constructor is denied
     */
    public void delete(Product product,int id) throws SQLException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        productDAO.delete(product,id);
    }

    /**
     * Finds a product by its ID.
     *
     * @param id the ID of the product to find
     * @return the found product object, or null if not found
     */
    public Product findById(int id)  {
        Product product = productDAO.findById(id);
        if (product == null) {
            System.out.println(("The product with id = " + id + " was not found!"));
        }
        return product;
    }
}

package bll;
/**

 The ClientBLL class represents the business logic layer for handling Client-related operations.
 It provides methods to interact with the data access layer (ClientDAO) and perform operations
 such as inserting, updating, deleting, and finding clients.
 */
import DAO.ClientDAO;
import DAO.OrderDAO;
import bll.validators.ClientValidator;
import bll.validators.OrderValidator;
import bll.validators.Validator;
import models.Client;
import models.Order;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderBLL {
    private OrderValidator validator;
    private OrderDAO orderDAO;

    /**
     * Constructs a new instance of the OrderBLL class.
     * Initializes the OrderValidator and OrderDAO objects.
     */
    public OrderBLL() {
        validator = new OrderValidator();
        orderDAO = new OrderDAO();
    }
    /**
     * Retrieves all orders from the database.
     *
     * @return a 2D array representation of the orders
     * @throws NoSuchElementException if the table is empty
     */
    public String[][] findAll() {
        List<Order> ordersList = orderDAO.findAll();
        if (ordersList.isEmpty()) {
            throw new NoSuchElementException("The table is empty!");
        }
        String[][] clientsArray = new String[ordersList.size()][];
        AtomicInteger numberOfClients = new AtomicInteger();
        for (Order order : ordersList) {
            clientsArray[numberOfClients.getAndIncrement()] = order.getFieldValues();
        }
        return clientsArray;
    }
    /**
     * Inserts a new order into the database.
     *
     * @param order the order object to be inserted
     */
    public void insert(Order order) {

       // validator.validate(client);
        orderDAO.insert(order);
    }
    /**
     * Updates a order's field with the specified value.
     *
     * @param object     the name of the object/table to update
     * @param field      the name of the field to update
     * @param fieldValue the new value of the field
     * @param id         the ID of the order to update
     * @throws SQLException              if an error occurs during the database operation
     * @throws IntrospectionException    if an error occurs during introspection
     * @throws InvocationTargetException if an error occurs during method invocation
     * @throws IllegalAccessException    if access to a field, method, or constructor is denied
     */
    public void update(String object,String field, String fieldValue, int id) throws SQLException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        orderDAO.update(object,field,fieldValue,id);
    }
//    public T findById(int id) {
//        return T;
//    }
   // }
}

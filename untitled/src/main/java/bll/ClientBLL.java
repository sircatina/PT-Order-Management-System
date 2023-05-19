package bll;

import DAO.ClientDAO;
import bll.validators.ClientValidator;
import bll.validators.Validator;
import models.Client;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;


public class ClientBLL {
    private ClientValidator validator;
    private ClientDAO clientDAO;
    /**
     * Constructs a new instance of the ClientBLL class.
     * Initializes the ClientValidator and ClientDAO objects.
     */
    public ClientBLL() {
        validator=new ClientValidator();
        clientDAO = new ClientDAO();
    }
    /**
     * Inserts a new client into the database.
     *
     * @param client the client object to be inserted
     */
    public void insert(Client client) {

        validator.validate(client);
        clientDAO.insert(client);
    }
    /**
     * Retrieves all clients from the database.
     *
     * @return a 2D array representation of the clients
     * @throws NoSuchElementException if the table is empty
     */
    public String[][] findAll() {
        List<Client> clientsList = clientDAO.findAll();
        if (clientsList.isEmpty()) {
            throw new NoSuchElementException("The table is empty!");
        }
        String[][] clientsArray = new String[clientsList.size()][];
        AtomicInteger numberOfClients = new AtomicInteger();
        for (Client client : clientsList) {
            clientsArray[numberOfClients.getAndIncrement()] = client.getFieldValues();
        }
        return clientsArray;
    }
    /**
     * Updates a client's field with the specified value.
     *
     * @param obeject     the name of the object/table to update
     * @param field      the name of the field to update
     * @param fieldValue the new value of the field
     * @param id         the ID of the client to update
     * @throws SQLException              if an error occurs during the database operation
     * @throws IntrospectionException    if an error occurs during introspection
     * @throws InvocationTargetException if an error occurs during method invocation
     * @throws IllegalAccessException    if access to a field, method, or constructor is denied
     */
    public void update(String obeject,String field, String fieldValue, int id) throws SQLException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        clientDAO.update(obeject,field,fieldValue,id);
    }
    /**
     * Deletes a client from the database.
     *
     * @param client the client object to delete
     * @param id     the ID of the client to delete
     * @throws SQLException              if an error occurs during the database operation
     * @throws IntrospectionException    if an error occurs during introspection
     * @throws InvocationTargetException if an error occurs during method invocation
     * @throws IllegalAccessException    if access to a field, method, or constructor is denied
     */
    public void delete(Client client,int id) throws SQLException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        clientDAO.delete(client,id);
    }
    /**
     * Finds a client by ID.
     *
     * @param id the ID of the client to find
     * @return the found client object, or null if not found
     */
    public Client findById(int id) {
        Client client = clientDAO.findById(id);
        if (client == null) {
            System.out.println(("The client with id = " + id + " was not found!"));
        }
        return client;
    }
}

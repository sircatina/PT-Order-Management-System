package bll.validators;

import models.Client;
/**
 * The ClientValidator class is responsible for validating Client objects.
 * It implements the Validator interface.
 */
public class ClientValidator implements Validator<Client> {

    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 150;

    /**
     * Validates the given Client object.
     * Checks if the client's name, address, and age are valid.
     *
     * @param client the Client object to be validated
     * @throws IllegalArgumentException if the client's name, address, or age is invalid
     */
    public void validate(Client client) {
        String error = "";
        if (client.getName().length() == 0)
            error += "invalid name!\n";
        if (client.getAddress().length() == 0)
            error += "invalid address!\n";
        if (client.getAge() < MIN_AGE || client.getAge() > MAX_AGE)
            error += "invalid age!\n";
        if (error.length() != 0)
            throw new IllegalArgumentException(error);
    }
}
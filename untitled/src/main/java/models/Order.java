package models;

/**
 * The Order class represents an order.
 * It contains properties such as id, client, product, and quantity.
 */
public class Order {

    private int id;
    private int client;
    private int product;
    private int quantity;

    /**
     * Constructor for the Order class.
     *
     * @param id       The ID of the order.
     * @param idClient The ID of the client.
     * @param idProduct The ID of the product.
     * @param quantity The quantity of the order.
     */
    public Order(int id, int idClient, int idProduct, int quantity) {
        this.id = id;
        this.client = idClient;
        this.product = idProduct;
        this.quantity = quantity;
    }

    /**
     * Constructor for the Order class.
     *
     * @param idClient The ID of the client.
     * @param idProduct The ID of the product.
     * @param quantity The quantity of the order.
     */
    public Order(int idClient, int idProduct, int quantity) {
        this.client = idClient;
        this.product = idProduct;
        this.quantity = quantity;
    }

    /**
     * Default constructor for the Order class.
     */
    public Order() {
    }

    /**
     * Retrieves the ID of the order.
     *
     * @return The ID of the order.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the order.
     *
     * @param id The ID of the order.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the ID of the client.
     *
     * @return The ID of the client.
     */
    public int getClient() {
        return client;
    }

    /**
     * Sets the ID of the client.
     *
     * @param idClient The ID of the client.
     */
    public void setClient(int idClient) {
        this.client = idClient;
    }

    /**
     * Retrieves the ID of the product.
     *
     * @return The ID of the product.
     */
    public int getProduct() {
        return product;
    }

    /**
     * Sets the ID of the product.
     *
     * @param idProduct The ID of the product.
     */
    public void setProduct(int idProduct) {
        this.product = idProduct;
    }

    /**
     * Retrieves the quantity of the order.
     *
     * @return The quantity of the order.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the order.
     *
     * @param quantity The quantity of the order.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Retrieves an array of field values of the order.
     *
     * @return An array of field values.
     */
    public String[] getFieldValues() {
        String[] fieldValues = new String[4];
        fieldValues[0] = String.valueOf(id);
        fieldValues[1] = String.valueOf(client);
        fieldValues[2] = String.valueOf(product);
        fieldValues[3] = String.valueOf(quantity);
        return fieldValues;
    }

    /**
     * Returns a string representation of the order.
     *
     * @return A string representation of the order.
     */
    public String toString(){
        return "[id= " + id +
                ", clientID= " + client +
                ", productID= " + product +
                ", quantity= " + quantity +
                "]";
    }
}

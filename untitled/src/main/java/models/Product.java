package models;

/**
 * The Product class represents a product.
 * It contains properties such as id, name, price, and stock.
 */
public class Product {

    private int id;
    private String name;
    private int price;
    private int stock;

    /**
     * Default constructor for the Product class.
     */
    public Product() {
    }

    /**
     * Constructor for the Product class.
     *
     * @param id    The ID of the product.
     * @param name  The name of the product.
     * @param price The price of the product.
     * @param stock The stock quantity of the product.
     */
    public Product(int id, String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Constructor for the Product class.
     *
     * @param name  The name of the product.
     * @param price The price of the product.
     * @param stock The stock quantity of the product.
     */
    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Constructor for the Product class.
     *
     * @param id The ID of the product.
     */
    public Product(int id) {
        this.id = id;
    }

    /**
     * Retrieves the ID of the product.
     *
     * @return The ID of the product.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the product.
     *
     * @param id The ID of the product.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the price of the product.
     *
     * @return The price of the product.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The price of the product.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Retrieves the stock quantity of the product.
     *
     * @return The stock quantity of the product.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the stock quantity of the product.
     *
     * @param stock The stock quantity of the product.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Retrieves an array of field values of the product.
     *
     * @return An array of field values.
     */
    public String[] getFieldValues() {
        String[] fieldValues = new String[4];
        fieldValues[0] = String.valueOf(id);
        fieldValues[1] = name;
        fieldValues[2] = String.valueOf(price);
        fieldValues[3] = String.valueOf(stock);
        return fieldValues;
    }

    /**
     * Returns a string representation of the product.
     *
     * @return A string representation of the product.
     */
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
    }
}

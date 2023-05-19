package models;

/**
 * The Client class represents a client.
 * It contains properties such as id, name, age, and address.
 */
public class Client {

    private int id;
    private String name;
    private int age;
    private String address;

    /**
     * Default constructor for the Client class.
     */
    public Client() {
    }

    /**
     * Constructor for the Client class.
     *
     * @param id      The ID of the client.
     * @param name    The name of the client.
     * @param age     The age of the client.
     * @param address The address of the client.
     */
    public Client(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * Constructor for the Client class.
     *
     * @param name    The name of the client.
     * @param age     The age of the client.
     * @param address The address of the client.
     */
    public Client(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * Constructor for the Client class.
     *
     * @param id The ID of the client.
     */
    public Client(int id) {
        this.id = id;
    }

    /**
     * Retrieves the ID of the client.
     *
     * @return The ID of the client.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the client.
     *
     * @param id The ID of the client.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the client.
     *
     * @return The name of the client.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the client.
     *
     * @param name The name of the client.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the age of the client.
     *
     * @return The age of the client.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the client.
     *
     * @param age The age of the client.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Retrieves the address of the client.
     *
     * @return The address of the client.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the client.
     *
     * @param address The address of the client.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Retrieves an array of field values of the client.
     *
     * @return An array of field values.
     */
    public String[] getFieldValues() {
        String[] fieldValues = new String[4];
        fieldValues[0] = String.valueOf(id);
        fieldValues[1] = name;
        fieldValues[2] = String.valueOf(age);
        fieldValues[3] = address;
        return fieldValues;
    }

    /**
     * Returns a string representation of the client.
     *
     * @return A string representation of the client.
     */
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + "]";
    }
}

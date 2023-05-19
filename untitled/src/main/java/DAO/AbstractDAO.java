package DAO;

/**

 The AbstractDAO class provides common methods for data access objects (DAOs).
 It uses generics to support CRUD operations for any entity type.
 @param <T> the entity type
 */
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import models.Client;

import static connection.ConnectionFactory.getConnection;

/**
 The AbstractDAO class provides common methods for data access objects (DAOs).
 It uses generics to support CRUD operations for any entity type.
 @param <T> the entity type
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;
    /**

     Constructs a new instance of the AbstractDAO class.
     It determines the entity type based on the generic parameter of the concrete subclass.
     */
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }
    /**

     Creates the SELECT query for retrieving an entity by a specific field value.
     @param field the field name
     @return the SELECT query string
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }
    /**

     Creates the SELECT query for retrieving all entities of the given type.
     @return the SELECT query string
     */
    private String createSelectAllQuery() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT ");
        stringBuilder.append(" * ");
        stringBuilder.append(" FROM schooldb.");
        stringBuilder.append(type.getSimpleName());
        return stringBuilder.toString();

    }
    /**

     Retrieves all entities of the given type from the database.

     @return a list of entities
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        List<Object> toReturn = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return null;
    }
    /**

     Retrieves an entity with the specified ID from the database.
     @param id the ID of the entity
     @return the entity object
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if(createObjects(resultSet).get(0)!=null)
            return createObjects(resultSet).get(0);
            else return null;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
    /**
     * Creates a list of objects of type T from the given ResultSet.
     *
     * @param resultSet The ResultSet containing the data.
     * @return A list of objects created from the ResultSet.
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     * Inserts an object of type T into the database.
     *
     * @param t The object to be inserted.
     * @return The inserted object.
     */
    public T insert(T t) {

        String tableName = t.getClass().getSimpleName();
        StringBuilder insertQuery = new StringBuilder();
        insertQuery.append("INSERT INTO `schooldb`.`").append(tableName).append("` (");
        // Get the column names from the database metadata
        try {
            Connection conn = getConnection();
            DatabaseMetaData metadata = conn.getMetaData();
            ResultSet columns = metadata.getColumns(null, null, tableName, null);
            // Iterate over the columns and add them to the insert query
            boolean first = true;
            boolean id = true;//daca ii id true inseamna ca ii id ul
            while (columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                if (!id) {
                    if (!first) {
                        insertQuery.append(", ");
                    }
                    insertQuery.append("`" + columnName + "`");
                    first = false;
                }
                id = false;
            }
            columns.close();
            insertQuery.append(") VALUES (");
            int numberOfFields = t.getClass().getDeclaredFields().length;
            insertQuery.append("?,".repeat(Math.max(0, numberOfFields - 2))).append("?)");
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery.toString());
            int fieldNumber = 1;
            boolean firstFieldPassed = false;
            for (Field field : t.getClass().getDeclaredFields()) {
                if (!firstFieldPassed) {
                    firstFieldPassed = true;
                    continue; // skip the first field
                }
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), t.getClass());
                Method method = propertyDescriptor.getReadMethod();
                String param = method.invoke(t).toString();
                preparedStatement.setString(fieldNumber, param);
                fieldNumber++;
            }
            // Execute the SQL statement and handle any exceptions
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Successfully inserted 1 row into the database.");
            } else {
                System.out.println("Failed to insert row into the database.");
            }
            preparedStatement.close();
        } catch (SQLException | IntrospectionException | IllegalAccessException | InvocationTargetException ex) {
            // Handle the exception
            ex.printStackTrace();
        }
        // TODO:
        return t;
    }
    /**
     * Updates a row in the database table.
     *
     * @param object      The name of the table to update.
     * @param field       The field to update.
     * @param fieldValue  The new value for the field.
     * @param id          The ID of the row to update.
     * @throws SQLException               If a database access error occurs.
     * @throws IntrospectionException     If an introspection exception occurs.
     * @throws InvocationTargetException If an invocation target exception occurs.
     * @throws IllegalAccessException    If an illegal access exception occurs.
     */
    public void update(String object, String field, String fieldValue, int id) throws SQLException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE schooldb.").append(object).append(" SET ");
        sb.append(field).append(" =? ");
        sb.append(" WHERE id =?");
        //System.out.println(sb);
        Connection connection = ConnectionFactory.getConnection();
        String updateQuery = String.valueOf(sb);
        PreparedStatement statement = connection.prepareStatement(updateQuery);
        statement.setString(1, fieldValue); //pt set=?
        statement.setInt(2, id);      //pt where id =?

        // Execute the SQL statement and handle any exceptions
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected == 1) {
            System.out.println("Successfully updated 1 row into the database.");
        } else {
            System.out.println("Failed to update into the database.");
        }
        statement.close();
    }
    /**
     * Deletes a row from the database table.
     *
     * @param t   The object representing the table.
     * @param id  The ID of the row to delete.
     * @return The deleted object.
     * @throws SQLException               If a database access error occurs.
     * @throws IntrospectionException     If an introspection exception occurs.
     * @throws InvocationTargetException If an invocation target exception occurs.
     * @throws IllegalAccessException    If an illegal access exception occurs.
     */
    public T delete(T t,int id) throws SQLException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        String tableName = t.getClass().getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append("Delete from schooldb.").append(tableName);
        sb.append(" WHERE id =?");
        Connection connection = ConnectionFactory.getConnection();
        String deleteQuery = String.valueOf(sb);
        PreparedStatement statement = connection.prepareStatement(deleteQuery);
        statement.setInt(1, id);      //pt where id =?
        System.out.println(sb);
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected == 1) {
            System.out.println("Successfully deleted 1 row into the database.");
        } else {
            System.out.println("Failed to delete into the database.");
        }
        statement.close();
        // TODO:
        return t;
    }
}
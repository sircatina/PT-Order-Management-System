package DAO;

import connection.ConnectionFactory;
import models.Bill;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * The BillDAO class provides methods to interact with the "bill" table in the database.
 */
public class BillDAO {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    /**
     * Inserts a Bill object into the "bill" table.
     *
     * @param bill The Bill object to be inserted.
     * @return The inserted Bill object.
     */
    public Bill insert(Bill bill)  {
        Connection connection = null;
        PreparedStatement statement = null;
        int resultSet = -1;
       try {
           String query = "INSERT INTO `schooldb`.`bill` (`idorder`, `price`, `date`) VALUES (?,?,?)";
           connection = ConnectionFactory.getConnection();
           //statement = connection.prepareStatement(query, statement.RETURN_GENERATED_KEYS);
           statement = connection.prepareStatement(query);
           statement.setInt(1, bill.idorder());
           statement.setInt(2, bill.price());
           statement.setString(3, bill.date());
           resultSet = statement.executeUpdate();
       }
       catch (SQLException e) {
           LOGGER.log(Level.WARNING, "BillRepository: insert " + e.getMessage());
       } finally {
           ConnectionFactory.close(connection);
           ConnectionFactory.close(statement);
       }
        return bill;
    }
}

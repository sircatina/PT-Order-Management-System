package bll;

import DAO.BillDAO;
import DAO.ClientDAO;
import models.Bill;
import models.Client;

import java.sql.SQLException;
/**
 * Constructs a new instance of the BillBLL class.
 * Initializes the BillDAO object.
 */
public class BillBLL {
    private BillDAO billDAO;

    public BillBLL() {
        this.billDAO = new BillDAO();
    }
    /**
     * Inserts a new bill into the database.
     *
     * @param bill the bill object to be inserted
     * @throws SQLException if an error occurs during the database operation
     */
    public void insert(Bill bill)  {
        billDAO.insert(bill);
    }
}

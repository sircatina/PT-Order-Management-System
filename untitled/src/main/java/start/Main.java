package start;

import bll.ClientBLL;
import bll.ProductBLL;
import com.mysql.cj.jdbc.ConnectionImpl;
import connection.ConnectionFactory;
import models.Client;
import models.Product;
import presentation.*;

import java.sql.Connection;

/**
 * The main class of the application.
 */
public class Main {

    /**
     * The entry point of the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ViewStart viewStart = new ViewStart();
        Controller controller = new Controller(viewStart);
    }
}
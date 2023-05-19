package presentation;

import java.time.LocalDate;

import DAO.AbstractDAO;
import bll.BillBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import models.Bill;
import models.Client;
import bll.ClientBLL;
import models.Order;
import models.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.NoSuchElementException;

/**
 * The Controller class handles the interaction between the View and the Business Logic Layer (BLL).
 * It listens to events triggered by the user interface and performs the necessary actions.
 */
public class Controller {
    private ViewStart viewStart;
    private ViewClient viewClient;
    private ViewOrder viewOrder;
    private ViewProduct viewProduct;
    private TableView tableView;
    private ProductBLL productBLL = new ProductBLL();
    private OrderBLL orderBLL = new OrderBLL();
    private ClientBLL clientBLL = new ClientBLL();
    private BillBLL billBLL = new BillBLL();
    private boolean ok = false;

    /**
     * Constructs a Controller object with a given ViewStart instance.
     *
     * @param viewStart The ViewStart instance.
     */
    public Controller(ViewStart viewStart) {
        this.viewStart = viewStart;
        this.viewStart.addOrderListener(new OrderButtonListener());
        this.viewStart.addClientListener(new ClientButtonListener());
        this.viewStart.addProductListener(new ProductButtonListener());

        viewProduct = new ViewProduct();
        this.viewProduct.addAddProductListener(new AddProductButtonListener());
        this.viewProduct.addDeleteProductListener(new DeleteProductButtonListener());
        this.viewProduct.addUpdateProductListener(new UpdateProductButtonListener());
        this.viewProduct.addShowProductListener(new ShowProductButtonListener());

        viewClient = new ViewClient();
        this.viewClient.addAddClientListener(new AddClientButtonListener());
        this.viewClient.addDeleteClientListener(new DeleteClientButtonListener());
        this.viewClient.addShowClientListener(new ShowClientButtonListener());
        this.viewClient.addUpdateClientListener(new UpdateClientButtonListener());

        viewOrder = new ViewOrder();
        this.viewOrder.addShowOrderListener(new ShowOrderButtonListener());
        this.viewOrder.addADDOrderListener(new AddOrderButtonListener());
        this.viewOrder.addBillOrderListener(new BillButtonListener());
    }

    /**
     * ActionListener implementation for the order button.
     */
    class OrderButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                viewOrder.setVisible(true);
            } catch (Exception exception) {
                viewOrder.showMessage1("Doesn't work :(");
            }
        }
    }

    /**
     * ActionListener implementation for the client button.
     */
    class ClientButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                viewClient.setVisible(true);
            } catch (Exception exception) {
                viewClient.showMessage1("Doesn't work :(");
            }
        }
    }

    /**
     * ActionListener implementation for the product button.
     */
    class ProductButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                viewProduct.setVisible(true);
            } catch (Exception exception) {
                viewProduct.showMessage1("Doesn't work :(");
            }
        }
    }

    /**
     * ActionListener implementation for the "Add Product" button.
     */
    class AddProductButtonListener implements ActionListener {
        /**
         * Invoked when the "Add Product" button is clicked.
         * Attempts to add a new product based on the input fields.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String name = String.valueOf(viewProduct.getNamePRtextField().getText());
                int price = Integer.parseInt(viewProduct.getPricePRField().getText());
                int stock = Integer.parseInt(viewProduct.getStockPRtextField().getText());
                productBLL.insert(new Product(name, price, stock));
                viewProduct.showMessage1("The product was added :)");
            } catch (Exception exception) {
                viewProduct.showMessage1("Doesn't work :(");
            }
        }
    }

    /**
     * ActionListener implementation for the "Delete Product" button.
     */
    class DeleteProductButtonListener implements ActionListener {
        /**
         * Invoked when the "Delete Product" button is clicked.
         * Attempts to delete a product based on the input ID.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int id = Integer.parseInt(viewProduct.getIDtextField().getText());
                Product product = new Product(id);
                productBLL.delete(product, id);
            } catch (Exception exception) {
                viewProduct.showMessage1("Doesn't work :(");
            }
        }
    }

    /**
     * ActionListener implementation for the "Update Product" button.
     */
    class UpdateProductButtonListener implements ActionListener {
        /**
         * Invoked when the "Update Product" button is clicked.
         * Attempts to update a product based on the input fields.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int id = Integer.parseInt(viewProduct.getIDtextField().getText());
                String object = "Product";

                if (!viewProduct.getStockPRtextField().getText().equals("")) {
                    String update = "stock";
                    productBLL.update(object, update, viewProduct.getStockPRtextField().getText(), id);
                }
                if (!viewProduct.getNamePRtextField().getText().equals("")) {
                    String update = "name";
                    productBLL.update(object, update, viewProduct.getNamePRtextField().getText(), id);
                }
                if (!viewProduct.getPricePRField().getText().equals("")) {
                    String update = "price";
                    productBLL.update(object, update, viewProduct.getPricePRField().getText(), id);
                }
            } catch (Exception exception) {
                viewProduct.showMessage1("Doesn't work :(");
            }
        }
    }

    /**
     * ActionListener implementation for the "Show Product" button.
     */
    class ShowProductButtonListener implements ActionListener {
        /**
         * Invoked when the "Show Product" button is clicked.
         * Displays a table view of products.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ProductBLL productBLL2 = new ProductBLL();
                tableView = new TableView(new Product(), productBLL2);
            } catch (Exception exception) {
                viewProduct.showMessage1("Doesn't work :(");
            }
        }
    }

    /**
     * ActionListener implementation for the "Add Client" button.
     */
    class AddClientButtonListener implements ActionListener {
        /**
         * Invoked when the "Add Client" button is clicked.
         * Attempts to add a new client based on the input fields.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String name = viewClient.getNameCLtextField();
                int age = Integer.parseInt(viewClient.getAgeCLField().getText());
                String address = viewClient.getAddressCLtextField();
                Client client = new Client(name, age, address);
                clientBLL.insert(client);
                viewClient.showMessage1("The client was added :)");
            } catch (Exception exception) {
                viewClient.showMessage1("Doesn't work :(");
            }
        }
    }

    /**
     * ActionListener implementation for the "Delete Client" button.
     */
    class DeleteClientButtonListener implements ActionListener {
        /**
         * Invoked when the "Delete Client" button is clicked.
         * Attempts to delete a client based on the input ID.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int id = viewClient.getIDtextField();
                Client client = new Client(id);
                clientBLL.delete(client, id);
            } catch (Exception exception) {
                viewClient.showMessage1("Doesn't work :(");
            }
        }
    }

    /**
     * ActionListener implementation for the "Update Client" button.
     */
    class UpdateClientButtonListener implements ActionListener {
        /**
         * Invoked when the "Update Client" button is clicked.
         * Attempts to update a client based on the input fields.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int id = viewClient.getIDtextField();
                int age = 0;

                if (!viewClient.getAgeCLField().getText().equals("")) {
                    age = Integer.parseInt(viewClient.getAgeCLField().getText());
                }

                String object = "Client";
                if (!viewClient.getNameCLtextField().equals("")) {
                    String update = "name";
                    clientBLL.update(object, update, String.valueOf(viewClient.getNameCLtextField()), id);
                }
                if (!viewClient.getAddressCLtextField().equals("")) {
                    String update = "address";
                    clientBLL.update(object, update, String.valueOf(viewClient.getAddressCLtextField()), id);
                }
                if (age != 0) {
                    String update = "age";
                    clientBLL.update(object, update, viewClient.getAgeCLField().getText(), id);
                }
            } catch (Exception exception) {
                viewClient.showMessage1("Doesn't work :(");
            }
        }
    }

    /**
     * ActionListener implementation for the "Show Client" button.
     */
    class ShowClientButtonListener implements ActionListener {
        /**
         * Invoked when the "Show Client" button is clicked.
         * Displays a table view of clients.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                tableView = new TableView(new Client(), clientBLL);
            } catch (Exception exception) {
                viewClient.showMessage1("Doesn't work :(");
            }
        }
    }

    /**
     * ActionListener implementation for the "Show Order" button.
     */
    class ShowOrderButtonListener implements ActionListener {
        /**
         * Invoked when the "Show Order" button is clicked.
         * Displays a table view of orders.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                tableView = new TableView(new Order(), orderBLL);
            } catch (Exception exception) {
                viewOrder.showMessage1("Doesn't work :(");
            }
        }
    }

    /**
     * ActionListener implementation for the "Add Order" button.
     */
    class AddOrderButtonListener implements ActionListener {
        /**
         * Invoked when the "Add Order" button is clicked.
         * Attempts to add a new order based on the input fields.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int quantity = viewOrder.getQuantitytextField();
                int idClient = viewOrder.getClientField();
                int idProduct = viewOrder.getProductField();
                Order order = new Order(idClient, idProduct, quantity);
                Product product = productBLL.findById(idProduct);

                if (product == null) {
                    viewOrder.showMessage1("Doesn't work because the id is not found :(");
                    ok = false;
                }

                if (product.getStock() > quantity) {
                    int value = product.getStock() - quantity;
                    orderBLL.update("Product", "stock", String.valueOf(value), idProduct);
                    orderBLL.insert(order);
                    viewOrder.showMessage1("Order was added :)");
                    ok = true;
                } else {
                    viewOrder.showMessage1("Stock is too low :(");
                    ok = false;
                }
            } catch (SQLException | IntrospectionException | InvocationTargetException | IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * ActionListener implementation for the "Bill" button.
     */
    class BillButtonListener implements ActionListener {
        /**
         * Invoked when the "Bill" button is clicked.
         * Generates and displays a bill based on the order details.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (ok) {
                    int idProduct = viewOrder.getProductField();
                    Product product = productBLL.findById(idProduct);
                    int price = viewOrder.getQuantitytextField() * product.getPrice();
                    LocalDate currentDate = LocalDate.now();
                    int year = currentDate.getYear();
                    int month = currentDate.getMonthValue();
                    int day = currentDate.getDayOfMonth();
                    String date = day + "." + month + "." + year;
                    Bill bill = new Bill(product.getId(), price, date);
                    billBLL.insert(bill);
                    viewOrder.showMessage1("NEW BILL: PRODUCT " + product.getId() + ", PRICE " + price + ", DATE " + date);
                }
            } catch (Exception exception) {
                viewOrder.showMessage1("Doesn't work :(");
            }
        }
    }
}

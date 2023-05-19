package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * A class responsible for creating a window that contains a table.
 */
public class TableView extends JFrame {

    private JTable table;
    private JPanel panel;

    /**
     * Constructor for the TableView window.
     *
     * @param modelObject the model object
     * @param objectBLL   the business logic object
     */
    public TableView(Object modelObject, Object objectBLL) {
        panel = new JPanel();
        createTable(modelObject, objectBLL);
        createScrollBar();
        this.setTitle("Table");
        this.add(panel);
        this.setSize(600, 300);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    /**
     * Calls the reflection method to create the table.
     *
     * @param modelObject the model object
     * @param objectBLL   the business logic object
     */
    private void createTable(Object modelObject, Object objectBLL) {
        String[] header = createHeader(modelObject);
        String[][] data = populateTable(objectBLL);
        DefaultTableModel model = new DefaultTableModel(data, header);
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(550, 200));
        table.setFillsViewportHeight(true);
    }

    /**
     * Creates the table header based on the model object's fields.
     *
     * @param t the model object
     * @return an array of header table fields
     */
    public static String[] createHeader(Object t) {
        List<String> fields = new ArrayList<>();
        for (Field field : t.getClass().getDeclaredFields()) {
            fields.add(field.getName());
        }
        String[] headerTableFields = new String[fields.size()];
        fields.toArray(headerTableFields);
        return headerTableFields;
    }

    /**
     * Populates the table with data obtained from the business logic object's "findAll" method.
     *
     * @param t the business logic object
     * @return a two-dimensional array of table data
     */
    public static String[][] populateTable(Object t) {
        String[][] data = null;
        try {
            Method[] methods = t.getClass().getDeclaredMethods();
            Method findAllMethod = null;
            for (Method method : methods) {
                if (method.getName().equals("findAll")) {
                    findAllMethod = method;
                    break;
                }
            }
            Object result = findAllMethod.invoke(t);
            data = (String[][]) result;
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * Creates a scroll bar for the table.
     */
    private void createScrollBar() {
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVisible(true);
        panel.add(scrollPane);
    }
}
package app;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public Database() {
        connect();
        createTable();
        addExampleProducts();
    }

    /**
     * Connect to products database
     */
    private void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/point_of_sale", "root", "");
            System.out.println("Successful connection.");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Nie udało się połączyć z bazą danych", ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create table of products
     */
    private void createTable() {
        String sql = "CREATE OR REPLACE TABLE PRODUCTS (" +
                "ID INT NOT NULL, " +
                "NAME VARCHAR(100) NOT NULL, " +
                "PRICE DECIMAL(8, 2) NOT NULL, " +
                "PRIMARY KEY(ID))";
        try {
            statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add example products to products table
     */
    private void addExampleProducts() {
        Product[] exampleProducts = {
                new Product(0, "Water", 1.59),
                new Product(1, "Cheese", 3.99),
                new Product(2, "Cookies", 5.99),
                new Product(3, "Pasta", 2.99),
                new Product(4, "Ham", 9.99)};

        for (Product product : exampleProducts) {
            String sql = "INSERT INTO PRODUCTS VALUES(" + product.getId() + ", '" + product.getName() + "', " + product.getPrice() + ")";
            try {
                statement.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param idProduct product ID searched product
     * @return true if product is found in product database, false otherwise
     */
    public boolean isInStock(int idProduct) {
        String sql = "SELECT * FROM PRODUCTS WHERE ID=?";
        boolean inStock = false;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProduct);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                inStock = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inStock;
    }

    /**
     *
     * @param idProduct product ID searched product
     * @return Product object found in products database
     */
    public Product getProductFromDatabase(int idProduct) {
        String sql = "SELECT * FROM PRODUCTS WHERE ID=?";
        Product product = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProduct);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = new Product(idProduct, resultSet.getString("NAME"), resultSet.getDouble("PRICE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}

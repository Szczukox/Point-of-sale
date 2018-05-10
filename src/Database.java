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

    private void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/point_of_sale", "root", "");
            System.out.println("Successful connection");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Nie udało się połączyć z bazą danych", ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createTable() {
        String sql = "CREATE OR REPLACE TABLE SHOP (" +
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

    private void addExampleProducts() {
        String[] productsNames = {"Water", "Cheese", "Cookies", "Pasta", "Ham"};
        double[] productsPrices = {1.59, 3.99, 5.99, 2.99, 9.99};

        for (int id = 0; id < productsNames.length; id++) {
            String sql = "INSERT INTO SHOP VALUES(" + id + ", '" + productsNames[id] + "', " + productsPrices[id] + ")";
            try {
                statement.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

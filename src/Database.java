import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private Connection connection;

    public Database() {
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
}

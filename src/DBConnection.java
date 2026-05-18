import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MariaDB/MySQL
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_system",
                    "javauser",
                    "1234");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found!");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();

        } catch (Exception e) {
            System.out.println("UNKNOWN ERROR");
            e.printStackTrace();
        }

        return null;
    }
}
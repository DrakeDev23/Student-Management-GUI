import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_system",
                    "root",
                    "");

            System.out.println("Database Connected");

        } catch (Exception e) {
            System.out.println(e);
        }

        return conn;
    }
}
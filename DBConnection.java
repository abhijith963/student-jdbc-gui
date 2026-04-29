import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/studentdb",
                "root",
                "9669"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

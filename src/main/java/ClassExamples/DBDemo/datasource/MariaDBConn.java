package ClassExamples.DBDemo.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBConn {
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3306/company", "companyuser", "password");
            } catch (SQLException e) {
                System.out.println("Connection failed.");
                System.out.println(e.getMessage());
            }
        }

        return conn;

    }
}

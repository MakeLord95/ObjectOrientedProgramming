package Module_7_2.datasource;

import java.sql.Connection;
import java.sql.DriverManager;

public class MariaDBConnection {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/currency", "appuser", "appuser");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return conn;

    }
}

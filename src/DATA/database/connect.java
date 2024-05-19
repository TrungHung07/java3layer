package DATA.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class connect {
    public Connection getConnection() {
        Connection c = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/qlch";
            String username = "root";
            String pass = null;
            c = DriverManager.getConnection(url, username, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public void closeConnection(Connection c) {
        try {
            if (c != null)
                c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

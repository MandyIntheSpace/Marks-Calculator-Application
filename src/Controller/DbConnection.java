package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ImageSetUp {
    public static final String username = "root";
    public static  final String password = "";
    public static final String url = "jdbc:mysql://localhost:3306/marks_calculator_application";

    public static final String driverClass = "com.mysql.jdbc.Driver";

    public static String getUsername() {
        return username;
    }
    public static String getPassword() {
        return password;
    }
    public static String getUrl() {
        return  url;
    }
    public static String getDriverClass() {
        return driverClass;
    }
}

public class DbConnection {
     public DbConnection() {
         Connection conn =  null;
         try {
             ImageSetUp imageSetUp = new ImageSetUp();
             Class.forName(imageSetUp.getDriverClass());
             System.out.println("Connecting to a database....");
             conn = DriverManager.getConnection(imageSetUp.getUrl() , imageSetUp.getUsername(), imageSetUp.getPassword());
             if (conn !=  null) {
                 System.out.println("The database is successfullt created");
             }
         } catch (ClassNotFoundException e) {
             throw new RuntimeException(e);
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     }
     public static void main(String[] args) {
         DbConnection dbConnection = new DbConnection();
     }

}

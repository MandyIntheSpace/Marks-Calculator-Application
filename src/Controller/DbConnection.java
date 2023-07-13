package Controller;

import java.sql.*;
import java.util.ArrayList;

import Model.Student;
import com.mysql.cj.protocol.Resultset;

class ImageSetUp {
    public static final String username = "root";
    public static  final String password = "";
    public static final String url = "jdbc:mysql://localhost:3306/marks_calculator_application";

    public static final String driverClass = "com.mysql.cj.jdbc.Driver";

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
    Connection conn =  null;
     public DbConnection() {
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

     public String addStudentDetails(Student student) {
         PreparedStatement statement = null;
         String message = "";
         try{
             String query = "Insert into student(name,roll_number,address,phone_number, first_subject, second_subject, third_subject, fourth_subject, " +
                     "fifth_subject, first_marks, second_marks, third_marks, fourth_marks, fifth_marks, averageMarks) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
             statement = conn.prepareStatement(query);
             statement.setString(1, student.getName());
             statement.setInt(2, student.getRollNumber());
             statement.setString(3, student.getAddress());
             statement.setString(4, student.getPhoneNumber());
             statement.setString(5, student.getfSubName());
             statement.setString(6, student.getsSubName());
             statement.setString(7, student.gettSubName());
             statement.setString(8, student.getFoSubName());
             statement.setString(9, student.getFifSubName());
             statement.setFloat(10, student.getfSubMarks());
             statement.setFloat(11, student.getsSubMarks());
             statement.setFloat(12, student.gettSubMarks());
             statement.setFloat(13, student.getFoSubMarks());
             statement.setFloat(14, student.getFifSubMarks());
             statement.setFloat(15, student.getAverageMarks());
             int rows = statement.executeUpdate();
             if (rows > 1) {
                 message = "recorded successfully added";
             }
             else {
                 message = "Something is missing and is wrong";
             }
             conn.close();
         }catch (NumberFormatException e) {
             e.printStackTrace();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         return message;
     }

     public ResultSet orderByAverageMarks() {
         PreparedStatement statement = null;
         ResultSet rs = null;

         try{
             String query = "Select name, averageMarks from student order by averageMarks";
             statement = conn.prepareStatement(query);
             rs = statement.executeQuery();

             System.out.println("Name\t\tAverage Marks");

             System.out.print(rs.next());

             while (rs.next()) {
                 String name = rs.getString("name");
                 float averageMarks = rs.getFloat("averageMarks");
                 System.out.println(name + "\t\t" + averageMarks);
             }
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         return rs;
     }



     public ResultSet fetchAndDisplayData() {
         PreparedStatement statement = null;
         ResultSet rs = null;

         int id = 0;
         try {
             String query = "Select * from student";
             statement = conn.prepareStatement(query);
             rs = statement.executeQuery();


             System.out.println("id\t\tname\t\tRoll Number\t\tAddress\t\tPhone Number");

             while (rs.next()) {
                 id = rs.getInt("id");
                 String name = rs.getString("name");
                 int rollNumber = rs.getInt("roll_number");
                 String address = rs.getString("address");
                 int phoneNumber = rs.getInt("phone_number");
                 System.out.println(id + "\t\t" + name + "\t\t" + rollNumber + "\t\t" + address + "\t\t" + phoneNumber);

             }

         } catch (NumberFormatException e) {
             e.printStackTrace();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         return rs;
     }

//     public ResultSet askId() {
//         PreparedStatement statement = null;
//         int id = 0;
//         ResultSet rs = null;
//         try{
//             String query = "Select * from student where student id = ?";
//             statement.setString(1, id);
//             statement = conn.prepareStatement(query);
//             rs = statement.executeQuery();
//             if (rs != null) {
//                 System.out.println("It is not null");
//             }
//         }
//         catch (SQLException e) {
//             throw new RuntimeException(e);
//         }
//         return rs;
//     }

//    public String addResult(Student student) {
//         PreparedStatement statement = null;
//         String message = "";
//         try{
//             String query = "Insert into subject_marks (first_subject, second_subject, third_subject, fourth_subject," +
//                     "fifth_subject, first_marks, second_marks, third_marks, fourth_marks, fifth_marks) values (?,?,?,?,?,?,?,?,?,?)";
//             statement = conn.prepareStatement(query);
//             statement.setString(1, student.getfSubName());
//             statement.setString(2, student.getsSubName());
//             statement.setString(3, student.gettSubName());
//             statement.setString(4, student.getFoSubName());
//             statement.setString(5, student.getFifSubName());
//             statement.setFloat(6, student.getfSubMarks());
//             statement.setFloat(7, student.getsSubMarks());
//             statement.setFloat(8, student.gettSubMarks());
//             statement.setFloat(9, student.getFoSubMarks());
//             statement.setFloat(10, student.getFifSubMarks());
//             int rows = statement.executeUpdate();
//             if (rows > 1) {
//                 System.out.println("The subject marks is successfullt recorded");
//             }
//             else {
//                 System.out.println("There is something missing");
//             }
//
//         } catch (SQLException e) {
//             throw new RuntimeException(e);
//         }
//        return message;
//    }


     public static void main(String[] args) {
         DbConnection dbConnection = new DbConnection();
         dbConnection.orderByAverageMarks();
     }

}

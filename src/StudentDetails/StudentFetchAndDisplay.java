package StudentDetails;
import Controller.DbConnection;
import StudentDetails.StudentDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentFetchAndDisplay {
    public void showprocess() {
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.StudentRecord();
        studentDetails.displayAscendingStudentResult();
    }

    public static void main(String[] args) {
        StudentFetchAndDisplay studentFetchAndDisplay = new StudentFetchAndDisplay();
        studentFetchAndDisplay.showprocess();
    }
}

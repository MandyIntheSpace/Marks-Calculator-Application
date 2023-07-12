package StudentDetails;

import Model.Student;

import java.util.Scanner;

public class StudentDetails {

    public void StudentRecord() {
        int num = 0;
     try {
         Scanner scanner = new Scanner(System.in);

         System.out.println("Enter Student Name: \n");
         String name = scanner.nextLine();

         System.out.println("Enter Student roll number: \n");
         int rollNumber = scanner.nextInt();
         scanner.nextLine();

         System.out.println("Enter Student address: \n");
         String address = scanner.nextLine();

         System.out.println("Enter Student phone number: \n");
         String phoneNumber = scanner.nextLine();

         try{
             num = Integer.parseInt(phoneNumber);
         }catch(NumberFormatException e) {
             e.printStackTrace();
             System.out.println("The message is "+ e.getMessage());
         }

         Student student = new Student();
         student.setName(name);
         student.setRoll_Number(rollNumber);
         student.setAddress(address);
         student.setPhoneNumber(phoneNumber);

         student.getName();
         student.getRollNumber();
         student.getAddress();
         student.getPhoneNumber();

         System.out.println("The information of student are recorded successfully");
     }catch (Exception e) {
         e.printStackTrace();
         System.out.println("The message is "+ e.getMessage());
     }

    }

    public static void main(String[] args) {
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.StudentRecord();
    }
}

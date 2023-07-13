package StudentDetails;

import Model.Student;

import java.util.Scanner;

import Controller.DbConnection;

public class StudentDetails {

    public void StudentRecord() {

     try {
         boolean isValidate = false;
         Student student = null;
         String answer = null;
         Student student1 = null;
         do {
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

             System.out.println("Enter the first subject name");
             String firstSubject = scanner.nextLine();
             System.out.println("Enter the first subject marks");
             float firstSubject1 = scanner.nextFloat();
             scanner.nextLine();

             System.out.println("Enter the second subject name");
             String secondSubject = scanner.nextLine();
             System.out.println("Enter the second subject marks");
             float secondSubject1 = scanner.nextFloat();
             scanner.nextLine();

             System.out.println("Enter the third subject name");
             String thirdSubject = scanner.nextLine();
             System.out.println("Enter the third subject marks");
             float thirdSubject1 = scanner.nextFloat();
             scanner.nextLine();

             System.out.println("Enter the fourth subject name");
             String fourthSubject = scanner.nextLine();
             System.out.println("Enter the fourth subject marks");
             float fourthSubject1 = scanner.nextFloat();
             scanner.nextLine();

             System.out.println("Enter the fifth subject name");
             String fifthSubject = scanner.nextLine();
             System.out.println("Enter the fifth subject marks");
             float fifthSubject1 = scanner.nextFloat();
             scanner.nextLine();

             int num = 0;
             try {
                 num = Integer.parseInt(phoneNumber);
             } catch (NumberFormatException e) {
                 e.printStackTrace();
                 System.out.println("The message is " + e.getMessage());
             }

             student = new Student();
             student.setName(name);
             student.setRoll_Number(rollNumber);
             student.setAddress(address);
             student.setPhoneNumber(phoneNumber);
             student.setfSubName(firstSubject);
             student.setsSubName(secondSubject);
             student.settSubName(thirdSubject);
             student.setFoSubName(fourthSubject);
             student.setFifSubName(fifthSubject);
             student.setfSubMarks(firstSubject1);
             student.setsSubMarks(secondSubject1);
             student.settSubMarks(thirdSubject1);
             student.setFoSubMarks(fourthSubject1);
             student.setFifSubMarks(fifthSubject1);


             student.getName();
             student.getRollNumber();
             student.getAddress();
             student.getPhoneNumber();
             student.getfSubName();
             student.getsSubName();
             student.gettSubName();
             student.getFoSubName();
             student.getFifSubName();
             student.getfSubMarks();
             student.getsSubMarks();
             student.gettSubMarks();
             student.getFoSubMarks();
             student.getFifSubMarks();

             System.out.println("Do you want to store the information of more student? Type yes for continuing and no for exiting the " +
                     "continuous process");
             answer = scanner.nextLine();

             if(answer.equalsIgnoreCase("yes")) {
                 isValidate = false;
             } else if (answer.equalsIgnoreCase("no")) {
                 isValidate = true;
                 System.out.println("Now calculating the average marks of the specific student");
                 String average = String.valueOf((student.getfSubMarks() + student.getsSubMarks() + student.gettSubMarks() + student.getFoSubMarks() + student.getFifSubMarks()) / 5);
                 System.out.println(average);
                 student.setAverageMarks(Float.parseFloat(average));
                 student.getAverageMarks();

                 DbConnection dbConnection = new DbConnection();
                 String storingMessage = dbConnection.addStudentDetails(student);
                 System.out.println(storingMessage);
             } else {
                 System.out.println("Invalid Input please re enter the process");
             }

         } while (!isValidate);

         System.out.println("The information of student are recorded successfully");


     }catch (Exception e) {
         e.printStackTrace();
         System.out.println("The message is "+ e.getMessage());
     }

    }

    public void displayAscendingStudentResult() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to see the information of the student? (Yes/No");
        String studentOrderDisplayQuestion = scanner.nextLine();
        if (studentOrderDisplayQuestion.equalsIgnoreCase("yes")) {
            DbConnection dbConnection = new DbConnection();
            dbConnection.orderByAverageMarks();
        }
        else{
            System.out.println("Thank you!!!! You are out of the program");
        }
    }

}


package giabao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import java.text.ParseException;

public class Processor {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Scanner key = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Find Student by ID");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Find Top Student");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            int choice = key.nextInt();
            key.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter ID: ");
                        String id = key.nextLine();

                        System.out.print("Enter Full Name: ");
                        String fullName = key.nextLine();

                        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
                        String dobString = key.nextLine();
                        Date dob = sdf.parse(dobString);

                        System.out.print("Enter GPA: ");
                        float gpa = key.nextFloat();

                        key.nextLine();
                        System.out.print("Enter Major: ");
                        String major = key.nextLine();

                        Student student = new Student(id, fullName, dob, gpa, major);
                        studentList.addStudent(student);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format.");
                    }
                    break;

                case 2:
                    studentList.displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to find: ");
                    String idToFind = key.nextLine();
                    Student fStudent = studentList.findStudentByID(idToFind);
                    if (fStudent != null) {
                        fStudent.displayInfo();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    String delete = key.nextLine();
                    studentList.deleteStudentById(delete);
                    System.out.println("Deleted student with ID: " + delete);
                    break;

                case 5:
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Top student:");
topStudent.displayInfo();
                    } else {
                        System.out.println("No students available.");
                    }
                    break;

                case 6:
                    System.out.println("Exit");
                    key.close();
                    return;

                default:
                    System.out.println("Choose error. Try again.");
                    break;
            }
        }
    }
}

package com.studentapp.main;

import com.studentapp.dao.StudentDAOImpl;
import com.studentapp.model.Student;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAOImpl dao = new StudentDAOImpl();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Course: ");
                    String course = sc.next();
                    dao.addStudent(new Student(id, name, course));
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    Student s = dao.getStudent(sc.nextInt());
                    if (s != null)
                        System.out.println(s.getStudentId()+" "+s.getName()+" "+s.getCourse());
                    else
                        System.out.println("Not Found!");
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    System.out.print("New Name: ");
                    String n = sc.next();
                    System.out.print("New Course: ");
                    String c = sc.next();
                    dao.updateStudent(new Student(uid, n, c));
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    dao.deleteStudent(sc.nextInt());
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}

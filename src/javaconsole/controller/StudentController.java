/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javaconsole.enity.Student;
import javaconsole.model.StudentModel;

/**
 *
 * @author nguyenhung
 */
public class StudentController {

    ArrayList<Student> listStudent;
    Student student = new Student();
    private static StudentModel studentModel = new StudentModel();

    public void getList() {
        listStudent = studentModel.getListStudent();
        if (listStudent.isEmpty() == true) {
            System.out.println("Danh sách trống");
        } else {
            System.out.println("========== Danh sách sinh viên ==========");
            listStudent.forEach(stu -> {
                System.out.println("ID :" + stu.getId());
                System.out.println("Name :" + stu.getName());
                System.out.println("Email :" + stu.getEmail());
                System.out.println("Rollnumber :" + stu.getRollnumber());
                System.out.println("Classname :" + stu.getClassname());
                System.out.println("Status :" + stu.getStatus());
            });
        }
    }

    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào thông tin sinh viên");
        System.out.println("Nhập vào name :");
        String name = sc.nextLine();
        System.out.println("Nhập vào email :");
        String email = sc.nextLine();
        System.out.println("Nhập vào rollnumber :");
        String rollnumber = sc.nextLine();
        System.out.println("Nhập vào classname :");
        String classname = sc.nextLine();
        System.out.println("Nhập vào status :");
        int status = sc.nextInt();
        System.out.println("Name :" + name + "\nEmail :" + email + "\nRollnumber :" + rollnumber + "\nclassname :" + classname + "\nstatus" + status);

        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setRollnumber(rollnumber);
        student.setClassname(classname);
        student.setStatus(status);

        StudentModel studentModel = new StudentModel();
        studentModel.insert(student);
    }

    public void updateStudent() {

        System.out.println("Nhập ID sinh viên cần sửa :");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();

        Student previousStudent = studentModel.getById(id);
        if (previousStudent == null) {
            System.out.println("Sinh viên không tồn tại");
        } else {
            System.out.println("Nhập Tên mới: ");
            String name = sc.nextLine();
            if (name == null) {
                name = previousStudent.getName();
            }
            System.out.println("Nhập Email mới: ");
            String email = sc.nextLine();
            if (email == null) {
                email = previousStudent.getEmail();
            }

            System.out.println("Nhập Rollnumber mới: ");
            String rollNumber = sc.nextLine();
            if (rollNumber == null) {
                rollNumber = previousStudent.getRollnumber();
            }
            System.out.println("Nhập Classname mới: ");
            String className = sc.nextLine();
            if (className == null) {
                className = previousStudent.getClassname();
            }
            System.out.println("Nhập Status mới: ");
            int status = sc.nextInt();

            Student newStudent = new Student(id, name, email, className, rollNumber, status);
            studentModel.update(id, newStudent);
            System.out.println(newStudent.getName());

        }
    }

    public void deleteStudent() {
        System.out.println("Nhập ID sinh viên cần xoá :");
        Scanner sc = new Scanner(System.in);
        int searchId = sc.nextInt();

        Student student = studentModel.getById(searchId);
        if (student != null) {
            System.out.println("Tìm thấy sinh viên \n " + student.getId() + " " + student.getName() + " " + student.getEmail() + " " + student.getRollnumber() + " " + student.getClassname() + " " + student.getStatus());
            studentModel.deleteId(searchId);
        } else {
            System.err.println("Sinh viên không tồn tại");
        }
    }

    public static void main(String[] args) {
//        StudentModel studentModel = new StudentModel();
//        ArrayList<Student> listStudent = studentModel.getListStudent();
//        Student student1 = new Student(10, "hung", "hung@gmail.com", "11", "2000", 6);
//        Student student2 = new Student(11, "abhung", "abhung@gmail.com", "12", "3000", 7);
//        Student student3 = new Student(12, "cdhung", "cdhung@gmail.com", "13", "4000", 8);
//        ArrayList<Student> listStudents = new ArrayList<>();
//        listStudent.add(student1);
//        listStudent.add(student2);
//        listStudent.add(student3);
    }
}

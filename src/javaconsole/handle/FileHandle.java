/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.handle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaconsole.enity.Student;
import javaconsole.model.StudentModel;

/**
 *
 * @author nguyenhung
 */
public class FileHandle {

//        StudentModel studentModel = new StudentModel();
//        ArrayList<Student> listStudent = studentModel.getListStudent();
//        Student student1 = new Student(10, "hung", "hung@gmail.com", "11", "2000", 6);
//        Student student2 = new Student(11, "abhung", "abhung@gmail.com", "12", "3000", 7);
//        Student student3 = new Student(12, "cdhung", "cdhung@gmail.com", "13", "4000", 8);
//        ArrayList<Student> listStudents = new ArrayList<>();
//        listStudent.add(student1);
//        listStudent.add(student2);
//        listStudent.add(student3);
    public void exportFile() {
        StudentModel studentModel = new StudentModel();
        ArrayList<Student> listStudent = studentModel.getListStudent();
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("muahahahahahahha.txt");
            bw = new BufferedWriter(fw);
            for (Student student6 : listStudent) {
                bw.write("ID: " + student6.getId());
                bw.newLine();
                bw.write("Name: " + student6.getName());
                bw.newLine();
                bw.write("Email: " + student6.getEmail());
                bw.newLine();
                bw.write("Rollnumber: " + student6.getRollnumber());
                bw.newLine();
                bw.write("Classname: " + student6.getClassname());
                bw.newLine();
                bw.write("Status: " + student6.getStatus());
                bw.newLine();
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

//        
    public void importFile() {
        StudentModel studentModel = new StudentModel();
        ArrayList<Student> listStudent = studentModel.getListStudent();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            String str = null;
            fr = new FileReader("muahahahahahahha.txt");
            br = new BufferedReader(fr);
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);

        } catch (IOException ex) {
            Logger.getLogger(FileHandle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import javaconsole.enity.Student;
import javaconsole.handle.FileHandle;

/**
 *
 * @author nguyenhung
 */
public class MenuConsole {

    public static void main(String[] args) {
        MenuConsole menu = new MenuConsole();
        menu.createMenu();

    }

    public void createMenu() {
        while (true) {
            System.out.println("========== Danh sách sinh viên ===========");
            System.out.println("1. Lấy ra danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Sửa thông tin sinh viên");
            System.out.println("4. Xoá sinh viên");
            System.out.println("5. Export File");
            System.out.println("6. Import File");
            System.out.println("7. Exit");
            System.out.println("================== Exit ==================");
            System.out.println("Chọn :");

            
            int choice = 0;
            Scanner sc = new Scanner(System.in);
            String strChoice = sc.nextLine();

            try {
                choice = Integer.parseInt(strChoice);
            } catch (java.lang.NumberFormatException e) {
                System.err.println("Hãy nhập vào 1 số");
                continue;
            } finally {
                System.out.println("");
            }
            StudentController studentController = new StudentController();
            FileHandle fileHandle = new FileHandle();
            if (choice == 8) {

            } else {
                switch (choice) {
                    case 1:
                        studentController.getList();
                        break;
                    case 2:
                        studentController.addStudent();
                        break;
                    case 3:
                        studentController.updateStudent();
                        break;
                    case 4:
                        studentController.deleteStudent();
                        break;
                    case 5:
                        fileHandle.exportFile();
                        break;
                    case 6:
                        fileHandle.importFile();
                        break;
                    case 7:
                        System.exit(0);
                    
                }
            }
        }
    }
}

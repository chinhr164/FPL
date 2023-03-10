package com.fpoly.lab6.bai3;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        int index = 1;
        System.out.println("+++ QUẢN LÝ SINH VIÊN +++");
        while (true) {
            while (true) {
                System.out.println("Nhập thông tin sinh viên thứ " + index);
                System.out.print("\tNhập tên: \n\t\t");
                String name = sc.nextLine();
                System.out.print("\tNhập email <___@___.___>: \n\t\t");
                String email = sc.nextLine();
                System.out.print("\tNhập số điện thoại <0 + 9 số>: \n\t\t");
                String tel = sc.nextLine();
                System.out.print("\tNhập CCCD <12 số>: \n\t\t");
                String CIC = sc.nextLine();
                if (!(email.matches("^\\w+@[A-Za-z0-9]+[.A-Za-z0-9]+")) || !(tel.matches(
                        "0+(\\d){9}"))
                        || !(CIC.matches("\\d{12}"))) {
                    if (!(email.matches("^\\w+@[A-Za-z0-9]+[.A-Za-z0-9]+"))) {
                        System.out.print("\nNhập lại email");
                    }

                    if (!(tel.matches("0+(\\d){9}"))) {
                        System.out.print("\nNhập lại số điện thoại");
                    }

                    if (!(CIC.matches("\\d{12}"))) {
                        System.out.print("\nNhập lại CCCD");
                    }
                    System.out.println("\n____");
                } else {
                    studentList.add(new Student(name, email, tel, CIC));
                    index++;
                    break;
                }
            }
            System.out.print("Nhập thêm (Y/N)? - ");
            if (sc.nextLine().equalsIgnoreCase("N")) {
                break;
            }
        }
        int index1 = 1;
        System.out.println("\n+++ DANH SÁCH SINH VIÊN +++\n");
        System.out.printf("%-5s %-20s %-30s %-15s %-15s\n", "STT", "Họ tên", "Email",
                "Số điện thoại", "Số CCCD");
        for (Student student : studentList) {
            System.out.printf("%-5d %-20s %-30s %-15s %-15s\n", index1, student.getName(),
                    student.getEmail(), student.getTel(), student.getCIC());
        }
    }
}

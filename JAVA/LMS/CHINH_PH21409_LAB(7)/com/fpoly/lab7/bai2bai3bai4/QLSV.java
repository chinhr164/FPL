package com.fpoly.lab7.bai2bai3bai4;

import java.util.ArrayList;
import java.util.Scanner;

public class QLSV {

    Scanner sc = new Scanner(System.in);
    ArrayList<SinhVienPoly> svList = new ArrayList<>();
    int index = 1;

    public void menu() {
        System.out.println("\n++-------------- MENU -------------++");
        System.out.println("\t1. Nhập danh sách sinh viên");
        System.out.println("\t2. Xuất thông tin danh sách sinh viên");
        System.out.println("\t3. Xuất danh sách sinh viên có học lực giỏi");
        System.out.println("\t4. Sắp xếp danh sách sinh viên theo điểm");
        System.out.println("\t5. Kết thúc");
        System.out.println("++---------------------------------++\n");
    }

    public void input() {
        System.out.println(" 1. Nhập danh sách sinh viên\n");
        while (true) {
            System.out.println("Nhập thông tin sinh viên thứ " + index++);
            System.out.println("1. Sinh viên IT");
            System.out.println("2. Sinh viên Biz");
            System.out.print("~Chọn ngành: ");
            int cn = new Scanner(System.in).nextInt();
            switch (cn) {
                case 1:
                    SinhVienIT svIT = new SinhVienIT();
                    svIT.nhap();
                    svList.add(svIT);
                    break;

                case 2:
                    SinhVienBiz svBiz = new SinhVienBiz();
                    svBiz.nhap();
                    svList.add(svBiz);
                    break;

                default: System.out.println("Chọn sai ngành...");
            }
            System.out.print("\nNhập thêm (Y/N)? - ");
            if (sc.nextLine().equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public void output() {
        int ord = 1;
        System.out.println("\n\t+++ DANH SÁCH SINH VIÊN +++\n");
        System.out.printf("%-5s %-20s %-15s %-10s %-15s\n", "STT", "Họ tên", "Ngành", "Điểm",
                "Học lực");
        for (SinhVienPoly sv : svList) {
            System.out.printf("%-5d ", ord++);
            sv.xuat();
        }
        System.out.println("----------------------------------------\n");
    }

    public void stuGood() {
        System.out.println(" 3. Xuất danh sách sinh viên có học lực giỏi\n");
        int ord = 1;
        System.out.println("\n\t+++ DANH SÁCH SINH VIÊN +++\n");
        System.out.printf("%-5s %-20s %-15s %-10s %-15s\n", "STT", "Họ tên", "Ngành", "Điểm",
                "Học lực");
        for (SinhVienPoly sv : svList) {
            if (sv.getHocLuc().equals("Giỏi")) {
                System.out.printf("%-5d ", ord++);
                sv.xuat();
            }
        }
        System.out.println("----------------------------------------\n");
    }


    public void soft() {
        System.out.println(" 4. Sắp xếp danh sách sinh viên theo điểm\n");
        System.out.println("Chọn kiểu sắp xếp:");
        System.out.println("1. Tăng dần");
        System.out.println("2. Giảm dần");
        System.out.print("<> Mời chọn: ");
        if (sc.nextLine().equals("1")) {
            svList.sort((s1, s2) -> (int) (s1.getDiem() - s2.getDiem()));
        } else {
            svList.sort((s1, s2) -> (int) (s2.getDiem() - s1.getDiem()));
        }
        output();
    }
}

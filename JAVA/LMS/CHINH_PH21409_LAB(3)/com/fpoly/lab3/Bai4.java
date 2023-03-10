package com.fpoly.lab3;

import java.util.Scanner;

public class Bai4 {
    static Scanner sc = new Scanner(System.in);

    static int n;

    public void nhap(String[] name, double[] mark) {
        for (int i = 0; i < n; i++) {
            System.out.println("- Sinh viên thứ " + (i + 1));
            System.out.print("\t+ Nhập tên: ");
            name[i] = sc.nextLine();
            System.out.print("\t+ Nhập điểm: ");
            mark[i] = Double.parseDouble(sc.nextLine());
        }
    }

    public void xuat(String[] name, double[] mark) {
        System.out.println("\n\t+---- DANH SÁCH SINH VIÊN ----+");
        System.out.printf("\n%-5s %-20s %-10s %-15s\n", "STT", "Họ tên", "Điểm", "Học lực");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-5d %-20s %-10.2f %-15s\n", i + 1, name[i], mark[i], hocLuc(mark[i]));
        }
    }

    public String hocLuc(double mark) {
        if (mark >= 9) {
            return "Xuất sắc";
        } else if (mark >= 7.5) {
            return "Giỏi";
        } else if (mark >= 6.5) {
            return "Khá";
        } else if (mark >= 5) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }

    public void sapXep(String[] name, double[] mark){
        System.out.println("\n\n+ v v v v v v v v +");
        System.out.println("|     SẮP XẾP     |");
        System.out.println("+ v v v v v v v v +");
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (mark[i] > mark[j]) {
                    String namet = name[i];
                    name[i] = name[j];
                    name[j] = namet;

                    double markt = mark[i];
                    mark[i] = mark[j];
                    mark[j] = markt;
                }
            }
        }
        xuat(name, mark);
        System.out.println("\n__________");
    }

    public static void main(String[] args) {
        System.out.println("\n+++ QUẢN LÝ SINH VIÊN +++");
        System.out.print("Nhập số lượng sinh viên: ");
        n = Integer.parseInt(sc.nextLine());

        String[] name = new String[n];
        double[] mark = new double[n];

        Bai4 code = new Bai4();
        while (true) {
            System.out.print("\n+------------- MENU -------------+\n");
            System.out.print("\t1. Nhập thông tin sinh viên.\n");
            System.out.print("\t2. Hiển thị danh sách sinh viên.\n");
            System.out.print("\t3. Sắp xếp danh sách tăng dần theo điểm.\n");
            System.out.print("\t0. Thoát chương trình.\n");
            System.out.print("+--------------------------------+\n");
            System.out.print("Chọn chức năng: ");
            int cn = Integer.parseInt(sc.nextLine());
            switch (cn) {
                case 1:
                    code.nhap(name, mark);
                    break;

                case 2:
                    code.xuat(name, mark);
                    break;

                case 3:
                    code.sapXep(name, mark);
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.print("\n>>Chức năng được chọn nằm ngoài phạm vi.\n");
            }
        }



    }
}






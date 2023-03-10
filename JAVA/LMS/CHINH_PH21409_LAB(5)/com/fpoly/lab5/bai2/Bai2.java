package com.fpoly.lab5.bai2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bai2 {

    Scanner sc = new Scanner(System.in);
    static ArrayList<String> name = new ArrayList<>();
    int index = 1;

    public void input() {
        while (true) {
            System.out.printf("Nhập thành viên thứ %d: ", index++);
            String i = sc.nextLine();
            name.add(i);

            System.out.print("Nhập thêm (Y/N)? - ");
            if (sc.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        }
        System.out.println("\n__________");
    }

    public void output() {
        int index = 1;
        System.out.print("\n+---------- PROJECT GANG ----------+\n");
        System.out.printf("%-5s %-20s\n", "STT", "Họ tên");
        for (String i : name) {
            System.out.printf("%-5d %-20s\n", index, i);
            index++;
        }
        System.out.println("\n__________");
    }

    public void soft() {
        System.out.println("Chọn kiểu sắp xếp");
        System.out.println("1. Tăng dần");
        System.out.println("2. Giảm dần");
        System.out.print("Mời chọn: ");
        if (sc.nextLine().equals("2")) {
            name.sort((o1, o2) -> o2.compareTo(o1));
            System.out.print("\nSắp xếp danh sách theo thứ tự giảm dần.\n>\n>");
        } else {
            name.sort((o1, o2) -> o1.compareTo(o2));
            System.out.print("\nSắp xếp danh sách theo thứ tự tăng dần.\n<\n<");
        }
        output();
    }

    public void random() {
        Collections.shuffle(name);
        output();
    }

    public void delete() {
        System.out.print("Nhập thông tin muốn xoá: ");
        String del = sc.nextLine();
        int i;
        for (i = 0; i < name.size(); i++) {
            if (name.get(i).equals(del)) {
                name.remove(del);
                break;
            }
        }
        if (i == name.size()) {
            System.out.println("Thông tin bạn nhập không tồn tại trong danh sách.");
            System.out.println("__________");
        } else {
            output();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\n+------------- MENU -------------+\n");
            System.out.print("\t1. Nhập danh sách.\n");
            System.out.print("\t2. Xuất danh sách.\n");
            System.out.print("\t3. Xuất danh sách ngẫu nhiên.\n");
            System.out.print("\t4. Sắp xếp danh sách.\n");
            System.out.print("\t5. Xoá danh sách.\n");
            System.out.print("\t0. Thoát chương trình.\n");
            System.out.print("+--------------------------------+\n");
            System.out.print("Chọn chức năng: ");
            int cn = sc.nextInt();
            Bai2 code = new Bai2();
            switch (cn) {
                case 1: code.input();
                case 2: code.output();
                case 3: code.random();
                case 4: code.soft();
                case 5: code.delete();
                case 0: System.exit(0);
                default: System.out.print("\n>>Chức năng được chọn nằm ngoài phạm vi.\n");
            }
        }
    }
}

package com.fpoly.assignment;

import com.fpoly.custom.*;

import java.util.ArrayList;
import java.util.Scanner;

public class QLNV {

    ArrayList<NhanVien> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public void input() {
        System.out.println("1. Nhập danh sách nhân viên."); System.out.println("<~> Nhập \"S\" sau \"Nhân viên thứ ...\" để dừng việc nhập.");
        int index = 1; while (true) {
            System.out.print("\n - Nhân viên thứ " + index++ + " "); if (sc.nextLine().equalsIgnoreCase("s")) {
                break;
            } System.out.print("\tPhòng ban: "); String department = sc.nextLine(); if (department.equalsIgnoreCase("hành chính")) {
                HanhChinh x = new HanhChinh(); x.nhap(); list.add(x);
            } else if (department.equalsIgnoreCase("tiếp thị")) {
                TiepThi x = new TiepThi(); x.nhap(); list.add(x);
            } else {
                TruongPhong x = new TruongPhong(); x.nhap(); list.add(x);
            }
        } System.out.println("\n++ ______________________________________________________________ ++\n");
    }

    public void output() {
        int index = 1; System.out.println("\n++ ------- DANH SÁCH NHÂN VIÊN ------- ++\n");
        System.out.printf("%-5s %-10s %-20s %-15s %-15s\n", "STT", "ID", "Họ tên", "Thu nhập", "Thuế"); for (NhanVien x : list) {
            System.out.printf("%-5d ", index++); x.xuat();
        } System.out.println("\n++ ______________________________________________________________ ++\n");
    }

    public void search() {
        System.out.println("3. Tìm và hiển thị nhân viên theo mã.");
        System.out.print("\n>!< Nhập mã nhân viên: "); String idS = sc.nextLine();
        for (NhanVien x : list) {
            if (x.manv.equalsIgnoreCase(idS)) {
                System.out.print("\n - Họ tên: " + x.hoTen);
                System.out.print("\n - Lương: " + XPoly.numFomart(x.getThuNhap()));
                System.out.print("\n - Thuế: " + XPoly.numFomart(x.getThue()));
                break;
            } if (list.indexOf(x) == list.size() - 1) {
                System.out.print("\n - Không tìm thấy mã nhân viên \"" + idS.toUpperCase() + "\" trong danh sách nhân viên.");
            }
        } System.out.println("\n++ ______________________________________________________________ ++\n");
    }

    public void delete() {
        System.out.println("4. Xóa nhân viên theo mã.");
        System.out.print("\n>!< Nhập mã nhân viên: "); String idD = sc.nextLine();
        for (NhanVien x : list) {
            if (x.manv.equalsIgnoreCase(idD)) {
                list.remove(x);
                System.out.print("\n - Đã xoá nhân viên có mã \"" + idD + "\"\n"); output(); break;
            } if (list.indexOf(x) == list.size() - 1) {
                System.out.print("\n - Không tìm thấy mã nhân viên \"" + idD.toUpperCase() + "\" trong danh sách nhân viên.");
                System.out.println("\n++ ______________________________________________________________ ++\n");
            }
        }
    }

    public void update() {
        System.out.println("5. Cập nhật thông tin nhân viên theo mã.");
        System.out.print("\n>!< Nhập mã nhân viên: ");
        String idU = sc.nextLine();
        for (NhanVien x : list) {
            if (x.manv.equalsIgnoreCase(idU)) {
                System.out.println("\n>~< Sửa thông tin nhân viên:"); x.nhap();
                System.out.print("\n - Đã chỉnh sửa thông tin nhân viên có mã \"" + idU + "\"\n"); output(); break;
            } if (list.indexOf(x) == list.size() - 1) {
                System.out.print("\n - Không tìm thấy mã nhân viên \"" + idU.toLowerCase() + "\" trong danh sách nhân viên.");
                System.out.println("\n++ ______________________________________________________________ ++\n");
            }
        }
    }

    public void searchRound() {
        System.out.println("6. Tìm các nhân viên theo khoảng lương.");
        System.out.print("\n>!< Nhập giá trị lương tối thiểu: ");
        double salaryMin = Double.parseDouble(sc.nextLine());
        System.out.print("\n>!< Nhập giá trị lương tối đa: ");
        double salaryMax = Double.parseDouble(sc.nextLine());
        boolean check = true;
        for (NhanVien x : list) {
            if (salaryMin <= x.getThuNhap() && x.getThuNhap() <= salaryMax) {
                check = false;
                break;
            }
        } if (!check) {
            int index = 1;
            System.out.println("\n++ ------- DANH SÁCH NHÂN VIÊN ------- ++\n");
            System.out.printf("%-5s %-10s %-20s %-15s %-15s\n", "STT", "ID", "Họ tên", "Thu nhập", "Thuế");
            for (NhanVien x : list) {
                if (salaryMin <= x.getThuNhap() && x.getThuNhap() <= salaryMax) {
                    System.out.printf("%-5d ", index++); x.xuat();
                }
            }
        } else {
            System.out.println("\n - Không có nhân viên được trả lương trong khoảng lương " + XPoly.numFomart(salaryMin) + " - " + XPoly.numFomart(salaryMax));
        } System.out.println("\n++ ______________________________________________________________ ++\n");
    }

    public void softByName() {
        System.out.println("7. Sắp xếp nhân viên theo họ và tên."); System.out.println(">~< Kiểu sắp xếp"); System.out.println("1. Tăng dần");
        System.out.println("2. Giảm dần"); System.out.print(">~< Chọn kiểu: "); if (sc.nextLine().equalsIgnoreCase("1")) {
            list.sort((nv1, nv2) -> (int) (nv1.hoTen.compareTo(nv2.hoTen)));
        } else {
            list.sort((nv1, nv2) -> (int) (nv2.hoTen.compareTo(nv1.hoTen)));
        } output();
    }

    public void softBySalary() {
        System.out.println("8. Sắp xếp nhân viên theo thu nhập."); System.out.println(">~< Kiểu sắp xếp"); System.out.println("1. Tăng dần");
        System.out.println("2. Giảm dần"); System.out.print(">~< Chọn kiểu: "); if (sc.nextLine().equalsIgnoreCase("1")) {
            list.sort((nv1, nv2) -> (int) (nv1.getThuNhap() - (nv2.getThuNhap())));
        } else {
            list.sort((nv1, nv2) -> (int) (nv2.getThuNhap() - (nv1.getThuNhap())));
        } output();
    }

    public void top5Salary() {
        System.out.println("9. Xuất 5 nhân viên có thu nhập cao nhất."); list.sort((nv1, nv2) -> (int) (nv2.getThuNhap() - (nv1.getThuNhap())));
        int index = 1; System.out.println("\n++ ------- DANH SÁCH NHÂN VIÊN ------- ++\n");
        System.out.printf("%-5s %-10s %-20s %-15s %-15s\n", "STT", "ID", "Họ tên", "Thu nhập", "Thuế"); int n = Math.min(list.size(), 5);
        for (int i = 0; i < n; i++) {
            System.out.printf("%-5d %-10s %-20s %-15s %-15s\n", index++, list.get(i).manv, list.get(i).hoTen, XPoly.numFomart(list.get(i).getThuNhap()), XPoly.numFomart(list.get(i).getThue()));
        } System.out.println("\n++ ______________________________________________________________ ++\n");
    }
}

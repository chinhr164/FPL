package com.fpoly.lab6;

import java.util.*;

public class QuanLySinhVien {

    ArrayList<SinhVien> list = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void input() {
        System.out.println("1. Nhập danh sách sinh viên.\n");
        System.out.print("<!> Số lượng sinh viên - ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("");
        for (int i = 0; i < n; i++) {
            SinhVien x = new SinhVien();
            x.nhap(i);
            list.add(x);
        }
        System.out.println(
                "\n++ ______________________________________________________________ ++\n");
    }

    public void output() {
        int i = 1;
        System.out.println("\n+++>> DANH SÁCH SINH VIÊN <<+++\n");
        System.out.printf("%-5s %-10s %-25s %-35s %-15s %-15s\n", "STT", "Mã SV", "Họ tên", "Email", "Số điện thoại",
                "CMND/CCCD");
        for (SinhVien x : list) {
            x.xuat(i);
        }
        System.out.println(
                "\n++ ______________________________________________________________ ++\n");
    }

    public void search() {
        System.out.println("3. Tìm và hiển thị sinh viên theo mã.");
        System.out.print("\n>!< Nhập mã sinh viên: ");
        String idS = sc.nextLine();
        for (SinhVien x : list) {
            if (x.getMaSV().equalsIgnoreCase(idS)) {
                System.out.print("\n - Mã sinh viên: " + x.getMaSV());
                System.out.print("\n - Họ tên: " + x.getHoTen());
                System.out.print("\n - Email: " + x.getEmail());
                System.out.print("\n - Số điện thoại: " + x.getSdt());
                System.out.print("\n - CMND: " + x.getCmnd());
                break;
            }
            if (list.indexOf(x) == list.size() - 1) {
                System.out.print("\n - Không tìm thấy sinh viên có mã \"" + idS.toUpperCase()
                        + "\" trong danh sách sinh viên.");
            }
        }
        System.out.println(
                "\n++ ______________________________________________________________ ++\n");
    }

    public void update() {
        System.out.println("4. Cập nhật thông tin sinh viên theo mã.");
        System.out.print("\n>!< Nhập mã sinh viên: ");
        String idU = sc.nextLine();
        for (SinhVien x : list) {
            if (x.getMaSV().equalsIgnoreCase(idU)) {
                System.out.println("\n>~< Sửa thông tin sinh viên:");
                x.nhap(0);
                System.out.print(
                        "\n - Đã chỉnh sửa thông tin sinh viên có mã \"" + idU + "\"\n");
                output();
                break;
            }
            if (list.indexOf(x) == list.size() - 1) {
                System.out.print("\n - Không tìm thấy sinh viên có mã \"" + idU.toLowerCase()
                        + "\" trong danh sách sinh viên.");
                System.out.println(
                        "\n++ ______________________________________________________________ ++\n");
            }
        }
    }

    public void delete() {
        System.out.println("5. Xóa sinh viên theo mã.");
        System.out.print("\n>!< Nhập mã sinh viên: ");
        String cmndD = sc.nextLine();
        for (SinhVien x : list) {
            if (x.getCmnd().equals(cmndD)) {
                list.remove(x);
                System.out.print("\n - Đã xoá sinh viên có mã \"" + cmndD + "\"\n");
                output();
                break;
            }
            if (list.indexOf(x) == list.size() - 1) {
                System.out.print("\n - Không tìm thấy sinh viên có mã\"" + cmndD
                        + "\" trong danh sách sinh viên.");
                System.out.println(
                        "\n++ ______________________________________________________________ ++\n");
            }
        }
    }

    public void softByName() {
        System.out.println("6. Sắp xếp sinh viên giảm dần theo họ và tên.");
        list.sort((nv1, nv2) -> (int) (nv2.getHoTen().compareTo(nv1.getHoTen())));
        output();
    }
}

package NhanVien;

import java.util.ArrayList;
import java.util.Scanner;

import custom.XPoly;

public class QLNV {
    ArrayList<NhanVien> list = new ArrayList<>();

    public void input() {
        System.out.println("1. Nhập danh sách nhân viên");
        int i = 1;
        while (true) {
            System.out.println(" - Nhân viên thứ " + (i++));
            NhanVien sv = new NhanVien();
            sv.nhap();
            list.add(sv);
            System.out.print("\n<?> Nhập thêm SV? (Y/N) - ");
            String check = new Scanner(System.in).nextLine();
            if (check.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public void output() {
        int i = 1;
        System.out.println("--+---+----+ DANH SÁCH NHÂN VIÊN +----+---+--\n");
        System.out.printf("%-5s %-10s %-25s %-15s\n", "STT", "Mã NV", "Họ tên", "Lương (nghìn)");
        for (NhanVien sv : list) {
            System.out.printf("%-5d ", i++);
            sv.xuat();
        }
    }

    public void search() {
        Scanner sc = new Scanner(System.in);

        System.out.println("3. Tìm các nhân viên theo khoảng lương.");
        System.out.print(">!< Nhập giá trị lương tối thiểu: ");
        double salaryMin = Double.parseDouble(sc.nextLine());
        System.out.print(">!< Nhập giá trị lương tối đa: ");
        double salaryMax = Double.parseDouble(sc.nextLine());
        String check = null;
        for (NhanVien x : list) {
            if (salaryMin <= x.getSalary() && x.getSalary() <= salaryMax) {
                check = "Có";
                break;
            }
        }
        if (check != null) {
            int index = 1;
            System.out.println("\n++ ------- DANH SÁCH NHÂN VIÊN ------- ++\n");
            System.out.printf("%-5s %-10s %-25s %-15s\n", "STT", "Mã NV", "Họ tên", "Lương (nghìn)");
            for (NhanVien x : list) {
                if (salaryMin <= x.getSalary() && x.getSalary() <= salaryMax) {
                    System.out.printf("%-5d ", index++);
                    x.xuat();
                }
            }
        } else {
            System.out.println(
                    "\n - Không có nhân viên được trả lương trong khoảng `" + XPoly.numFomart(
                            salaryMin)
                            + " - " + XPoly.numFomart(salaryMax));
        }
    }
}

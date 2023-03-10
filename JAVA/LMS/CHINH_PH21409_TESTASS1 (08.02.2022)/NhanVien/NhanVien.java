package NhanVien;

import custom.*;
import java.util.Scanner;

public class NhanVien {
    String id, name;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public NhanVien() {}

    public NhanVien(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    Scanner sc = new Scanner(System.in);

    public void nhap() {
        System.out.print("\t+ Mã NV: ");
        id = new Scanner(System.in).nextLine().toUpperCase();
        System.out.print("\t+ Họ tên: ");
        name = XPoly.toUpperFirstChar(new Scanner(System.in).nextLine());
        System.out.print("\t+ Lương: ");
        salary = sc.nextDouble();
    }

    public void xuat(){
        System.out.printf("%-10s %-25s %-15s\n",id,name,XPoly.numFomart(getSalary()));
    }
}

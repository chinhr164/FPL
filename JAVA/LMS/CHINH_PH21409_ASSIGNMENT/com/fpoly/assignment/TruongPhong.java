package com.fpoly.assignment;

import java.util.Scanner;

public class TruongPhong extends NhanVien {

    public double trachNhiem;

    public TruongPhong(){
    }

    public TruongPhong(String manv, String hoTen, double luong,
            double trachNhiem) {
        super(manv, hoTen, luong);
        this.trachNhiem = trachNhiem;
    }

    @Override
    public double getThuNhap() {
        return getLuong() + trachNhiem;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("\tLương trách nhiệm: ");
        trachNhiem = Double.parseDouble(sc.nextLine());

    }
}

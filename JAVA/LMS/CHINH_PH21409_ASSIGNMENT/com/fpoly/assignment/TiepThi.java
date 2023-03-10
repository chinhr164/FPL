package com.fpoly.assignment;

import java.util.Scanner;

public class TiepThi extends NhanVien {

    public double doanhSo, hoaHong, mucLuong;

    public TiepThi(){
    }

    public TiepThi(String manv, String hoTen, double luong, double doanhSo,
            double hoaHong) {
        super(manv, hoTen, luong);
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
    }

    @Override
    public double getThuNhap() {
        return ((getLuong()*mucLuong + doanhSo * hoaHong )/ 100);
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("\tMức lương: ");
        mucLuong = Double.parseDouble(sc.nextLine());
        System.out.print("\tDoanh số: ");
        doanhSo = Double.parseDouble(sc.nextLine());
        System.out.print("\tHoa hồng: ");
        hoaHong = Double.parseDouble(sc.nextLine());
    }
}

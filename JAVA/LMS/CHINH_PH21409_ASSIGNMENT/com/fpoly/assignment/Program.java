package com.fpoly.assignment;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cn;
        QLNV code = new QLNV();

        while (true) {
            System.out.println("\n+++  --------------  MENU  --------------  +++");
            System.out.println("\t1. Nhập danh sách sinh viên.");
            System.out.println("\t2. Xuất danh sách sinh viên.");
            System.out.println("\t3. Tìm và hiển thị sinh viên có điểm lớn hơn 7.5 điểm");
            System.out.println("\t4. Sắp xếp sinh viên giảm theo họ và tên.");
            System.out.println("\t0. Thoát.");
            System.out.println("+++  ------------------------------------  +++\n");
            System.out.print("<> Mời chọn: ");
            cn = Integer.parseInt(sc.nextLine());
            switch (cn) {
                case 1:
                    code.input(); break;
                case 2:
                    code.output(); break;
                case 3:
                    code.search(); break;
                case 4:
                    code.delete(); break;
                case 5:
                    code.update(); break;
                case 6:
                    code.searchRound(); break;
                case 7:
                    code.softByName(); break;
                case 8:
                    code.softBySalary(); break;
                case 9:
                    code.top5Salary(); break;
                case 0: System.exit(0);
                default: System.out.println("\n<!> Chức năng được chọn nằm ngoài phạm vi.");
            }
        }
    }
}

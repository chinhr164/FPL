package com.fpoly.lab7.bai2bai3bai4;

import java.util.Scanner;

public class Programs {
    public static void main(String[] args) {
        QLSV code = new QLSV();
        Scanner sc = new Scanner(System.in);
        int cn;

        while (true) {
            code.menu();
            System.out.print("<> Chọn chức năng: ");
            cn = Integer.parseInt(sc.nextLine());
            switch (cn) {
                case 1: {
                    code.input();
                    break;
                }
                case 2: {
                    code.output();
                    break;
                }
                case 3: {
                    code.stuGood();
                    break;
                }
                case 4: {
                    code.soft();
                    break;
                }
                case 5: System.exit(0);
                default: System.out.println("Chức năng nằm ngoài phạm vi");
            }
        }
    }
}

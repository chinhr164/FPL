package NhanVien;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QLNV code = new QLNV();
        while (true) {
            System.out.println("\n++_.-._.-._++ MENU ++_.-._.-._++");
            System.out.println("1. Nhập danh sách nhân viên");
            System.out.println("2. Xuất danh sách nhân viên đã nhập");
            System.out.println("3. Tìm nhân viên theo khoảng lương");
            System.out.println("4. Kết thúc");
            System.out.println("++_.-._.-._++_.-._++_.-._.-._++");
            System.out.print("Mời chọn: ");
            int cn = sc.nextInt();
            switch (cn) {
                case 1:
                    code.input();
                    break;

                case 2:
                    code.output();
                    break;

                case 3:
                    code.search();
                    break;

                case 4:
                    System.exit(0);
                    break;

                default: System.out.println("Chức năng được chọn nằm ngoài phạm vi.");
            }
        }
    }
}

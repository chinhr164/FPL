package com.poly.lab3.classes;

import com.poly.lab3.classes.Student;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapDemo {

    public static void main(String[] args) {
        Map<String, Student> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            Student sv = new Student();
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1));
            System.out.print("\t+ Tên SV: ");
            sv.setName(sc.nextLine());
            System.out.print("\t+ Chuyên ngành: ");
            sv.setMajor(sc.nextLine());
            System.out.print("\t+ Điểm: ");
            sv.setMark(Double.parseDouble(sc.nextLine()));
            map.put(sv.getName(), sv);
            System.out.println("");
        }

        Set<String> keys = map.keySet();
        for (String name : keys) {
            Student sv = map.get(name);
            System.out.println(">Họ và tên: " + sv.getName());
            System.out.println(">Học lực: " + sv.getGrade());
            System.out.println("");
        }
    }
}

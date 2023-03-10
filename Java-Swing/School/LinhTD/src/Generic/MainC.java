package Generic;

import java.math.BigDecimal;

public class MainC {

      public static void main(String[] args) {
//            G1<BigDecimal> g1 = new G1<>();
//            g1.setMark(BigDecimal.valueOf(9.6));
//            System.out.println(g1.getMark());
//
//            G2<Integer, String> g2 = new G2<>();
//            g2.setId("1");
//            g2.setName("Chỉnh");
//            g2.setMark(10);
//            System.out.println("id: "+g2.getId()+"\ttên: "+g2.getName()+"\tđiểm: "+g2.getMark());

//            G3<Double> g3 = new G3<>();
//            g3.setNumber(5.0);
//            System.out.println(g3.pow2());
            G3<Integer> a = new G3<>();
            a.setNumber(5);
            G3<Double> b = new G3<>();
            b.setNumber(5.0);
            System.out.println(a.com1(b));
      }
}

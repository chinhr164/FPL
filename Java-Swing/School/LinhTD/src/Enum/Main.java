package Enum;

public class Main {
     public enum Season{
          SPRING("1-3"), SUMMER("4-6"), FALL("7-9"), WINTER("10-12");
          String value;

          private Season(String value) {
               this.value = value;
          }
          
     }
             
     public static void main(String[] args) {
          Season s = Season.WINTER;
          for (Season ss : Season.values()) {
               System.out.println(ss+": "+ss.value);
          }
     }
}

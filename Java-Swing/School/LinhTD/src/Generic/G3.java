package Generic;

public class G3<T extends Number> {

      private T number;

      public G3() {
      }

      public G3(T number) {
            this.number = number;
      }

      public T getNumber() {
            return number;
      }

      public void setNumber(T number) {
            this.number = number;
      }

      public double pow2() {
            return Math.pow(number.doubleValue(), 2);
      }

      public boolean com1(G3<?> n) {
            if (number.doubleValue() == n.getNumber().doubleValue()) {
                  return true;
            } else {
                  return false;
            }
      }
}

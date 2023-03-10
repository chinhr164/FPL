package Generic;

public class G2<T, S> {

      private S id, name;
      private T mark;

      public G2() {
      }

      public G2(S id, S name, T mark) {
            this.id = id;
            this.name = name;
            this.mark = mark;
      }

      public S getId() {
            return id;
      }

      public void setId(S id) {
            this.id = id;
      }

      public S getName() {
            return name;
      }

      public void setName(S name) {
            this.name = name;
      }

      public T getMark() {
            return mark;
      }

      public void setMark(T mark) {
            this.mark = mark;
      }

}

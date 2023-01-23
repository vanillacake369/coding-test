package Done;

import java.util.LinkedList;
import java.util.Objects;

class AnonymousData {
    int data = 0;

    public AnonymousData(int thisData) {
        this.data = thisData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnonymousData that = (AnonymousData) o;
        return data == that.data;
    }

    public static AnonymousData createData(int d) {
        return new AnonymousData(d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}

public class LearnList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(2);
        list.add(2, 6);

        list.stream()
                .forEach(System.out::println);

        LinkedList<AnonymousData> list1 = new LinkedList<>();
        list1.add(AnonymousData.createData(1));
        list1.add(AnonymousData.createData(2));
        System.out.println(list1.contains(AnonymousData.createData(2)));
    }
}

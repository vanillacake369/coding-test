package programmers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class LinearSearch {
    public static void main(String[] args) {
        LinkedList<Integer> objects = new LinkedList<>();
        int index = 0;

        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            objects.add(r.nextInt(100));
        }
//        index = objects.indexOf(63); // indexOf 실행 시 linear search 실행

        // binary search는 정렬된 리스트에 반으로 갈라 좌우를 택하여 탐색해나가는 알고리즘
        // O(logN)

//        Collections.sort(objects);

        /*
         * 자바에서는 Collections.binarySearch를 통해 이진탐색을 실행한다.
         * 만약 어떤 객체에 대한 이진탐색을 하고 싶을 때는, 해당 클래스가 Comparable 인터페이스를 구현해줘야 한다.
         * :: 검색값과 리스트의 중앙값을 비교 연산해주어야 하기 때문
         * 또한 무조건 순서대로 정렬되어 있어야 이진탐색이 가능하다.
         * :: 정렬되지 않은 구조에 binarySearch 사용 시, 음수를 반환한다.
         * */
        index = Collections.binarySearch(objects, 63);
        System.out.println(index);
        // search는 indexOf, contains, remove 같은 곳에서 이미 구현되어 있다.

    }
}

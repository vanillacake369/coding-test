package codetree.object_sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LineUpStudents {

    /* 학생 객체 */
    static class Student implements Comparable {
        private int height;
        private int weight;
        private int number;

        Student(int height, int weight, int number) {
            this.height = height;
            this.weight = weight;
            this.number = number;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        /**
         * 정렬 기준 함수 재정의 구현
         */
        @Override
        public int compareTo(Object o) {
            Student s = (Student) o;
            // 키가 다르다면 키 순으로 정렬
            if (this.height != s.height) {
                return s.height - this.height;
            }
            // 키가 같지만, 몸무게가 다르다면 몸무게 순으로 정렬
            else if (this.weight != s.weight) {
                return s.weight - this.weight;
            }
            // 키,몸무게 둘 다 같다면 번호 순으로 정렬
            else {
                return this.number - s.number;
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);

    /**
     * 의사코드
     * 1. 키에 대해 가장 큰 키인 친구를 맨 앞에 둔다.
     * 2. 나머지에서 같은 키인 친구들에 대해 몸무게가 다른 친구 중, 더 큰 친구를 앞에 둔다.
     * 3. 나머지에서 키도 같고 몸무게도 같은 친구들은 번호순으로 세운다.
     * 4. 세운 친구들의 키,몸무게 번호를 출력한다.
     * @param args
     */
    public static void main(String[] args) {

        /* 입력 */
        // 학생 수 입력(이후 버퍼 비우기)
        int n = scanner.nextInt();
        scanner.nextLine();
        // 학생들에 대한 리스트
        List<Student> studentsList = new LinkedList<>();
        // 학생들 입력
        studentsList = insertAllStudent(n, studentsList, scanner);

        /* 연산 */
        // 키, 몸무게, 번호 순으로 정렬
        studentsList = sortByHeightWeightNumber(studentsList);

        /* 출력 */
        // 키, 몸무게, 번호 순으로 출력
        printAllStudents(studentsList);

    }

    private static void printAllStudents(List<Student> studentsList) {

        // 키, 몸무게, 번호 순으로 출력
        for (Student s : studentsList) {
            System.out.print(s.getHeight() + " ");
            System.out.print(s.getWeight() + " ");
            System.out.println(s.getNumber());
        }
    }

    private static List<Student> sortByHeightWeightNumber(List<Student> studentsList) {

        // 재정의한 compareTo를 사용한 키,무게,번호 순 정렬
        return studentsList.stream().sorted().collect(Collectors.toList());
    }

    private static List<Student> insertAllStudent(int n, List<Student> studentsList, Scanner scanner) {

        // 학생 리스트 <- 학생객체(키,무게,나이)
        for (int i = 0; i < n; i++) {
            int height = scanner.nextInt();
            int weight = scanner.nextInt();
            int number = i + 1;
            studentsList.add(new Student(height, weight, number));
        }
        return studentsList;
    }
}

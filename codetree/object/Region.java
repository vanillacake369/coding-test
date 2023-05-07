package codetree.object;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Region {

    static class Person implements Comparable<Person> {
        private String name;
        private String addr;
        private String city;

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddr() {
            return addr;
        }

        public String getCity() {
            return city;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Person o) {
            return this.name.compareTo(o.name);
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static List<Person> personList = new LinkedList<>();

    public static void main(String[] args) {

        /* 입력 */
        // 사람 명수 입력
        int n = scanner.nextInt();
        // 버퍼 비우기
        scanner.nextLine();

        /* 연산 */
        // n명의 사람 정보 받기
        getInfoNumberOf(n);

        // 사전순으로 사람 리스트 정렬
        personList = sortByName(personList);

        // 사전순으로 가장 나중의 사람 찾기
        Person firstPersonDescend = personList.get(personList.size() - 1);



        /* 출력 */
        // 찾은 사람 정보 출력
        printPersonInfo(firstPersonDescend);

    }

    private static void printPersonInfo(Person firstPersonDescend) {

        // 인자로 들어온 사람의 모든 정보 출력
        System.out.println("name " + firstPersonDescend.name);
        System.out.println("addr " + firstPersonDescend.addr);
        System.out.println("city " + firstPersonDescend.city);
    }

    private static List<Person> sortByName(List<Person> personList) {

        // 사람 리스트를 이름을 기준으로 사전순 정렬
        /* # 1 */
        /* return personList.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());*/
        /* # 2 */
        return personList.stream()
                .sorted()
                .collect(Collectors.toList());

    }

    private static void getInfoNumberOf(int n) {

        for (int i = 0; i < n; i++) {

            // 공백을 구분자로서 사람 정보를 배열로 생성
            String[] personInfo = scanner.nextLine().split(" ");

            // 새로운 사람 생성
            Person newPerson = new Person();

            // 새로운 사람의 정보 입력
            newPerson.setName(personInfo[0]);
            newPerson.setAddr(personInfo[1]);
            newPerson.setCity(personInfo[2]);

            // 새로운 사람을 사람 리스트에 저장
            personList.add(newPerson);

        }
    }
}

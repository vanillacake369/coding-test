package codetree.object;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RainyDay {

    private static Scanner scanner = new Scanner(System.in);

    private static List<WeatherForecast> rainyDay = new LinkedList<>();

    static class WeatherForecast implements Comparable {
        public WeatherForecast() {
        }

        public WeatherForecast(String date, String day, String weather) {
            this.date = date;
            this.day = day;
            this.weather = weather;
        }

        private String date;
        private String day;
        private String weather;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        @Override
        public int compareTo(Object o) {
            WeatherForecast weatherForecast = (WeatherForecast) o;
            return this.date.compareTo(weatherForecast.getDate());
//            return this.date.compareTo(weatherForecast.getWeather());
        }

        @Override
        public String toString() {
            return (this.date + " " + this.day + " " + this.weather);
        }
    }

    /**
     * 의사코드
     * 1. 기상 객체를 생성한다.
     *      1-1. date
     *      1-2. day
     *      1-3. weather
     * 2. weather가 Rain인 기상객체들을 RainyDay 리스트에 저장한다.
     * 3. RainyDay 리스트를 날짜 오름차순으로 정렬한다.
     * 4. 정렬된 RainyDay 리스트에서 가장 날짜가 빠른 기상객체를 가져온다.
     * 5. 가져온 기상객체를 출력한다.
     */
    public static void main(String[] args) {
        /* 입력 */
        // 기상 예측 정보 수 입력
        int n = scanner.nextInt();
        // 버퍼 비우기
        scanner.nextLine();

        /* 연산 */
        // weather가 Rain인 기상객체들을 RainyDay 리스트에 저장한다.
        storeRainyDay(n);

        // RainyDay 리스트를 날짜 오름차순으로 정렬한다.
        rainyDay = sortRainyDayByDateAsc(rainyDay);

        // 가장 날짜가 빠른 기상객체를 가져온다.
        WeatherForecast firstRainyDay = rainyDay.get(0);

        /* 출력 */
        System.out.println(firstRainyDay);
    }

    private static List<WeatherForecast> sortRainyDayByDateAsc(List<WeatherForecast> rainyDay) {

        return rainyDay.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static void storeRainyDay(int n) {
        for (int i = 0; i < n; i++) {
            String[] inputInfo = scanner.nextLine().split(" ");
            if (inputInfo[2].equals("Rain"))
                rainyDay.add(new WeatherForecast(inputInfo[0], inputInfo[1], inputInfo[2]));
        }
    }
}

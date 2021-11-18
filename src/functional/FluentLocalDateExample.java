package functional;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;

public class FluentLocalDateExample {

    public static void main(String[] args) {

        LocalDate futureDate = LocalDate.now()
                .plusYears(2)
                .minusMonths(1)
                .plusDays(6);

        System.out.println(futureDate);

        List<String> strList = List.of("A", "B");
        strList.forEach(System.out::println);

        Consumer<String> consumer = System.out::println;
    }


}

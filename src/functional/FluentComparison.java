package functional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Function;

public class FluentComparison {

    public static void main(String[] args) {
        final List<Person> people = createPeople();

        final Function<Person, String> byName = Person::getName;
        final Function<Person, Integer> byAge = Person::getAge;

        System.out.println(
                people.stream()
                        .sorted(comparing(byName).thenComparing(byAge))
                        .collect(toList()));

        System.out.println(
                people.stream()
                        .sorted(comparing(byAge).thenComparing(byName))
                        .collect(toList()));
    }

    private static List<Person> createPeople() {
        return List.of(
                Person.builder().name("Jan").age(25).build(),
                Person.builder().name("Pavol").age(55).build(),
                Person.builder().name("Peter").age(35).build(),
                Person.builder().name("Peter").age(31).build(),
                Person.builder().name("Lukas").age(21).build(),
                Person.builder().name("Tomas").age(16).build(),
                Person.builder().name("Marek").age(99).build());
    }

}

package functional;

import static java.util.stream.Collectors.*;

import java.util.*;
import java.util.function.BinaryOperator;

public class Collecting {

    public static void main(String[] args) {

        List<Person> people = createPeople();

        // ITERATING
        people.forEach(person -> System.out.println(person.getName()));

        // FINDING
        List<String> namesStartingWithJ = people.stream()
                .map(Person::getName)
                .filter(name -> name.startsWith("J"))
                .collect(toUnmodifiableList());
        System.out.println(namesStartingWithJ);

        // GROUP PEOPLE BY AGE
        Map<Integer, List<Person>> peopleByAge = people.stream()
                .collect(groupingBy(Person::getAge));
        System.out.println("peopleByAge: " + peopleByAge);

        // GROUP JUST NAMES BY AGE
        Map<Integer, List<String>> namesByAge = people.stream()
                .collect(
                        groupingBy(Person::getAge, mapping(Person::getName, toList())));
        System.out.println("namesByAge: " + namesByAge);

        // GROUP AND REDUCE
        Map<Character, Optional<Person>> oldestOfEachLetter = people.stream().collect(
                groupingBy(person -> person.getName().charAt(0), reducing(BinaryOperator.maxBy(Comparator.comparing(Person::getAge)))));
        System.out.println("oldestOfEachLetter: " + oldestOfEachLetter);

    }

    private static List<Person> createPeople() {
        return  List.of(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35));
    }

}

package functional;

import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;

public class ReusingLambdas {

    public static void main(String[] args) {

        List<String> friends = List.of("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        List<String> editors = List.of("Leon", "Jackie", "John", "Mike");

        /*
         * Different lists - reuse lambda to count starting with N => Lambda can be stored in the variable.
         */
        Predicate<String> startsWithN = name -> name.toLowerCase().startsWith("n");

        long friendsNCount = friends.stream()
                .filter(startsWithN)
                .count();
        System.out.println(friendsNCount);

        long editorsNCount = editors.stream()
                .filter(startsWithN)
                .count();
        System.out.println(editorsNCount);

        /*
         * Lexical Scoping & Closures - now add startsWith different letter - how to DRY it?
         * I create whole function that assembles the Predicate :)
         *
         * Predicate<String> startsWithR = name -> name.toLowerCase().startsWith("r");
         * Predicate<String> startsWithL = name -> name.toLowerCase().startsWith("l");
         * . . .
         */

        long friendsRCount = friends.stream()
                .filter(startsWith("r"))     // I need a ? here - inside goes String, outside boolean
                .count();
        System.out.println("friendsRCount: " + friendsRCount);

        long friendsLCount = friends.stream()
                .filter(startsWith("l"))
                .count();
        System.out.println("friendsLCount: " + friendsLCount);

        /*
         * But we polluted the class with the static method :(
         * How to get rig of it? => we use java's Function which takes letter and returns predicate of String (therefore there will be 2 arrows!)
         */

        Function<String, Predicate<String>> checkStartLetter = letter -> str -> str.toLowerCase(Locale.ROOT).startsWith(letter);   // CRAZY - letter needed to assemble the Predicate for input String :D

        long friendsBCount = friends.stream()
                .filter(checkStartLetter.apply("b"))
                .count();
        System.out.println("friendsBCount: " + friendsBCount);

    }

    private static Predicate<String> startsWith(final String letter) {
        return inputString -> inputString.toLowerCase(Locale.ROOT).startsWith(letter); // CRAZY - inputString does not need to be input parameter, but it is actually the <TYPE> :)
    }
}

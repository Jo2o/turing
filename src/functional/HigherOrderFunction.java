package functional;

import java.util.List;
import java.util.Locale;
import java.util.function.Function;

public class HigherOrderFunction {

    public static void main(String[] args) {

        List<String> names = List.of("Linda", "Dempsey", "Tom", "Jerry");

        // iterative
        for (String name : names) {
            System.out.println(name.toLowerCase(Locale.ROOT));
        }

        // functional = will accept function and element
        names.forEach(name -> System.out.println(
                processString(String::toLowerCase, name)));
    }

    private static String processString(Function<String, String> function, String str) {
        return function.apply(str);
    }
}

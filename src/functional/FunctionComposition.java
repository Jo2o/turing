package functional;

import java.util.function.Function;

public class FunctionComposition {

    public static void main(String[] args) {

        Function<Integer, Integer> absThenNegate = ((Function<Integer, Integer>) Math::negateExact).compose(Math::abs);
        System.out.println(absThenNegate.apply(-25));

        Function<Integer, Integer> negateThenAbs = ((Function<Integer, Integer>) Math::negateExact).andThen(Math::abs);
        System.out.println(negateThenAbs.apply(25));
    }

}

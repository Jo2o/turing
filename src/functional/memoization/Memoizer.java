package functional.memoization;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

class Memoizer<T, U> {

    private final Map<T, U> memo = new ConcurrentHashMap<>();

    private Function<T, U> doMemoize(final Function<T, U> fnc) {
        return in -> memo.computeIfAbsent(in, fnc::apply);
    }

    public static <T, U> Function<T, U> memoize(final Function<T, U> fnc) {
        return new Memoizer<T, U>().doMemoize(fnc);
    }

}

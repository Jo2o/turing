package functional;

import java.util.List;
import java.util.Optional;

public class Reduce {

    public static void main(String[] args) {

        List<String> friends = List.of("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        Optional<String> longestNameOpt = friends.stream()
                .reduce((n1, n2) -> n1.length() > n2.length() ? n1 : n2);

        String longestName = longestNameOpt.orElse(null);
    }

}

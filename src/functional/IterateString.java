package functional;

public class IterateString {

    public static void main(String[] args) {

        String str = "w00t";
        str.chars()
                .forEach(System.out::println);

        str.chars()
                .forEach(charNum -> System.out.println(convertToChar(charNum)));

        str.chars()
                .mapToObj(charNum -> (char) charNum)
                .forEach(System.out::println);
    }

    private static char convertToChar(int num) {
        return (char) num;
    }

}

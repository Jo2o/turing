package algos;

public class EuclidGreatestCommonDenominator {

    public static void main(String[] args) {
        System.out.println(gcd(350, 250));
        System.out.println(gcd(250, 350));
        System.out.println(gcd(18, 12));
        System.out.println(gcd(12, 18));
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    private static int gcdIterativeMe2(int a, int b) {
        while (a != b)
            if (a > b) a -= b;
            else b -= a;
        return a;
    }

}

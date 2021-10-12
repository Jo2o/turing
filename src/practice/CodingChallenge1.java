package practice;


import java.util.HashSet;
import java.util.Set;

public class CodingChallenge1 {

    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][] {
                {1, 3},
                {1, 4},
                {2, 3},
                {2, 4},
                {4, 3}
        }));
    }

    private static int findJudge(int N, int[][] trust) {
        Set<Integer> people = new HashSet<>();
        for (int i = 0; i < trust.length; i++) {
            people.add(trust[i][0]);
        }


        for (int i = 0; i < trust.length; i++) {
            for (int j = 0; j < trust[i].length; j++) {
                System.out.print(trust[i][j]);
            }
            System.out.println();
        }
        return 0;
    }

}

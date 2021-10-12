package practice;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public static void main(String[] args) {
        System.out.println(calPoints(new String[] {"5", "2", "C", "D", "+"}));
    }

    private static int calPoints(String[] ops) {
        List<Integer> convertedScores = new ArrayList<>(ops.length);
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                convertedScores.add(convertedScores.get(convertedScores.size()-1) + convertedScores.get(convertedScores.size()-2));
            } else if (ops[i].equals("D")) {
                convertedScores.add(2*convertedScores.get(convertedScores.size()-1));
            } else if (ops[i].equals("C")) {
                convertedScores.remove(i-1);
            } else {
                convertedScores.add(parseInt(ops[i]));
            }
        }
        return convertedScores.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}

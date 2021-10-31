package leetcode;

public class ZigZag {

    public static void main(String[] args) {
//        System.out.println(convert("paypalishiring", 3));
//        System.out.println(convert("abc", 2));
//        System.out.println(convert("abcd", 2));
        System.out.println(convert("abcde", 4));

        System.out.println(convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.", 3));
    }

    private static String convert(String s, int numRows) {
        int length = s.length();
        if (length == numRows || numRows == 1) {
            return s;
        }

        int downLength = numRows;
        int upLength = numRows - 2;
        int downCounter = 0;
        int upCounter = upLength;

        Character[][] zigZagMap = new Character[numRows][calculateZigZagWidth(length, numRows)];

        boolean goingDown = true;
        int y = 0;
        for (char ch : s.toCharArray()) {
            if (goingDown) {
                zigZagMap[downCounter][y] = ch;
                downCounter++;
            } else {
                zigZagMap[upCounter][y] = ch;
                upCounter--;
            }

            if (downCounter >= downLength) {
                downCounter = 0;
                y++;
                goingDown = upLength == 0;
                continue;
            }

            if (upCounter <= 0 && upLength !=0) {
                upCounter = upLength;
                y++;
                goingDown = true;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < (calculateZigZagWidth(length, numRows)); j++) {
                if (zigZagMap[i][j] != null) {
                    stringBuilder.append(zigZagMap[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }

    private static int calculateZigZagWidth(int stringLength, int rows) {
        int result = stringLength/(rows + rows - 2) * 2;
        if (stringLength > result/2 * rows + result/2 * (rows - 2)) {
            result++;
        }
        return ++result;
    }

}

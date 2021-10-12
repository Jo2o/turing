package leetcode;

import java.util.*;

public class LongestSubstringNoRepeatingChars {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println(lengthOfLongestSubstring("aab"));      // 2
        System.out.println(lengthOfLongestSubstring("dvdf"));     // 3
    }

    public static int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int result = 0;
        int counter = 0;
        List<Character> memory = new ArrayList<>();

        for (char ch : str.toCharArray()) {
            if (memory.contains(ch)) {
                int idx = memory.indexOf(ch);
                memory = memory.subList(idx +1, memory.size());
                memory.add(ch);
                counter = memory.size();
                continue;
            }
            memory.add(ch);
            counter++;
            if (counter > result) {
                result = counter;
            }
        }
        return result;
    }
}

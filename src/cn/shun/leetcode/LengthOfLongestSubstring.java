package cn.shun.leetcode;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("abcad");
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 1;
        int left = 0;
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}

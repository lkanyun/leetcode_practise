package cn.shun.leetcode;


public class ReverseString {
    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        reverseString(chars);
        for (char aChar : chars) {
            System.out.println(aChar);
        }
    }
    public static void reverseString(char[] s) {
        // 定义i作为数组的开头指针，j作为数组的结尾指针，双指针往中间靠近并依次交换位置
        for (int i = 0, j = s.length -1; i < s.length; i++, j--) {
            // j保证始终在i的右边
            if (j <= i){
                break;
            }
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}

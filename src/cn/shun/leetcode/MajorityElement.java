package cn.shun.leetcode;

public class MajorityElement {
    public static void main(String[] args) {
        int i = majorityElement(new int[]{2,2,1,1,1,2,2});
        System.out.println(i);
    }
    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int currentNum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                currentNum = nums[i];
                count ++;
            } else if (currentNum == nums[i]) {
                count++;
            } else {
                count --;
            }
        }
        // 冒泡排序
        return currentNum;
    }
}

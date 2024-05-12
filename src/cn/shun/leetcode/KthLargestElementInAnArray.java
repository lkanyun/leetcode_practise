package cn.shun.leetcode;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int kthLargest = findKthLargest2(nums, 2);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> deque = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (deque.size() < k) {
                deque.add(nums[i]);
            } else if (deque.peek() < nums[i] ) {
                deque.remove();
                deque.add(nums[i]);
            }
        }
        return deque.peek();
    }

    public static int findKthLargest2(int[] nums, int k) {
        int[] buckets = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] + 10000]++;
        }
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] > 0) {
                k = k - buckets[i];
                if (k <= 0) return i - 10000;
            }
        }
        return 0;
    }
}

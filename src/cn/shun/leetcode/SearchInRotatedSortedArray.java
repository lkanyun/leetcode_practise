package cn.shun.leetcode;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,3};
        int search = search(nums, 0);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        int k = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[i + 1]) {
                k = i;
                break;
            }
        }
        int left = 0, right = k;
        int result = searchMid(nums, target, left, right);
        if (result != -1 || k == -1)  {
            return result;
        }
        left = k + 1;
        right = nums.length - 1;
        return searchMid(nums, target, left, right);
    }

    private static int searchMid(int[] nums, int target, int left, int right) {
        if (nums[left] > target || nums[right] < target) {
            return -1;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}

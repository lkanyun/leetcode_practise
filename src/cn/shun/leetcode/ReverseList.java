package cn.shun.leetcode;

public class ReverseList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        reverseList(null);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode currentNode = head.next;
        ListNode next = currentNode.next;
        head.next = null;
        currentNode.next = head;

        ListNode temp;
        while (next != null && (temp = next.next) != null) {
            next.next = currentNode;
            currentNode = next;
            next = temp;
        }
        if (next != null) {
            next.next = currentNode;
            currentNode = next;
        }
        return currentNode;
    }
    public static ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode subHead = next.next;
        next.next = head;
        head.next = null;
        return reverseList3(subHead, next);
    }
    public static ListNode reverseList3(ListNode subHead, ListNode next) {
        if (subHead == null) {
            return next;
        }
        ListNode newNext = subHead.next;
        subHead.next = next;
        return reverseList3(newNext, subHead);
    }


}

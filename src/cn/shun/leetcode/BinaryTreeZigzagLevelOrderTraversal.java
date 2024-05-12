package cn.shun.leetcode;

import cn.shun.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        zigzagLevelOrder(null);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {return result;}
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isAsc = true;
        while (!queue.isEmpty()) {
            List<Integer> currentNodes = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isAsc) {
                    currentNodes.add(node.val);
                } else {
                    currentNodes.add(0, node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(currentNodes);
            isAsc = ! isAsc;
        }
        return result;
    }
}

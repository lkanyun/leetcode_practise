package cn.shun.leetcode;

import cn.shun.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        List<Integer> integers = rightSideView(null);
        integers.forEach(System.out::println);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)  {
            return result;
        }
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        Deque<Integer> depthQueue = new LinkedList<>();
        nodeQueue.push(root);
        depthQueue.push(0);
        while(!nodeQueue.isEmpty()) {
            Integer depth = depthQueue.pop();
            TreeNode node = nodeQueue.pop();
            if (result.size() <= depth) {
                result.add(depth, node.val);
            } else {
                result.set(depth, node.val);
            }
            if (node.right != null) {
                nodeQueue.push(node.right);
                depthQueue.push(depth + 1);
            }
            if (node.left != null) {
                nodeQueue.push(node.left);
                depthQueue.push(depth + 1);
            }
        }
        return result;
    }

}
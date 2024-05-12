package cn.shun.leetcode;

import cn.shun.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RightSideView {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        rightSideView(treeNode);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        currentLevel(root, list, 1);
        return list;
    }

    public static List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
        }


        return list;
    }
    public static void currentLevel(TreeNode currentNode, List<Integer> list, int level) {
        if (currentNode == null){
            return;
        }
        if (list.size() < level) {
           }
        if (currentNode.right != null) {
            currentLevel(currentNode.right, list, level + 1);
        }
        if (currentNode.left != null) {
            currentLevel(currentNode.left, list, level + 1);
        }
    }
}
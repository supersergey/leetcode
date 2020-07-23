package com.company.serialize_binary_tree;

import com.company.move_zeroes.Solution;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        LinkedList<TreeNode> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        q.push(root);
        while (!q.isEmpty()) {
            TreeNode current = q.pop();
            result.append(current == null ? "null" : current.val).append(";");
            if (current != null) {
                q.add(current.left);
                q.add(current.right);
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(",");

        TreeNode root = getOrNull(nodes, 0);
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int i = 0;
        while (i < nodes.length && !list.isEmpty()) {
            TreeNode current = list.pop();
            if (current != null) {
                current.left = getOrNull(nodes, ++i);
                current.right = getOrNull(nodes, ++i);
                list.add(current.left);
                list.add(current.right);
            }
        }
        return root;
    }

    private TreeNode getOrNull(String[] list, int pos) {
        if (pos >= list.length) {
            return null;
        }
        return list[pos].equals("null") ? null : new TreeNode(Integer.parseInt(list[pos]));
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode level2left = new TreeNode(2);
//        TreeNode level2right = new TreeNode(3);
//        TreeNode level3left = new TreeNode(4);
//        TreeNode level3right = new TreeNode(5);
//        root.left = level2left;
//        root.right = level2right;
//        level2right.left = level3left;
//        level2right.right = level3right;
        Codec codec = new Codec();
        System.out.println(codec.serialize(codec.deserialize("1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5")));
//        Codec codec = new Codec();
//        System.out.println(codec.serialize(root));
//        System.out.println(codec.serialize(codec.deserialize("1;2;3;null;null;4;5;null;null;null;null;")));
    }
}

class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
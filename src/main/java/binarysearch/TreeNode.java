package leetcode.bst;

/**
 * @Description: TODO
 * @Author: UncleBryan
 * @Date: 2021/10/13 16:51
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
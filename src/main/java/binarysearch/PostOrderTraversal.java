package leetcode.bst;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 二叉树后序遍历 左 右 根
 * @Author: UncleBryan
 * @Date: 2021/10/13 16:50
 */
public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                //当前节点入栈，向左遍历
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 当右子树为空或者已经遍历并记录过进行如下操作
            if (root.right == null || root.right == prev) {
                //右子树为空，记录当前节点
                res.add(root.val);
                // 将栈的指针执行当前节点，并将当前节点置空，从而达到继续出栈的目的
                prev = root;
                root = null;
            } else {
                // 右子树不为空，将当前节点入栈，继续迭代找到最右节点
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node10 = new TreeNode(10);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5,node10,null);
        TreeNode node4 = new TreeNode(4,node8,node9);
        TreeNode node3 = new TreeNode(3,node6,node7);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);


        List<Integer> ret = new PostOrderTraversal().postorderTraversal(node1);
        System.out.println(ret);
    }
}
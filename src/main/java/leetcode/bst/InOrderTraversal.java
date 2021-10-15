package leetcode.bst;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 二叉树中序遍历
 * @Author: UncleBryan
 * @Date: 2021/10/15 20:05
 */
public class InOrderTraversal {
    /**
     * 迭代的方式
     */
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new LinkedList();
        // 在遍历的过程中，存在入栈出栈，当当前节点为空时，栈中可能还存在数据，所以两个条件满足其一都需要遍历
        while (!stack.isEmpty() || root!=null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            // 找到最左节点开始出栈
            root = stack.pop();
            res.add(root.val);
            //出栈后开始寻找右节点
            root = root.right;
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode node10 = new TreeNode(10,null,null);
        TreeNode node9 = new TreeNode(9,null,null);
        TreeNode node8 = new TreeNode(8,null,null);
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node5 = new TreeNode(5,node10,null);
        TreeNode node4 = new TreeNode(4,node8,node9);
        TreeNode node3 = new TreeNode(3,node6,node7);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);


        List<Integer> ret = new InOrderTraversal().inorderTraversal(node1);
        System.out.println(ret);
    }
}
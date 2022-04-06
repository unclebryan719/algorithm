package leetcode.bst;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 二叉树前序遍历   根 左 右
 * @Author: UncleBryan
 * @Date: 2021/10/15 20:18
 */
public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 可以去掉这个非空判断，下面已经做了判断
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                // 因为是前序遍历，所以首先把根节点记录下，然后遍历左节点
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }
}
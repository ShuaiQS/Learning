package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {

    /**
     * 前序遍历的递归写法,深度优先搜索
     * @param root 根节点
     * @return 遍历结果
     */
    private List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root,list);
        return list;
    }

    private void  preorderTraversal(TreeNode root, List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        preorderTraversal(root.left,list);
        preorderTraversal(root.right,list);
    }

    /**
     * 前序遍历的迭代写法，广度优先搜索
     * @param root 根节点
     * @return 遍历结果
     */
    private List<Integer> preorderTraversal1(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if(pop.right!=null) stack.push(pop.right);
            if(pop.left!=null) stack.push(pop.left);
        }
        return list;
    }
}

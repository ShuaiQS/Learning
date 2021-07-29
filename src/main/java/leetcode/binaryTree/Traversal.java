package leetcode.binaryTree;

import java.util.*;

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

    private List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null || !stack.empty()){
            while (root!=null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return list;
    }


    /**
     * 中序遍历的递归写法
     * @param root 根节点
     * @return 遍历的列表
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root,list);
        return list;
    }

    /**
     * 中序遍历递归
     * @param root 根节点
     * @param list 列表
     */
    private void inorderTraversal(TreeNode root, List<Integer> list){
        if(root==null) return;
        inorderTraversal(root.left,list);
        list.add(root.val);
        inorderTraversal(root.right,list);
    }

    private List<Integer> inorderTraversal1(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node!=null||!stack.isEmpty()){
            if(node !=null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                list.add(node.val);
                node = node.right;

            }
        }
        return list;
    }

    private List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    /**
     * 后续遍历
     * @param root 根节点
     * @return 列表
     */
    private List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root,list);
        return list;
    }

    private void postorderTraversal(TreeNode root, List<Integer> list){
        if(root==null) return;
        postorderTraversal(root.left,list);
        postorderTraversal(root.right,list);
        list.add(root.val);

    }

    private List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null||!stack.empty()){
            while (root!=null){
                list.add(root.val);
                stack.push(root);
                root = root.right;
            }
            root = stack.pop().left;
        }
        Collections.reverse(list);
        return list;

    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root==null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size;
        TreeNode cur;
        while (!queue.isEmpty()){
            size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                cur = queue.poll();
                list.add(cur.val);
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(1);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(5);
        new Traversal().levelOrder(treeNode).forEach(System.out::println);

    }
}

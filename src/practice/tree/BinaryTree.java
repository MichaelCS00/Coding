package practice.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname BinaryTree
 * @Description 训练二叉树的创建和遍历
 * @Date 10/30/2019 8:47 AM
 * @Created by MichaelCS
 */
public class BinaryTree {

    static List<Integer> traversalList = new LinkedList<>();
    /**
     * 二叉树结点定义
     */
    private static class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode (int data){
            this.data = data;
        }
    }

    /**
     * @descp 递归建树
     * @param inputList 输入链表
     * @return 返回节点
     */
    public static TreeNode creatBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if(null == inputList || inputList.isEmpty()){
            return null;
        }

        Integer data = inputList.removeFirst();
        if(null != data){
            node = new TreeNode(data);
            node.leftChild = creatBinaryTree(inputList);
            node.rightChild = creatBinaryTree(inputList);
        }
        return node;
    }

    /**
     * @descp 递归前序遍历
     * @param node 根节点
     */
    public static void preOrderTraversal(TreeNode node){
        if(null == node){
            return;
        }
//        System.out.println(node.data);
        traversalList.add(node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * @descp 非递归前序遍历
     * @param root 根节点
     */
    public static void preOrderTraversalWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(null != node || !stack.isEmpty()){
            // 迭代访问左孩子 并入栈
            while(null != node){
                traversalList.add(node.data);
                stack.push(node);
                node = node.leftChild;
            }
            // 如果左孩子为空 且栈不为空则访问右孩子
            if(!stack.isEmpty()){
                node = stack.pop();
                node = node.rightChild;
            }
        }
    }


    /**
     * @descp 中序遍历
     * @param node 根节点
     */
    public static void inOrderTraversal(TreeNode node){
        if(null == node){
            return;
        }
        inOrderTraversal(node.leftChild);
        traversalList.add(node.data);
        inOrderTraversal(node.rightChild);
    }

    public static void inOrderTraversalWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;

        while(null != currNode || !stack.isEmpty()){
            // 当前节点非空则入栈 并迭代访问当前节点左孩子
            while(null != currNode){
                stack.push(currNode);
                currNode = currNode.leftChild;
            }
            // 当前节点为空且栈非空时 回溯父节点并访问其右孩子
            if(!stack.isEmpty()){
                currNode = stack.pop();
                // todo !!!!
                traversalList.add(null);
                currNode = currNode.rightChild;
            }
        }
    }

    /**
     * @descp 后续遍历
     * @param node
     */
    public static void postOrderTraversal(TreeNode node){
        if(null == node){
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        traversalList.add(node.data);
    }

    public static void postOrderTraversalWithStack(TreeNode root){
        // 初始化数据
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;

        while(null != currNode || !stack.isEmpty()){
            // 当前节点非空则入栈并迭代访问其左孩子
            while(null != currNode){
                stack.push(currNode);
                currNode = currNode.leftChild;
            }
            // 若当前节点为空且栈非空则回溯当前节点的父节点并访问其有孩子
            if(!stack.isEmpty()){
                currNode = stack.pop();

                currNode = currNode.rightChild;
            }

        }
    }

    private static void displayTraversalResult(){
        for(Integer integer : traversalList){
            System.out.print(integer+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        LinkedList<Integer> inputList = new LinkedList<>(
                Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4})
        );
        // 构建树
        TreeNode root = creatBinaryTree(inputList);
        // 递归前序遍历
        traversalList.clear();
        preOrderTraversal(root);
        System.out.print("preOrder: ");
        displayTraversalResult();

        // 非递归前序遍历
        traversalList.clear();
        preOrderTraversalWithStack(root);
        System.out.print("preOrder_Stack: ");
        displayTraversalResult();

        // 递归中序遍历
        traversalList.clear();
        inOrderTraversal(root);
        System.out.print("inOrder: ");
        displayTraversalResult();

        // 递归后续遍历
        traversalList.clear();
        postOrderTraversal(root);
        System.out.print("postOrder: ");
        displayTraversalResult();
    }
}


package practice.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
     * @descp 前序遍历
     * @param node 根节点
     */
    public static void preOrderTraversal(TreeNode node){
        if(null == node){
            return;
        }
        System.out.println(node.data);
        traversalList.add(node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
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
        System.out.println(node.data);
        traversalList.add(node.data);
        inOrderTraversal(node.rightChild);
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
        System.out.println(node.data);
        traversalList.add(node.data);
    }

    private static void displayTraversalResult(List<Integer> traversalResult){
        for(Integer integer : traversalResult){
            System.out.println(integer);
        }
    }

    public static void main(String[] args){
        LinkedList<Integer> inputList = new LinkedList<>(
                Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4})
        );
        // 构建树
        TreeNode root = creatBinaryTree(inputList);
        System.out.println("preOrder: ");
        displayTraversalResult(traversalList);
        preOrderTraversal(root);
        System.out.println("inOrder: ");
        inOrderTraversal(root);
        System.out.println("postOrder: ");
        postOrderTraversal(root);

    }
}


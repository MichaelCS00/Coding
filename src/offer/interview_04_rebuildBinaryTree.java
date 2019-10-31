package offer;

/**
 * @Classname interview_04_rebuildBinaryTree
 * @Description 根据前序遍历和中序遍历结果重建二叉树
 * @Date 10/29/2019 2:52 PM
 * @Created by MichaelCS
 */
public class interview_04_rebuildBinaryTree {
    public static void main(String[] args){

    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x;}
    }

    private class Solution_04 {
        public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
            // 处理异常数据
            if(0 == pre.length || 0 == in.length){

            }

            // 初始化数据
            TreeNode result = new TreeNode(pre[0]);

            // 主要执行逻辑


            return result;
        }

}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


}
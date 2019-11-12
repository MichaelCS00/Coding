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
        private int[] pre;
        private int[] in;
        public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
            // 处理异常数据
            if(0 == pre.length || 0 == in.length){
                return null;
            }

            // 初始化数据
            this.pre = pre;
            this.in = in;
            int bigin = 0;
            int end = in.length-1;

            // 主要执行逻辑
            TreeNode result = coreMethod(0,0,pre.length-1);

            return result;
        }

        private TreeNode coreMethod(int index,int begin,int end){
            // 找到节点位置
            int currData = pre[index];
            TreeNode node = null;
            for(int i=begin; i<end; i++){
                if(currData == in[i]){
                    node = new TreeNode(in[i]);
                    node.left = coreMethod(index+1,begin,i-1);
                    node.right = coreMethod(index+i,i+1,end);
                    break;
                }
            }
            return node;
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
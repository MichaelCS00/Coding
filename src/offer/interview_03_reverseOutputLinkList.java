package offer;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @Classname interview_03_reverseOutputLinkList
 * @Description TODO
 * @Date 10/29/2019 9:03 AM
 * @Created by MichaelCS
 */
public class interview_03_reverseOutputLinkList {
    public static void main(String[] args){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode = null;
        Solution_03 solution = new Solution_03();
        ArrayList<Integer> list = solution.printListFromTailToHead(listNode);
        for(Integer i : list){
            System.out.println(i);
        }
    }
}
class Solution_03 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 初始化数据
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;

        // 处理异常输入
        if(null == listNode){
            return result;
        }

        // 主要逻辑
        do{
            // 加入临时列表
            temp.add(listNode.val);
            listNode = listNode.next;
        }while (null != listNode);

        for(int i=temp.size()-1; i>=0; i--){
            // 反转列表
            result.add(temp.get(i));
        }

        return result;
    }
}

class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }
}

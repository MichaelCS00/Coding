package leetCode;

/**
 * @Classname leet_214_ShortestPalindrome
 * @Description 找到并拼接出最短会问串
 * @Date 10/5/2019 10:45 AM
 * @Created by MichaelCS
 */
public class leet_214_ShortestPalindrome {
    public static void main(String[] args){
        String testString = "abcd";
        Solution solution = new Solution();
        System.out.println(solution.shortestPalindrome(testString));

    }
}

/**
 * 利用三个指针，head,middle,tail
 * 将问题转换为寻找最中心的对称点
 * 未找到的话，三个指针向左移动继续寻找
 * 直到 head 到达 0 的位置，此时有两种情况
 * 若 head == tail 则以 middle 为中心
 * 否则以 head 为中心
 */
class Solution {

    /**
     * 处理不能用 3 个指针处理的情况
     * 即长度小于 3 的字符串
     */
    private String handleExcep(String s){
        if((s.length() == 0)||(s.length() == 1)){
            return s;
        }else if(s.length() == 2){
            if(s.charAt(0) == s.charAt(1)){
                return s;
            }else {
                return s.charAt(1)+s.charAt(0)+s;
            }
        }else {
            return "error!";
        }
    }

    public String shortestPalindrome(String s) {
        // 初始化三个指针的位置
        int tail = (int)Math.ceil((double) s.length()/2);
        int middle = tail-1;
        int head = tail-2;
        boolean find = false;
        String result;

        // 处理无法用三个指针处理的特殊情况
        if(s.length() < 4){
            return handleExcep(s);
        }
        // 对串进行遍历
        while(true){

            // 对middle == tail 的情况进行处理
            if(s.charAt(middle) == s.charAt(tail)){
                int middle1 = middle;
                int tail1 = tail;

                while (true){
                    // 一直到 middle 移动到字符串头部跳出循环
                    if(middle1 == 0){
                        find = true;
                        break;
                    }
                    // 以原 middle tail 为中心往两边拓展
                    if(s.charAt(middle1-1) == s.charAt(tail1+1)){
                        middle1--;
                        tail1++;
                    }else {
                        break;
                    }
                }

                if(find) {
                    // 构造结果串
                    // 将tail后面的子串逆序加到头部
                    StringBuilder builder = new StringBuilder(s.substring(tail1+1));
                    result = builder.reverse()+s;
                    break;
                }
            }

            // 对head == tail 的情况进行处理
            if(s.charAt(head) == s.charAt(tail)){
                int head1 = head;
                int tail1 = tail;
                while(true){
                    if(head1 == 0){
                        find = true;
                        break;
                    }
                    if(s.charAt(head1-1) == s.charAt(tail+1)){
                        head1--;
                        tail1++;
                        // head1 遍历到串头说明已找到
                    }else {
                        break;
                    }
                }

                if(find) {
                    // 构造结果串
                    // 将tail后面的子串逆序加到头部
                    StringBuilder builder = new StringBuilder(s.substring(tail1+1));
                    result = builder.reverse()+s;
                    break;
                }
            }
            tail--;
            middle--;
            head--;
        }
        return result;
    }
}
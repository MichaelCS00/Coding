package leetcode;

/**
 * @Classname leet_214_ShortestPalindrome
 * @Description 找到并拼接出最短会问串
 * @Date 10/5/2019 10:45 AM
 * @Created by MichaelCS
 */
public class leet_214_ShortestPalindrome {
    public static void main(String[] args) {
        String testString = "aaaaa";
        Solution solution = new Solution();
        System.out.println(solution.shortestPalindrome(testString));

    }
}

/**
 * 利用三个指针，head,middle,tail
 * 将问题转换为寻找最中心的对称点（这一点是核心，所有逻辑以这一核心展开即可）
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
    private String handleExcep(String s) {
        if ((s.length() == 0) || (s.length() == 1)) {
            return s;
        } else if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.charAt(1) + s;
            }
        } else {
            return "error!";
        }
    }

    public String shortestPalindrome(String s) {

        int tail;
        int middle;
        int head;
        boolean even;

        // 初始化三个指针的位置及串长的奇偶性
        if ((s.length() % 2) == 0) {
            // 偶数情况
            even = true;
            tail = (int) Math.ceil((double) s.length() / 2) + 1;
        } else {
            // 奇数情况
            even = false;
            tail = (int) Math.ceil((double) s.length() / 2);
        }
        middle = tail - 1;
        head = tail - 2;

        // 起始拷贝点,这里用数组类型强行让他能在方法里面被改变
        int[] copyPoint = {-1};
        // 是否发现最左回文串标识
        boolean find = false;
        // 结果
        String result;

        // 处理无法用三个指针处理的特殊情况
        if (s.length() < 3) {
            return handleExcep(s);
        }
        // 对串进行遍历
        while (head >= 0) {
            if(even){
                find = checkHeadAndMiddle(head,middle,tail,s,copyPoint);
                if(find)break;
                find = checkHeadAndTail(head,middle,tail,s,copyPoint);
                if(find)break;
            }else {
                find = checkHeadAndTail(head,middle,tail,s,copyPoint);
                if(find)break;
                find = checkHeadAndMiddle(head,middle,tail,s,copyPoint);
                if(find)break;
            }
            head--;
            middle--;
            tail--;
        }


    StringBuilder builder;
        if (find) {
        // 构造结果串
        // 将tail后面的子串逆序加到头部
        builder = new StringBuilder(s.substring(copyPoint[0] + 1));
        result = builder.reverse() + s;
    } else {
        // 未找到
        builder = new StringBuilder(s.substring(1));
        result = builder.reverse() + s;
    }
        return result;
    }

    private boolean checkHeadAndMiddle(int head, int middle, int tail, String s, int[] copyPoint) {
        boolean find = false;
        // 对head == 0 且 middle == head  的特殊情况进行处理
        if (s.charAt(head) == s.charAt(middle)) {
            if (head == 0 && s.charAt(head) != s.charAt(tail)) {
                find = true;
                copyPoint[0] = middle;
                return find;
            }

            int head1 = head;
            int middle1 = middle;

            while ((head1 - 1 >= 0) && (middle1 + 1 < s.length())) {
                // 以原 middle tail 为中心往两边拓展
                if (s.charAt(head1 - 1) == s.charAt(middle1 + 1)) {
                    head1--;
                    middle1++;
                    // 一直到 middle 移动到字符串头部跳出循环
                    if (head1 == 0) {
                        copyPoint[0] = (Integer) middle1;
                        find = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return find;
    }

    private boolean checkHeadAndTail(int head, int middle, int tail, String s, int[] copyPoint) {
        boolean find = false;

        if (s.charAt(head) == s.charAt(tail)) {
            if(head == 0){
                find = true;
                copyPoint[0] = tail;
                return find;
            }
            int head1 = head;
            int tail1 = tail;

            while ((head1 - 1 >= 0) && (tail1 + 1 < s.length())) {
                // 以原 middle 为中心往两边拓展
                if (s.charAt(head1 - 1) == s.charAt(tail1 + 1)) {
                    head1--;
                    tail1++;
                    // 一直到 head 移动到字符串头部跳出循环
                    if (head1 == 0) {
                        copyPoint[0] = tail1;
                        find = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return find;
    }
}
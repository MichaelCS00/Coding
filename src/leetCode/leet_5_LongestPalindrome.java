package leetCode;

/**
 * @Classname leet_5_LongestPalindrome
 * @Description 寻找最长回文串
 * @Date 10/2/2019 10:16 AM
 * @Created by MichaelCS
 */
public class leet_5_LongestPalindrome {
    public static void main(String[] args){
        String string = "";
        String result;
//        Solution_01 solution = new Solution_01();
        Solution_02 solution = new Solution_02();
        result = solution.longestPalindrome(string);
        System.out.println(result);
    }
}

/**
 *  对于遇到 baab bab 的两种可能存在回文串的情况进行进一步判定解法
 *  需要利用 3个 指针
 */
class Solution_01 {
    public String longestPalindrome(String s) {

        // 当前回文串
        String currPalindrome;

        // 最大回文串
        String maxPalindrome = new String();

        // 初始化三个指针
        int head = -1;
        int middle = 0;
        int tail = 1;

        // 遍历字符串
        while(tail < s.length()){

            // 情况1 middle = tail
            if(s.charAt(middle) == s.charAt(tail)){
                int middle1 = middle;
                int tail1 = tail;

                // 检测回文
                while((middle1-1 >= 0) && (tail1+1 < s.length())){
                    if(s.charAt(middle1-1) != s.charAt(tail1+1)){
                        break;
                    }else {
                        middle1--;
                        tail1++;
                    }
                }
                // 保存回文串
                currPalindrome = new String(s.toCharArray(),middle1,tail1-middle1+1);
                maxPalindrome = currPalindrome.length() >= maxPalindrome.length() ? currPalindrome : maxPalindrome;
            }

            // 情况2 head = tail
            if((head >= 0) && (s.charAt(head) == s.charAt(tail))){
                int head1 = head;
                int tail1 = tail;

                // 检测回文
                while((head1-1 >= 0) && (tail1+1 < s.length())){
                    if(s.charAt(head1-1) != s.charAt(tail1+1)){
                        break;
                    }else {
                        head1--;
                        tail1++;
                    }
                }

                // 保存回文串
                currPalindrome = new String(s.toCharArray(),head1,tail1-head1+1);
                maxPalindrome = currPalindrome.length() >= maxPalindrome.length() ? currPalindrome : maxPalindrome;
            }
            head++;
            middle++;
            tail++;
        }
        // 对s = "a" 和 s = "" 或 没有回文串 的特殊情况进行处理
        if(maxPalindrome.length() == 0){
            if(s.length() == 0){
                return "";
            }else {
                return ""+s.charAt(0);
            }
        }
        return maxPalindrome;
    }
}

/**
 *  暴力解法，可能会超时
 *  需要利用两个指针
 */
class Solution_02 {


    public boolean isPalindromic(String s) {
        int len = s.length();

        // 这里很巧秒地利用了回文串的头尾一定一致的特点，只需要两个指针分别从头尾开始遍历到二者相等即可
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 暴力解法
    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        return ans;
    }
}


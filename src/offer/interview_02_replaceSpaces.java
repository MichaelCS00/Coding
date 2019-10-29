package offer;

/**
 * @Classname interview_02_replaceSpaces
 * @Description 替换字符串中的空格
 * @Date 10/12/2019 5:13 PM
 * @Created by MichaelCS
 */
public class interview_02_replaceSpaces {
    static public void main(String[] args){
        StringBuffer str = new StringBuffer("a bcd  e");
        Solution_02 solution = new Solution_02();
        System.out.println(solution.replaceSpace(str));
    }
}

class Solution_02{
    public String replaceSpace(StringBuffer str) {

        // 初始化数据
        StringBuilder result = new StringBuilder();
        int begin = 0;
        int end = 0;

        // 处理异常数据
        if(str.length() == 0){
            return "";
        }

        // 主要执行逻辑
        while (end < str.length()){
            if(str.charAt(end) == ' '){
                result.append(str.substring(begin, end)).append("%20");
                begin = end+1;
            }
            end++;
            if(end == str.length()){
                result.append(str.substring(begin,end));
            }
        }

        return result.toString();
    }
}

package offer;

/**
 * @Classname interview_01_findInTowDimensionalArray
 * @Description ：
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * @Date 10/12/2019 3:09 PM
 * @Created by MichaelCS
 */
public class interview_01_findInTowDimensionalArray {
    public static void main(String[] args){
        int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] array1 = {{}};
        Solution solution = new Solution();
        System.out.println(solution.Find(16,array));
    }
}

class Solution {
    public boolean Find(int target, int[][] array) {
        int times = 0;
        // 初始化数据
        int rows = array.length;
        if(rows == 0) return false;

        int cols = array[0].length;
        if(cols == 0) return false;
        int column = 0;

        int row = rows-1;
        boolean result = false;
        // 异常数据处理

        if((target > array[row][row]) || target < array[0][0]){
            return false;
        }
        // 主要处理逻辑
        while((row >= 0) && (column < cols)){
            times++;
            int a = array[row][column];
            if(target < array[row][column]){
                row--;
            }else if(target > array[row][column]){
                column++;
            }else {
                result = true;
                break;
            }
        }
        System.out.println("times:"+times);
        return result;
    }
}

class Solution2 {
    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        if(rows == 0){
            return false;
        }
        int cols = array[0].length;
        if(cols == 0){
            return false;
        }
        // 左下
        int row = rows-1;
        int col = 0;
        while(row>=0 && col<cols){
            if(array[row][col] < target){
                col++;
            }else if(array[row][col] > target){
                row--;
            }else{
                return true;
            }
        }
        return false;
    }
}
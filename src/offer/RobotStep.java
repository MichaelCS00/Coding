package offer;

import java.util.Stack;

/**
 * @Classname RobotStep
 * @Description TODO
 * @Date 2019/9/18 15:36
 * @Created by MichaelCS
 */
public class RobotStep {


    class Solution {

        // 走过的格子数量
        int result;
        // 记录走过的格子
        boolean [][] map;
        // 当前所在格
        Position currPosition;
        // 回溯栈
        Stack<Position> stack = new Stack<>();

        public int movingCount(int threshold, int rows, int cols)
        {
            // 初始化数据
            currPosition = new Position(rows,cols);
            map = new boolean[rows][cols];
            map[currPosition.row][currPosition.col] = true;
            stack.push(currPosition);


            while(!stack.empty()){
                // 判断右侧

            }

            return  result;
        }


        public void makeOneStep(){

        }

        class Position {
            Position(int row,int col){
                this.col = col;
                this.row = row;
            }
            int row;
            int col;
        }

    }
}

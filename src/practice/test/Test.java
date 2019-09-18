package practice.test;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2019/9/18 10:29
 * @Created by MichaelCS
 */
public class Test {
    static int count = 0;
    public int movingCount(int threshold, int rows, int cols)
    {
        int rowIndex = 0;
        int colIndex = 0;
        boolean[] isVisited = new boolean[rows*cols];
        move(rowIndex,colIndex,isVisited,threshold,cols,rows);
        return count;
    }
    private boolean move(int rowIndex,int colIndex,boolean[] isVisited,int threshold,int cols,int rows){
        if (rowIndex<0 || rowIndex>rows-1 || colIndex <0 || colIndex>cols-1) return false;
        int sum = (sumOfnum(rowIndex)+sumOfnum(colIndex));
        if (sum<=threshold && !isVisited[rowIndex*cols+colIndex]){
            count++;
            isVisited[rowIndex*cols+colIndex] = true;
            if (move(rowIndex,colIndex+1,isVisited,threshold,cols,rows)
                    || move(rowIndex+1,colIndex,isVisited,threshold,cols,rows)
                    || move(rowIndex,colIndex-1,isVisited,threshold,cols,rows)
                    || move(rowIndex-1,colIndex,isVisited,threshold,cols,rows)){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    private int sumOfnum(int num){
        int sum = 0;
        while (num != 0){
            sum += num%10;
            num /= 10;
        }
        return sum;

    }
    public static void main(String[] a){
        Test test = new Test();
        int i = test.movingCount(15,20,20);
        System.out.println(i);
    }

}
class Main{
    public static void main(String[] a){
        Test test = new Test();
        int i = test.movingCount(15,20,20);
        System.out.println(i);
    }
}

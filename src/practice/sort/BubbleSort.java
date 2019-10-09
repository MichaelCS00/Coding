package practice.sort;

/**
 * @Classname BubbleSort
 * @Description 冒泡排序算法
 * @Description 冒泡排序需要多遍扫描，每次仅仅把当前最大的值放到其正确位置上
 * @Description 故需要扫描 n+ n-1 + n-2 + n-3 + ... + 1 约为 n^2 遍
 * @Date 10/8/2019 11:46 PM
 * @Created by MichaelCS
 */
public class BubbleSort {

    /**
     * <1>最基础的冒泡排序算法
     * 没有任何的改进
     * 时间复杂度为 O(n^2)
     * @param array
     */
    public static void sort_v1(int array[]){
        int times = 0;
        // 外层循环表示对整个待排序数组的多次扫描
        for(int i=0;i < array.length-1; i++){
            // 内层循环表示对每两个数之间的比较
            for(int j=0; j < array.length-i-1; j++){
                int tmp = 0;
                times++;
                // 发现逆序则交换
                if (array[j] > array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        System.out.println("sort1:"+times);
    }

    /**
     * <2>针对当序列已经有序时
     * 依然会重复遍历并判断的问题进行优化
     * 设置一个判断当前序列是否已经有序的标志
     * @param array
     */
    public static void sort_v2(int[] array){
        int times = 0;
        // 外层循环表示对整个待排序数组的多次扫描
        for(int i=0;i < array.length-1; i++){
            // 每一遍扫描开始时默认序列已经有序
            boolean sorted = true;
            // 内层循环表示对每两个数之间的比较
            for(int j=0; j < array.length-i-1; j++){
                int tmp = 0;
                times++;
                // 发现逆序则交换
                if (array[j] > array[j+1]) {
                    // 若发现逆序则说明序列无序
                    sorted = false;
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
            // 判断当前序列是否已经有序,有序则不再进行遍历
            if(sorted){
                break;
            }
        }
        System.out.println("sort2:"+times);
    }

    /**
     * <3>针对有序区可能大于遍历次数预期有序区长度问题
     * 为避免重复遍历需要记录最后一次发生交换的位置
     *
     * @param array
     */
    public static void sort_v3(int[] array){
        int times = 0;
        // 初始化边界
        int sortBorder = array.length-1;
        // 边界变量
        int tempSortBorder = sortBorder;
        for(int i=0; i<array.length-1; i++){
            boolean sorted = true;

            for(int j=0; j<sortBorder; j++){
                times++;
                if(array[j]>array[j+1]){
                    int tmp = 0;
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    sorted = false;
                    // 用于记录最后一次sortBorder更新
                    tempSortBorder = j;
                }
            }
            // 更新边界
            sortBorder = tempSortBorder;
            if(sorted){
                break;
            }
        }
        System.out.println("sort3:"+times);
    }

    public static void sort_v4(int array[]){
        int times = 0;
        for(int i=0; i<array.length-1; i++){
            boolean sorted = true;
            int sortBorder = array.length - 1;
            for(int j=0; j<sortBorder; j++){
                int tmp = 0;
                times++;
                if(array[j] > array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    sorted = false;
                    sortBorder = j;
                }
            }
            if(sorted)break;
        }
        System.out.println(times);
    }

    public static void main(String[] args){
        int[] array1 = {1,2,3,5,6,8,3,2};
        sort_v3(array1);
        for(int a : array1){
            System.out.println(a);
        }
    }
}

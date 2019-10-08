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
     * todo 待测试结果正确性
     * @param array
     */
    public static void sort_v1(int array[]){
        // 外层循环表示对整个待排序数组的多次扫描
        for(int i=0;i < array.length-1; i++){
            // 内层循环表示对每两个数之间的比较
            for(int j=0; j < array.length-i-1; j++){
                int tmp = 0;
                // 发现逆序则交换
                if (array[j] > array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }


}

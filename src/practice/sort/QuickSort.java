package practice.sort;

import java.util.Arrays;

/**
 * @Classname QuickSort
 * @Description 快速排序
 * @Date 10/10/2019 8:35 AM
 * @Created by MichaelCS
 */
public class QuickSort {
    /**
     * <1>用递归的方式实现快速排序
     * todo 代码测试未通过
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void sort_v1(int[] array, int startIndex, int endIndex){
        // 递归结束条件： startIndex >= endIndex
        if(startIndex >= endIndex){
            return;
        }
        int pivotIndex = partition(array, startIndex, endIndex);
        // 跟据基准元素，分成两部分进行递归排序
        sort_v1(array,startIndex,pivotIndex-1);
        sort_v1(array,pivotIndex+1,endIndex);
    }

    /**
     * <1>分治（双边循环法）
     * @param array         待交换数组
     * @param startIndex    起始下标
     * @param endIndex      结束下标
     * @return              更新后的 pivot下标
     */
    private static int partition(int[] array, int startIndex, int endIndex){
        // 取第一个位置(也可以随机选择位置)的元素作为基准元素
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;
        while( left != right){
            // 控制right指针比较并左移
            while(left<right && array[right]>pivot){
                right--;
            }
            // 控制left指针比较并右移
            while(left<right && array[left]<pivot){
                left++;
            }
            // 交换left和right指针所指向的元素
            if(left<right){
                int p = array[left];
                array[left] = array[right];
                array[right] = p;
            }
        }
        // pivot 和指针重合点交换
        array[startIndex] = array[left];
        array[left] = pivot;

        return left;
    }

    public static void main(String[] args){
        int[] array = {4,4,6,5,3,2,8,1};
        sort_v1(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}



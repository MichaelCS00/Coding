package practice.search;

/**
 * @Classname BinarySearch
 * @Description 简单的数组二分查找
 * @Date 9/7/2019 9:20 AM
 * @Created by MichaelCS
 */
public class BinarySearch {
    /**
     * 用于保存待查询数组
     */
    private int[] array;

    /**
     * 用于保存待查询对象
     */
    private int key;

    /**
     * 待判断区间头部指针
     */
    private int head;

    /**
     * 待判断区间中间指针
     */
    private int middle;

    /**
     * 待判断区间尾部指针
     */
    private int tail;

    /**
     * 结果
     */
    private int result;

    /**
     * 初始化数据
     *
     * @param array 待查找数组
     * @param key   待查找数据
     */
    public void init(int[] array, int key) {
        this.array = array;
        this.key = key;
        this.head = 0;
        this.result = -1;
        this.tail = array.length-1;
        this.middle = (head + tail) / 2;
    }

    /**
     * 用递归的方式查找key的下标
     *
     * @return key的下标，若返回-1则说明没有找到
     */
    public int findKeyInRecur() {

        if(key<array[head] || key>array[tail]){
            return result;
        }

        // 若key是 head middle tail 中的一个
        if (key == array[head]) {
            return head;
        } else if (key == array[middle]) {
            return middle;
        } else if (key == array[tail]) {
            return tail;
        }
        // 判断更新区间
        updateInterval();
        // 递归处理,未找到返回-1
        return findKeyInRecur();
    }

    public int findKeyInLoop() {

        if(key<array[head] || key>array[tail]){
            return result;
        }

        while(middle>=head && middle<=tail){
            // 若key是 head middle tail 中的一个
            if (key == array[head]) {
                result = head;
                break;
            } else if (key == array[middle]) {
                result = middle;
                break;
            } else if (key == array[tail]) {
                result = tail;
                break;
            }
            // 判断更新区间
            updateInterval();
        }
        return result;
    }

    /**
     * 更新区间
     */
    private void updateInterval(){
        // 若key在区间(head,middle)中
        if (key > array[head] && key < array[middle]) {
            tail = middle - 1;
            head++;
            middle = (head + tail) / 2;
        } else if (key > array[middle] && key < array[tail]) {
            // 若key在区间(middle,tail)中
            head = middle + 1;
            tail--;
        }
        middle = (head +tail)/2;
    }



}

class Test{
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,9,10};
        int key = 0;
        BinarySearch search = new BinarySearch();
        search.init(array,key);
//        int result = search.findKeyInRecur();
//        System.out.println(result);

        int result1 = search.findKeyInLoop();
        System.out.println(result1);
    }

}



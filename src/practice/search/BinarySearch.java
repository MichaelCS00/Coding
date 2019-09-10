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
    private Object[] array;

    /**
     * 用于保存待查询对象
     */
    private Object key;

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
     * 获取key的下标
     * @return key的下标
     */
    public int getKeyIndex(Object[] array, Object key){

        this.array = array;
        this.key = key;

        this.head = 0;
        this.tail = array.length;
        this.middle = (head+tail)/2;

        // todo 判断 key 所在的区间
        

        return 0;
    }

}

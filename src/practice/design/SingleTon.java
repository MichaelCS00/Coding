package practice.design;


/**
 * @Classname SingleTon
 * @Description TODO
 * @Date 12/1/2019 6:19 PM
 * @Created by MichaelCS
 */
public class SingleTon {

    // 提供实例
    private static SingleTon instance = null;
    // 显式申明私有化构造函数
    private SingleTon(){}
    // 提供实例获取方法
    static SingleTon getInstance(){
        if(instance == null){
            instance = new SingleTon();
        }
        return instance;
    }
}

class Main{
    public static void main(String[] args){
        SingleTon singleTon01 = SingleTon.getInstance();
        SingleTon singleTon02 = SingleTon.getInstance();
        System.out.println(singleTon01.equals(singleTon02));
    }
}



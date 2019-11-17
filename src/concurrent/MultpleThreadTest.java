package concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 儿子类，被打对象
 * @author MichaelCS
 */
class Son{
    /**
     * 初始生命值
     */
    private int healthPoints;

    /**
     * @Desc 创建具有一定生命值的儿子对象
     * @param healthPoints 大儿子时的力量
     */
    Son(int healthPoints){
        this.healthPoints = healthPoints;
    }

    /**
     * @Desc 获取当前血量
     * @return 返回血量
     */
    public void showPoints(){
        System.out.println("SonAlive_Health: "+this.healthPoints);
    }

    public int getPoints(){
        return this.healthPoints;
    }

    /**
     * @Desc 被打时自动扣生命值
     * @param decrement 生命值减少量
     */
    public void decrePoints(int decrement){
        // 控制healthPoint>=0
        if(!(this.healthPoints-decrement<0)){
            this.healthPoints -= decrement;
        }
    }
}


/**
 * @Desc 父母类
 * @author MichaelCS
 */
class Parent extends Thread{

    private static List<String> records;
    /**
     * 下手力度，扣血量
     */
    private int strength;

    /**
     * 儿子
     */
    private final Son son;

    /**
     * 父亲或母亲
     */
    private String parent;

    /**
     * @Desc 创建父母对象
     * @param strength 打儿子时的力量
     * @param son 儿子
     * @param parent 母亲或父亲
     */
    Parent(int strength,Son son,String parent){
        this.strength = strength;
        this.son = son;
        this.parent = parent;
    }

    public static void init(){
        records = new ArrayList<>();
    }

    public static List<String> getRecords(){
        return records;
    }

    /**
     * @Desc 打儿子
     */
    public void hitSon(){
        synchronized (this.son){
            int preHealth = this.son.getPoints();
            this.son.decrePoints(strength);
            String recode = String.format("%sHitSon: %s SonHealth %s DecreTo %s",this.parent,this.strength,preHealth,son.getPoints());
            // 记录家暴证据
            records.add(recode);
        }
    }


    @Override
    public void run() {
        while (this.son.getPoints()>0){
            hitSon();
            try{
                Thread.sleep(1);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}


/**
 * @Desc 家暴主类
 * @author MichaelCS
 */

class DomesticViolence{
    public static void main(String[] args){
        Son son = new Son(100);
        Parent.init();
        Parent mom = new Parent(2,son,"Mom");
        Thread dad = new Parent(3,son,"Dad");
        mom.start();
        dad.start();
        try {
            mom.join();
            dad.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(String record : Parent.getRecords()){
            System.out.println(record);
        }
    }
}

package practice.test;

import java.lang.reflect.Type;

/**
 * @Classname IntegerTestA
 * @Description TODO
 * @Date 10/31/2019 8:56 AM
 * @Created by MichaelCS
 */
public class IntegerTestA {
    static Integer[] integerArray = {0,0};

    StringBuffer stringBuffer = new StringBuffer();
    Integer integer = new Integer(100000000);
    Double aDouble = new Double(1000);

    public void changeArray(Integer[] integer){
        integer[0]++;
    }

    public void changeInteger(Integer integer){
        integer++;

        if(integer instanceof Integer){
            System.out.println("Integer");
        }
    }


    public void changeDouble(Double integer){
        integer++;

//        if(integer instanceof Integer){
//            System.out.println("Integer");
//        }
    }

    public void changeString(StringBuffer buffer){
        buffer.append("a");
    }
    public static void main(String[] args){
        IntegerTestA test = new IntegerTestA();
        test.changeInteger(test.integer);
        System.out.println(test.integer);

        test.changeDouble(test.aDouble);
        System.out.println(test.aDouble);

        test.changeArray(IntegerTestA.integerArray);
        System.out.println(IntegerTestA.integerArray[0]);

        test.changeString(test.stringBuffer);
        System.out.println(test.stringBuffer);
    }

}

package practice.test;

/**
 * @Classname TryCatch
 * @Description TODO
 * @Date 2019/9/26 14:29
 * @Created by MichaelCS
 */
public class TryCatch {
    public static void main(String[] args){
        test();
    }

    private static String test(){
        String str = null;
        try {
            System.out.println("try...");
            System.exit(0);//系统退出未执行到finally语句块
            return str;
        } finally {
            System.out.println("finally...");
        }
    }
}


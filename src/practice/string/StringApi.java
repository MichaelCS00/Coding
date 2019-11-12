package practice.string;

/**
 * @Classname StringApi
 * @Description 测试基本的String API
 * @Created by MichaelCS
 */
public class StringApi {

    /**
     * main函数中的 builder 会被改变
     * @param builder
     */
    private static void stringBuilderChangeTest(StringBuilder builder){
        builder.append("aba");
    }

    /**
     * main函数中的 string 不会改变
     * @param string
     */
    private static void stringChangeTest(String string){
        string = string + "ddd";
    }

    /**
     * main函数中的 builder 会被改变
     * @param buffer
     */
    private static void stringBufferChangeTest(StringBuffer buffer){
        buffer = new StringBuffer("aaa");
    }


    public static void main(String[] args){

        // 分别新建 String StringBuilder StringBuffer 对象
        String string = "baa";
        StringBuilder builder = new StringBuilder("baa");
        StringBuffer buffer = new StringBuffer("baa");

        // 尝试改变 builder
        stringBuilderChangeTest(builder);
        System.out.println(builder);

        // 尝试改变 string
        stringChangeTest(string);
        System.out.println(string);

        // 尝试改变 stringBuffer
        stringBufferChangeTest(buffer);
        System.out.println(buffer);
    }

}

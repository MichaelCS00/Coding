package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @Classname GetTest
 * @Description TODO
 * @Date 12/15/2018 6:49 PM
 * @Created by MichaelCS
 */

public class GetTest {
    public static String getFromServer(String url, String param){
        String result = "";
        String urlName = url + "?" + param;
        try {
            URL realUrl = new URL(urlName);
            URLConnection connection = realUrl.openConnection();
            // 设置连接参数
            connection.setRequestProperty("accept","*/*");
            connection.setRequestProperty("connection","Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0； Windows NT 5.1; SV1)");
            // 建立连接
            connection.connect();
            // 获取响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历响应头字段
            for (String key : map.keySet()){
                System.out.println(key + "  " + map.get(key));
            }
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream() , "utf-8")
            )){
                String line;
                while ((line = reader.readLine()) != null){
                    result += "\n" + line;
                }
            }
        }catch (Exception e){
            System.err.println("get请求异常"+e);
            e.printStackTrace();
        }
        return result;
    }
}

class Main{
    public static void main(String[] args){
        String result = GetTest.getFromServer("http://michaelcs.top:8080/server/test","bookId=1");
        System.out.println(result);
    }
}

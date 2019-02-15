package cn.zml.sanwei.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * 读取文件类
 * @author nanbei
 */
public class ReadFileUtil {

    /**
     * 返回文件中的内容
     */
    public static String readFileByLines(String fileName) {
        //文件内容
        StringBuffer content = new StringBuffer();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            //每一行的内容
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                content.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取文件错误");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    System.out.println("reader关闭失败");
                }
            }
        }
        return String.valueOf(content);
    }
}

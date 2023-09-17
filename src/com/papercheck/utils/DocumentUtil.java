package com.papercheck.utils;

import java.io.*;

// 文件工具类，进行文件的读取与写入
public class DocumentUtil {
        //将txt中的内容转化为String类型
        public static String input(File file){
            StringBuilder result = new StringBuilder();
            try{
                // BufferedReader类读取文件
                BufferedReader read = new BufferedReader(new FileReader(file));
                String s = null;
                while ((s = read.readLine())!= null){
                    result.append(System.lineSeparator() + s);
                }
                read.close();
            } catch (Exception e){
                e.printStackTrace();
            }
            return result.toString();
        }

        // 将结果输出到position所指定的位置
        public static void ouput(double result, String orig1, String orig2, String position){
            try{
                FileWriter wir = new FileWriter(position);
                PrintWriter out = new PrintWriter(wir, false);
                String output = String.format("%.2f", result);
                out.print("原文文件：" + orig1 + "\n");
                out.print("抄袭版论文文件：" + orig2 + "\n");
                out.print("查重结果为：" + output);
                wir.close();
                out.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
}

package com.papercheck.main;

import com.papercheck.utils.CuttingWordsUtil;
import com.papercheck.utils.DocumentUtil;
import com.papercheck.utils.SimpleCommonWords;
import org.apdplat.word.segmentation.Word;
import java.io.File;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 输入txt文件并对其进行分词
        List<Word> txt1 = CuttingWordsUtil.cuttingWords(new File(args[0]));
        List<Word> txt2 = CuttingWordsUtil.cuttingWords(new File(args[1]));

        // 如果都为空则输出提示信息并结束程序
        if(txt1.isEmpty() && txt2.isEmpty()){
            System.out.println("错误，文件为空");
            System.exit(0);
        }

        // 调用SimpleCommonWords类中的简单共有词算法进行相似度计算
        double result = SimpleCommonWords.similarityCalculate(txt1, txt2);

        // 输出结果到指定文件中
        DocumentUtil.ouput(result, args[0], args[1], args[2]);
        System.out.println("------------------------");
        System.out.println("结果文件路径：" + args[2]);

        System.exit(0);
    }
}

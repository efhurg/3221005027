package com.papercheck.test;

import com.papercheck.main.Application;
import com.papercheck.utils.CuttingWordsUtil;
import com.papercheck.utils.SimpleCommonWords;
import org.apdplat.word.segmentation.Word;
import org.junit.Test;

import java.util.List;

// 测试类
public class TestCoverage {
    @Test
    public void TestApplicaiton(){
        long start = System.currentTimeMillis();
        Application.main(new String[]{"D:\\软件工程\\orig.txt", "D:\\软件工程\\orig_0.8_add.txt", "D:\\软件工程\\result.txt"});
        System.out.println("耗时：" +(System.currentTimeMillis() - start) + "毫秒");
    }

    @Test
    public void testCuttingWordsUtil(){
        // 测试正常情况下分词
        List<Word> string1 = CuttingWordsUtil.cuttingWords("我读过那么多故事，其中乏味的多得是。");
        // 测试完全倒序情况下分词
        List<Word> string2 = CuttingWordsUtil.cuttingWords("是得多的味乏中其，事故多么那过读我。");
        // 测试字符串中加入乱码情况下分词
        List<Word> string3 = CuttingWordsUtil.cuttingWords("我#！·~读过那%&&么多故事，其中乏味*（的多得&+=%是。");
        // 测试字符串中有空格情况下分词
        List<Word> string4 = CuttingWordsUtil.cuttingWords("我读     过那么 多故事， 其中乏味的    多得  是。");
        // 测试空串情况下的分词
        List<Word> string5 = CuttingWordsUtil.cuttingWords("");

        System.out.println("String1:" + string1);
        System.out.println("String2:" + string2);
        System.out.println("String3:" + string3);
        System.out.println("String4:" + string4);
        System.out.println("String4:" + string5);
    }

    @Test
    public void testSimpleCommonWords(){
        // 测试字符串完全相同时
        List<Word> test1 = CuttingWordsUtil.cuttingWords("我读过那么多故事，其中乏味的多得是。");
        List<Word> test2 = CuttingWordsUtil.cuttingWords("我读过那么多故事，其中乏味的多得是。");
        double result1 = SimpleCommonWords.similarityCalculate(test1, test2);
        // 测试字符串互为倒序时
        List<Word> test3 = CuttingWordsUtil.cuttingWords("我读过那么多故事，其中乏味的多得是。");
        List<Word> test4 = CuttingWordsUtil.cuttingWords("是得多的味乏中其，事故多么那过读我。");
        double result2 = SimpleCommonWords.similarityCalculate(test3, test4);
        // 测试字符串添加符号时
        List<Word> test5 = CuttingWordsUtil.cuttingWords("我读过那么多故事，其中乏味的多得是。");
        List<Word> test6 = CuttingWordsUtil.cuttingWords("我读#￥过那么多……故事，其中乏味@！的多得+-是。");
        double result3 = SimpleCommonWords.similarityCalculate(test5, test6);
        // 测试字符串部分改动时
        List<Word> test7 = CuttingWordsUtil.cuttingWords("我读过那么多故事，其中乏味的多得是。");
        List<Word> test8 = CuttingWordsUtil.cuttingWords("我看过这么多故事，其中没意思的有很多。");
        double result4 = SimpleCommonWords.similarityCalculate(test7, test8);
        // 测试字符串出现生僻字时
        List<Word> test9 = CuttingWordsUtil.cuttingWords("我读过那么多故事，其中乏味的多得是。");
        List<Word> test10 = CuttingWordsUtil.cuttingWords("我读过誽么多臌事，其中乏味嘚多得逝。");
        double result5 = SimpleCommonWords.similarityCalculate(test9, test10);
        // 测试字符串是空串时
        List<Word> test11 = CuttingWordsUtil.cuttingWords("");
        List<Word> test12 = CuttingWordsUtil.cuttingWords("");
        double result6 = SimpleCommonWords.similarityCalculate(test11, test12);
        // 测试字符串部分缺失时
        List<Word> test13 = CuttingWordsUtil.cuttingWords("我读过那么多故事，其中乏味的多得是。");
        List<Word> test14 = CuttingWordsUtil.cuttingWords("我读那么多事，其味的得是。");
        double result7 = SimpleCommonWords.similarityCalculate(test13, test14);

        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
        System.out.println("result3: " + result3);
        System.out.println("result4: " + result4);
        System.out.println("result5: " + result5);
        System.out.println("result6: " + result6);
        System.out.println("result7: " + result7);
    }
}

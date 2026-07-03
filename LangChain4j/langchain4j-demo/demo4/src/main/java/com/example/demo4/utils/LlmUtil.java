package com.example.demo4.utils;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;

//提供给大模型的工具类
public class LlmUtil {
    @Tool(value = "计算两浮点数之和")
    public static double add(@P("加数1") double n1, @P("加数2") double n2) {
        return n1 + n2;
    }

    @Tool(value = "计算浮点数的平方根")
    public static double sqrt(double n) {
        return Math.sqrt(n);
    }
}

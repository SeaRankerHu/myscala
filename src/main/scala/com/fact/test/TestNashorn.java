package com.fact.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Nashorn 新的javascript解析引擎
 */
public class TestNashorn {

    public static void main(String[] args){
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine nashorn = sem.getEngineByName("nashorn");
        String str = "var a =10; a + 10";
        try {
            Object result = nashorn.eval(str);
            System.out.println(result.toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        }

    }
}

package com.fact.test;


import scala.Int;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestLambda {
    //lambda表达式，只允许声明一个接口方法
    interface MathOperation{
        int operation(int a, int b);
    }

    interface MyGreeter{
        void greet(String message);

        //接口可以定义实现方法
        default void mydefault(){
            System.out.println("======mydefault=======");
        }
    }

    interface Converter<T, V>{
        V convert(T num);
    }

    static class DefinedGreeter implements MyGreeter{
        @Override
        public void greet(String message) {
            System.out.println("my defined " + message);
        }
    }

    public static void main(String[] args){
        //带参数类型，不带大括号及返回语句
        MathOperation myadd = (int a, int b) -> a + b;
        //不带参数类型，不带大括号及返回语句
        MathOperation mysub = (a, b) -> a - b;
        //带大括号
        MathOperation mymuti = (int a, int b) -> {return a * b;};


        System.out.println("=======add=====" + TestLambda.operate(3, 4, myadd));
        System.out.println("=======sub=====" + TestLambda.operate(3, 4, mysub));
        System.out.println("=======muti=====" + TestLambda.operate(3, 4, mymuti));

        //参数不带括号
        MyGreeter greet1 = message -> System.out.println("hello  "+message);
        //参数带括号
        MyGreeter greet2 = (message) -> System.out.println("say " + message);
        greet1.greet("pig");
        greet2.greet("good bye");

        //调用默认方法
        greet2.mydefault();

        final int myNum = 100;
        //int num = 22; //不允许声明与lambda表达式一样的变量
        Converter<Integer, String> converter = num -> String.valueOf(myNum + num);
        System.out.println(converter.convert(22));

        MyGreeter gg = new DefinedGreeter();
        gg.mydefault();
        gg.greet("w2wwwww");

        List<String> list = Arrays.asList("3", "aa", "bb");
        list.forEach(n -> System.out.println("list:"+n));

        //方法引用
        TestLambda.gret(gg::greet);

        //stream
        list = list.stream().filter(n -> !n.equals("3")).sorted((n1, n2) -> n1.equals(n2)? 0 : 1).collect(Collectors.toList());
        list.forEach(n -> System.out.println("strem List: "+n));

        //optional 测试
        Integer ix = null;
        Integer iy = 10;
        System.out.println("x+Y="+sum(Optional.ofNullable(ix), Optional.of(iy)));
    }

    public static int sum(Optional<Integer> a, Optional<Integer> b){
        //如果a为空，则返回默认值
        Integer x = a.orElse(new Integer(0));
        Integer y = b.get();
        return x + y;
    }

    private static int operate(int a, int b, final MathOperation mo){
        return mo.operation(a, b);
    }

    public static void gret(final MyGreeter g){
        g.greet("222222222222");
    }
}

package com.fact.test;

import java.time.LocalDateTime;
import java.util.Base64;

public class TestTime {
    public static void main(String[] args){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("LocalDate:"+ldt.toLocalDate());
        System.out.println("Month:"+ldt.getMonth());
        System.out.println("year:"+ldt.getYear());

        String str = new String(Base64.getEncoder().encode("我是中国认证".getBytes()));
        System.out.println(str);

        B b = new B();
        System.out.println(b.getName());
    }

    static abstract class A {
        protected String name = "AAA";

        public abstract String getName(String obj);
    }

    static class B extends A{
        private String name = "BB";
        public String getName(){
            return this.name;
        }

        @Override
        public String getName(String obj) {
            return null;
        }
    }
}

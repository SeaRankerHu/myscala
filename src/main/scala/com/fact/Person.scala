package com.fact

class Person {
//  private var name : String = null;
//  private var age : Int  = null;
//  private var described : String  = null;

    private def myfunc(){ println("2222222222");};

    protected def p(){println("this is a function")}

    def pp(){println("this is public")}
    class child{
      myfunc();
      p();
    }
}

class Child1 extends Person{
    p();
}

class other{
  (new Person).pp();
}
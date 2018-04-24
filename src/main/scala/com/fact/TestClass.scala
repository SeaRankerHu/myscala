package com.fact

import com.fact.aa.ATest
import com.fact.aa.bb.BTest

object TestClass {

  def main(args: Array[String]): Unit = {

    var person = new Person();
    person.pp();

    var at = new ATest();
    var bt = new BTest();

    at.mymethod();
    //bt.sayhello();
    bt.sayhello1();
    at.bt.sayhello1();
    var gr = new Greeter("my ", "hadoop")
    gr.greet("tom")
    println(gr);

    //case 类
    var pa = new Point(1, 1);
    var pb = Point(2, 2);
    var pc = new Point(1, 1);
    //可直接比较
    if(pa == pc){
      println("pa equals pc");
    }

    println(IdFactory.create());

    var dp = new DefaultParent();
    dp.greet("scala")
    var cp = new CustomizableParent("boy", 18);
    cp.greet("scala1");
    println(cp);

    Greeter.greet();
  }
}

case class Point(x: Int, y: Int)
//类似静态类，可以直接访问方法
object IdFactory {
  private var counter = 0
  def create(): Int = {
    counter += 1
    counter
  }
}
//抽象类可以被继承，方法可以被覆盖
class DefaultParent extends Parent;
//覆盖抽象类方法
class CustomizableParent(sex : String, age : Int) extends Parent{
  override def greet(name: String): Unit = {
    if(sex == "boy"){
      println("man: hello " + name + ", you are "+age)
    }else{
      println("woman: hello " + name + ", you are "+age)
    }
  }
}
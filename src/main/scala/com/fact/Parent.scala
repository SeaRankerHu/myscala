package com.fact

//抽象类
trait Parent {
  def greet(name : String) : Unit = {
    println("hello " + name + "!");
  }

  //可定义抽象方法
  //def kissChild(name : String) : Unit;

  override def toString: String = {
    return "parent"
  }
}

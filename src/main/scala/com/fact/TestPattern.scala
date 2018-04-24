package com.fact

import scala.util.matching.Regex

object TestPattern {
  def main(args: Array[String]): Unit = {
    test1()
    test2()
    try{
      testexp()
    }catch{
      case ex : IllegalArgumentException => {
        println("====ILLEGAL======"+ex.getMessage);
      }
      case ex : IndexOutOfBoundsException => {
        println("====IO");
      }
    }

  }

  def test1() : Unit = {
    //调用字符串的r函数
    var pattern = "Scala".r
    var str : String = "hello, Scala is my test"
    println(pattern.findFirstIn(str))
  }

  def test2() : Unit = {
    var pattern = new Regex("(S|s)cala");
    var str = "hello, Sc1ala is a scala"
    //查找
    println(pattern.findFirstIn(str));
    //替换所有
    println(pattern.replaceAllIn(str, "java"))
  }

  def testexp() : Unit = {
    var a = 2
    if(a > 1){
      throw new IllegalArgumentException("22222222")
    }
    println(a);
  }
}

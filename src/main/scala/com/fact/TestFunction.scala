package com.fact

object TestFunction {
  def main(args: Array[String]): Unit = {

    //匿名函数
    val addOne = (x : Int) => x + 1;
    println(addOne(1));
    //两个参数
    val add = (x : Int, y : Int) => x + y;
    println(add(3, 5));
    //无参数
    val getDefault = () => 55;
    println(getDefault());

    //闭包函数
    var pp = 22;
    var multi = (x : Int) => x * pp;

    println("multi:"+multi(1));
    pp = 20;
    println("multi:"+multi(1));
    println( TestMethod.add(3, 6));
    println(TestMethod.addmulti(2, 3)(4));
    println(TestMethod.getNewName("free"));
    println(TestMethod.getNoting());


  }

}

object TestMethod{
  //定义方法
  def add(x : Int, y : Int): Int = x + y;
  //多个参数列表
  def addmulti(x : Int, y : Int)(z : Int) : Int = (x + y) * z;

  def getNewName(oldName : String) : String = {
var newName : String = oldName.toUpperCase();
    //    return newName + "_new";
    //不用return也能返回值
    newName + "_new";
  }
  //unit类似void，表示无返回值
  def getNoting(): Unit ={
    println( "33333333333")
    //不能返回
    //return "tt";
  }
}
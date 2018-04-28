package com.fact

import java.util



//package com.fact.my{
//  class Myclass{
//
//  }
//}

object HelloWorld {
  /**
    * 这是我的第一个程序
    * @param args
    */
  def main( args: Array[String] ){
    println("hello world!!!!!!!!!!");
    var dd = 22;
	
	println("=======hello world=========")
	println("=======hello world=========")
  }
  //println(dd + 33);
  var ss = "2222";
  myMethod();


  def myMethod(): Unit ={
    println("wwwwwwwwww");
  }

  import java.util.ArrayList
  //多个引入，重命令
  import java.util.{ArrayList, HashMap => JavaHashMap}
  import java.util._
  // 隐藏成员
  import java.util.{HashMap => _, _} // 引入了util包的所有成员，但是HashMap被隐藏了

  def handler(evt : util.HashMap[String, String]): Unit ={
    evt.put("11","222")
  }
  
  


}

package com.fact

import java.io.FileInputStream

import scala.io.{Source, StdIn}

object TestStream {
  def main(args: Array[String]): Unit = {
//    print("pleas enter:")
//    val line = StdIn.readLine();
//    println("谢谢，你输入的是: " + line)


//    var fis = new FileInputStream("C:\\HPE Work\\2.工作\\公司地址.txt")
//    var buffer = new Array[Byte](1024)
//
//    var len = fis.read(buffer)
//    while(len > 0){
//      println(new String(buffer, "GBK"))
//      len = fis.read(buffer)
//    }
//    Source.fromFile("C:\\HPE Work\\2.工作\\公司地址.txt", "GBK").foreach{
//      print
//    }

    val list = Source.fromFile("C:\\HPE Work\\电脑硬件信息.txt").getLines().toList
//    list.foreach(println)
    //获取长度最大的一行
    val maxLine = list.reduceLeft((a, b) => {if(a.length > b.length) a else b})
//    val maxLine = list.reduceLeft((a, b) => if(a.length > b.length) a else b)
    println(maxLine)

  }
}

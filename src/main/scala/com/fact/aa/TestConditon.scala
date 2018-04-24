package com.fact.aa

object TestConditon {
  def main(args: Array[String]): Unit = {
    var str1 : String = "aaa";
    var str2 : String = "bbbbbbbb";
    str2 += "oooooo";
    println(str1 + str2);

    var a,b = "test";
    if(a.equals(b)){
      println("this is equal");
    }
    if(a == b){
      println("this is equal");
    }

    var i = 0;
    for(i <- 1 to 10){
      println("this is "+i);
    }
    //数组
    val numList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    for(i <- numList){
      println("numList " + i);
    }

    //另外一种循环,返回满足条件的集合
    var retVal = for{i <- numList
                     if(i > 2); if(i < 5)
    } yield i;
    for(i <- retVal){
      println("retVal " + i);
    }
  }
}

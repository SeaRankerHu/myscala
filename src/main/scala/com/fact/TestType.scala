package com.fact


object TestType {
  def main(args: Array[String]): Unit = {
//    var iData = 0xFFFFFFFF
//    println(iData)
//    var bValue = true;
//    println(bValue)
//    var c1 = 'a';
//    var str1 = "hello\nworld";
//    println(c1);println(str1);

    var str2 =
      """helowe
        dfsfds
        sdfsdf
      """;
    println(str2);

    var str3 = null;
    println(str3);

    //常量
    val C_AA : String = "AMD";
    //变量
    var a1 : String = "my string";

    a1 = "33";

    var iVar : Int = 22;
    var u,v = 9;
    var x,y = (22, "333");
    var (c1 : Int, c2 : String) = (3, "33");
    println(x);
    println(y);

    //blocks
    println({var x = 1+ 1; x+3});

    println("length:"+a1.length);

    var arr1 = new Array[String](3);
    arr1(0) = "222";
    arr1(1) = "33";
    arr1(2) = "yyyyyy";

    var arr2 = Array(1, 3, 4);

    var arrs = Array.ofDim[Int](2, 3);
    arrs(0)(0) = 1;
    arrs(0)(1) = 1;
    arrs(0)(2) = 1;
    for(i <- 0 to arrs.length - 1){
      for(j <- 0 to arrs(i).length - 1){
        println(i + ","+j+":"+arrs(i)(j))
      }
    }
    var list1 : List[Int] = List(0);
    list1 = 88 +: list1; //向list添加元素
    list1 = 11 :: list1; //向list开头添加元素
    list1 = list1 :+ 33; //list添加元素
    println(list1);

    var set1 : Set[Int] = Set(22,33);
    set1 = set1 + 88; //添加元素
    set1 = set1 - 33; //删除元素
    println(set1);

    var map1 : Map[String, Int] = Map("red" -> 11, "yellow" -> 22);
    map1 += ("blue" -> 33);//添加键值对
    map1.keys.foreach{
      key =>
        print("key:" + key)
        println(" value:" + map1(key))
    }

    val sites = Map("runoob" -> "www.runoob.com", "google" -> "www.google.com")

    println("sites.get( \"runoob\" ) : " +  sites.get( "runoob" )) // Some(www.runoob.com)
    println("sites.get( \"baidu\" ) : " +  sites.get( "baidu" ))  //  None
    var it = sites.iterator;
    while(it.hasNext){
      println(it.next());
    }
    //迭代器
    var ita = Iterator(2,3,45,634,53,83,23);
    while(ita.hasNext){
      println(ita.next());
    }
  }
}

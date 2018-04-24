package com.fact

import spire.math.Rational


object Test {
  def main(args: Array[String]): Unit = {
    var t1 = new TT()
    t1 = 33 :: t1
    t1 = 5 :: 3 :: t1
    println("t1 : " + t1.getX())
    //调用update方法
    t1(1) = 1000
    println("update : "+t1.getX())

    println("apply: "+ TT(22).getX())

    var list: List[Int] = Nil
    list = 33 +: list
    list = 22 :: list
    list = 11 :: list
    println(list)

    //并行运行
    val result = list.par.reduce(_ + _)
    println("result : " + result)

    //for循环枚举
    for(vv <- list if(vv > 1); if(vv < 100); if(vv % 3 == 0)){
      println("satisfy condition list : "+vv)
    }
    //嵌套枚举
    for(vv <- list if(vv > 20); line <- vv.toString.toCharArray if(line.toInt % 2 == 0))
     println("nest:"+ line)

    //创建集合
    val list1 = for(vv <- list if(vv > 20); line <- vv.toString.toCharArray if(line.toInt % 2 == 0)) yield line
    println("list1 : " + list1.mkString(","))

    //过滤
    val list2 = list.filter(_ % 3 == 0)
    println("filter list2 : " + list2.mkString(","))
    //拆成两个list
    val list3 = list.partition(_ % 3 == 0)
    println("partition list3 : " + list3)
    //返回一个数组，会自动合并数组的数据
    val list4 = list.flatMap(elem => List(elem, elem+1))
    println("list4: "+ list4.mkString(","))

    var list5 : List[Any] = list
    list5 = "ww" :: list5
    println("list5 : " + list5.mkString(","))


    var arr = new Array[Int](30)
    arr(0) = 22
    arr(1) = 333
    println(arr.mkString(","))

    //scala的所有对象都有一个 -> 方法
//    println(t1.->(33))
    println(t1 -> 33)

    //打印n个字符串
    println("a" * 3)

    //scala没有操作符，所有操作符都是普通方法调用的另外一种形式
    val a = 2; val b = 3
    println("a.+(b)=" + a.+(b))
    println("a+b="+a+b)
    var c : String = null
//    c = "cc"
    if(c == null) println("is null")

    //字面量
    val mysymbol : Symbol = 'mysss
    println(mysymbol.name)

    //有理数
    val ra1 = Rational(4, 3)
    val ra2 = Rational(1, 9)
    println("rational : " + (ra1 + ra2))

    val ii = 222
    println(ii.toDouble / 3)

    //判断是否为double
    val bb = ii.isInstanceOf[Double]
    println("isInstanceOf ii= "+ bb)
    //类型强制转换
    val dd : Double = ii.asInstanceOf[Double]
    println("asInstanceOf  dd = " + dd)
    //获取class
    println(dd.getClass)
  }

  def hello(){
    println("==========")
  }
}
object TT{
  def apply(x : Int) : TT = {
    val tt = new TT()
    tt._x = x
    tt
  }
}
class TT {
  val PI = 3.14
  private var _x = 0

  //自定义右运算符
  def ::(a: Int): TT = {
    val gg = new TT()
    gg._x = _x + a
    return gg
  }

  def getX() : Int = this._x

  def update(flag : Int, x : Int) : Unit = {
    this._x = x
  }
}
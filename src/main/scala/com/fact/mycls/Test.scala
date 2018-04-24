package com.fact.mycls

object Test {

  def main(args: Array[String]): Unit = {
    val mr1 = new MyRational(2, 3)
    val mr2 = new MyRational(3)
    val mr3 = new MyRational(1, 7)

    println(mr1 + mr3)
    println(mr1 - mr3)
    println(mr1 * mr3)
    println(mr1 / mr3)

    println(mr1 + 2)
    println(mr1 - 2)
    println(mr1 * 2)
    println(mr1 / 2)

//    import com.fact.mycls.MyRational
    //隐式转换
    println(1 + mr3)
    println(1 - mr3)
    println(1 * mr3)
    println(1 / mr3)
//
//    val so = new SimpleO()
//    so.name = "pig"
//    so.sex = "male"
//    print(so.name)

    //使用double到int的隐式转换
    import CoImplicit.double2Int
    val iLenth : Int = 3.5
    println("length : " + iLenth)

    //隐式参数，可以显示提供
    testImplicit(3)(1, "self")

    //隐式参数，可以隐式提供
    import CoImplicit._
    testImplicit(4)
  }

  //带有隐式参数的方法

  def testImplicit(x : Int)(implicit a : Int, b : String): Unit ={
    println("testImplicit : "+ x + a + b)
  }
}

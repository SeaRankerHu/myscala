package com.fact

object TestApply{
  def main(args: Array[String]): Unit = {
    //apply调用
    var x = TestApply(22);
    println("================");
    println(x);
    x match{
        //unapply被调用
      case TestApply(num) => println(x + "是" + num +"的两倍");
      case _ => println("other");
    }

    x = 30
  }

  def apply(x : Int) = {
    println("apply" + x);

     x * 2;
  }

  def unapply(z : Int) : Option[Int] = {
    println("unapply");
    if(z % 2 == 0) Some(z / 2)
    else None
  }
}

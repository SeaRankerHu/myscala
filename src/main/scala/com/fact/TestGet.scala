package com.fact

object TestGet {

  def main(args: Array[String]): Unit = {
    var p1 = new Point1();
    p1.x = 22;
    var g1 = new Greeter1();
    g1.x = 33;
    println(g1.x);
    g1 = 7 :: g1
    println(g1.x)
  }
}

class Greeter1{
  private var _x = 0

  //类似set和get函数
  def x = _x
  def x_= (newValue : Int): Unit = {
    _x = newValue
    println("----------set---------")
  }

  def ::(a : Int) : Greeter1 = {
    val gg = new Greeter1()
      gg._x = _x + a
    return gg
  }
}

class Point1 (val a : Int = 0, val b : Int = 0){
  private var _x = 0
  private var _y = 0
  private val bound = 100

  def x = _x
  def x_= (newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning
  }

  def y = _y
  def y_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }

  private def printWarning = println("WARNING: Out of bounds")
}
package com.fact

//构造函数
class Greeter(prefix: String = "prefix", suffix: String = "suffix") {
  private var _prefilx = prefix
  private var _xx = 0;
  //Unit表示无返回值,等同于void
  def greet(name: String): Unit =
    println(prefix + name + suffix)

  //类型java的toString方法
  override def toString: String = {
    return "toString:"+prefix+"__"+suffix;
  }

  def xx = _xx;
  def xx_(newValue : Int): Unit ={
    _xx = newValue
    println("----------set---------")
  }
}

//伴生对象，对象名称和类名相同，同在一个文件中，可以直接访问类中的成员
object Greeter{
  private val gg : Greeter = new Greeter("companision:");
  //指定构造参数
  private val gg1 : Greeter = new Greeter(suffix = ".java");
  def greet() : Unit = {
    //访问私有属性
    println("private attribute:" + gg._prefilx);

    //访问类方法
    gg.greet(" is static ")
  }
}
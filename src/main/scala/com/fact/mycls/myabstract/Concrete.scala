package com.fact.mycls.myabstract

//抽象对象的实现
class Concrete extends AbstractCls {
  override type T = String

  override def transform(x: String) = x + x

//  override val inital = "hi"
  //也可以为无参方法
  override val inital : String = "hi" + Math.random()

  override var current = inital

  //类似Invariant的泛型
  override type SuitElement = MyElement

//  override def convert(myElement: MyElement) = new MyElement(myElement.name + " convert")
}

class CurElement(name :String) extends MyElement(name)
object Concrete{
  def main(args: Array[String]): Unit = {
    val con = new Concrete()

    println(con.convert(new MyElement("pig")).name)

    val pCls   = new Concrete()
    println(pCls.convert(new MyElement("pig")).name)
    println(pCls.convert(new pCls.SuitElement("wwwwww")).name)
    println(pCls.convert(new CurElement("cur ")).name)


  }
}
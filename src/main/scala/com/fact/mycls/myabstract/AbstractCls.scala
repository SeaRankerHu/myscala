package com.fact.mycls.myabstract

/**
  * 抽象成员
  */
trait AbstractCls {
  //类型
  type T
  //方法
  def transform(x : T) : T
  //常量
  val inital : T
  //变量
  var current : T
  //非抽象成员
  val ss : String = "hello"
  //定义元素为Element的子类
  type SuitElement <: Element

  def convert(myElement : SuitElement) : SuitElement = {
    println(myElement.name + " convert")

    myElement
  }
}

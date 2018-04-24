package com.fact.mytrait

/**
  * 接口
  * @tparam T 泛型
  */
trait Animal[T] {
  //接口方法, T为U下界,U是T的超类
  def eat[U >: T](food : U) : Unit;

  //接口方法, T为U上界,U是T的子类
  def hello[U <: T](food : U) : Unit

  def atack(role : String) : T;

  def getName() : String

}

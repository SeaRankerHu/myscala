package com.fact.mytrait

//带两个参数的构造方法
class Dog private(name : String, age : Int) extends Action with Animal[String]{

  //字段覆盖方法
  val getName = name + " dog"

  //辅助构造器
  def this(name : String) = this(name, 11)
  override def eat[U >: String](food: U): Unit = {
    println(this.name + " eat " + food)
  }

  override def hello[U <: String](food : U) : Unit = {
    println("hello " + food)
  }

  override def atack(role: String): String = {
    return this.age + " = " + role
  }

  override def doSleep(): Unit = println("dog " + this.name + " sleep")
}

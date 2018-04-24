package com.fact.mytrait

/**
  * 接口实现
  * @param name
  */
class Cat(name : String) extends Action with Animal[String] {
  override def eat[U >: String](food: U): Unit = {
    println(food + " is good, I have eat it")
  }

  override def hello[U <: String](food : U) : Unit = {
    println("hello " + food)
  }

  override def atack(role: String): String = {
    if(role == "fish")
      return "good"
    else
      return "bad"
  }

  override def getName(): String = "tom cat"

  override def doSleep(): Unit = println(this.name + " sleep")
}

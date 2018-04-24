package com.fact.mytrait

//特征堆叠
class Pig extends Action{
  private[this] val name = "pig"
  override def doSleep(): Unit = {
    println("pig sleep !!!" + this.name)
  }
}

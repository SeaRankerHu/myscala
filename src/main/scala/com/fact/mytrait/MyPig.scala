package com.fact.mytrait

/**
  * 混入特征
  */
class MyPig extends Pig with BeforeAction with AfterAction {
  private[this] val pig = "my pig"
//  //覆盖所有特征
//  override def doSleep(): Unit = {
//    println("0000000000000000" + this.pig)
//  }
}

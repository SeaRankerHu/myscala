package com.fact.mytrait


trait BeforeAction extends Action{

  //特征堆叠
  abstract override def doSleep(): Unit = {
    println("========= watch TV ============")
    super.doSleep()
  }
}

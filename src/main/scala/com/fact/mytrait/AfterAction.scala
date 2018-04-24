package com.fact.mytrait

trait AfterAction extends Action{
  //特征堆叠
  abstract override def doSleep(): Unit = {
    super.doSleep()
    println(" HU HU HU HU !!!!!")
  }
}

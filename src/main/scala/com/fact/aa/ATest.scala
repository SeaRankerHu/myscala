package com.fact.aa

import com.fact.aa.bb.BTest

class ATest {
  private[fact] var bt = new BTest();
  def mymethod(): Unit ={
    bt.sayhello();
  }
  //函数定义
  val addOne = (x: Int) => x + 1;

}

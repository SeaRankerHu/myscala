package com.fact

import com.fact.aa.ATest
import com.fact.aa.bb.BTest;
class MyTest {

  private var at = new ATest;
  private var bt = new BTest();

  def mymethod(): Unit ={
    at.mymethod();
    bt.sayhello1();
  }
}

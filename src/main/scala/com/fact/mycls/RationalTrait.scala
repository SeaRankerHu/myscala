package com.fact.mycls

trait RationalTrait {
  protected val myval : Int

  //会先于类调用
  require(myval != 0)
}

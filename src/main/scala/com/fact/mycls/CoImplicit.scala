package com.fact.mycls

object CoImplicit {

  //隐式方法
  implicit def double2Int(d : Double) : Int = d.toInt

  //隐式值
  implicit val width : Int = 100

  implicit val name : String = "pig"
}

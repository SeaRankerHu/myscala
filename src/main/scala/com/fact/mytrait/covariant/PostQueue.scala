package com.fact.mytrait.covariant

trait PostQueue[+T] {

  //下界
  def enqueue[U >: T](value : U) : Unit

  def outqueue() : T
}

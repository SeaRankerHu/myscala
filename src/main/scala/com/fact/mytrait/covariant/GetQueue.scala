package com.fact.mytrait.covariant

trait GetQueue[-T] {
  val ss : String

  def enqueue(value : T) : Unit
  //上界，T是U的上界, U是T的子类
  def outqueue[U <: T]() : U


}

package com.fact.mytrait.covariant

import scala.reflect.ClassTag

class MyArray[T : ClassTag](length : Int) {
  val array = new Array[T](length)

  def set(index : Int, elem : T): Unit ={
    array(index) = elem
  }

  def get(index : Int) : T = {
    array(index)
  }

}

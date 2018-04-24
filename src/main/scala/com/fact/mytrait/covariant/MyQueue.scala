package com.fact.mytrait.covariant

import scala.reflect.ClassTag

sealed class MyQueue[+T : ClassTag]  extends PostQueue[T] {
  private[this] var q : List[T] = Nil

  override def enqueue[U >: T](value: U): Unit = {
    val qq = value :: this.q

    //我们把classOf[T]看成Java里的T.class, obj.isInstanceOf[T]看成 obj instanceof T,
    // obj.asInstanceOf[T]看成(T)obj就对了。scala为我们提供了语法糖
    if(value.isInstanceOf[T]){
//      println(classOf[T])
//      println(classOf[List[T]])
      println(value.getClass +" " + value.asInstanceOf[T])
      //类型强制转换
      this.q = value.asInstanceOf[T] :: this.q
    }
  }
  def foo[T](x: List[T])(implicit m: Manifest[T]) = {
    if (m <:< manifest[String])
      println("Hey, this list is full of strings")
    else
      println("Non-stringy list")
  }

  override def outqueue(): T = this.q.head

  override def toString: String = this.q.toString()
}

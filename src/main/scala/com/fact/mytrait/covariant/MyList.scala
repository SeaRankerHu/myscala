package com.fact.mytrait.covariant

import com.fact.mytrait.Animal

class MyList[+T](val head: T, val tail: MyList[T]) {
  //将函数也用泛型表示
  //因为是协变的，输入的类型必须是T的超类
  def prepend[U>:T](newHead:U) : MyList[U]=new MyList(newHead,this)

  override def toString()=""+head
}

object MyList{
  def showList(p : MyList[_ <: String]) : Unit = {
    p.prepend(11)
   println(p.head)
  }

  def showList1[U <: String](p : MyList[U]): Unit ={
    println(p.head)
  }
}

package com.fact.mytrait.covariant

object Test {

  def main(args: Array[String]): Unit = {
    val mq = new MyQueue[String]()
    mq.enqueue("www")
    mq.enqueue("1111")
    mq.enqueue(11.233)
//    println(mq.outqueue())
    println(mq)
    //获取U的class类型
    println(Predef.classOf[String])

    val mq1 = new MyQueue[Int]()
    mq1.enqueue("www")
    mq1.enqueue(333)
    println(mq1)

    val mq2 = new MyQueue[Publication]()
    mq2.enqueue("www")
    mq2.enqueue(333)
    println(mq2)


//    println("www".asInstanceOf[Int])

    val list1 = new MyList[String]("www", null)
    val list2 = list1.prepend(mq1)
    println(list2.head + "  " + list2.tail)
    MyList.showList(list1)
    MyList.showList1(list1)

    val ma = new MyArray[Int](10)
    ma.set(1, 100)
  }

}



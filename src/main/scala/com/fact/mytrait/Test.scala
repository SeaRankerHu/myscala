package com.fact.mytrait

object Test {
  def main(args: Array[String]): Unit = {
    //运行时，可以动态混入特征
    var cat = new Cat("tom") with BeforeAction with AfterAction
    //多态
    callMethod(cat)
    println(cat.getName())
    cat.doSleep()

    println("---------------------------------------------------")
    val dog = new Dog("tom")
//    dog.eat("meat")
    callMethod(dog)
    println(dog.getName)
    dog.doSleep()

    val pig = new MyPig()
    pig.doSleep()

//    assert(1 == 2)
  }

  /**
    * Animal的子类都可以做为参数
    * @param an
    */
  def callMethod(an : Animal[String]) : Unit = {
    an.eat("fish");
    println("the atacked resut is " + an.atack("fish"));
  }
}

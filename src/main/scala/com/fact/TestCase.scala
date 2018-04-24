package com.fact

object TestCase {

  def main(args: Array[String]): Unit = {

    println("matchTest: "+matchTest(5));
    println(matchT("cat"));
    println("matchAny:" + matchAny("222"));
    matchObject();

    Seq
  }

  //模式匹配,类似switch
  def matchTest(x : Int) : String = x match{
    case 1 => "one"
    case 2 => "tow"
    case _ => "many"
  }

  def matchT(name : String) : Int = {
    name match{
      case "pig" => 1
      case "cat" => 2
      case _ => 3
    }
  }

  def matchAny(key : Any) : Any = {
    key match{
      case "cat" => 1
      case 11 => "pig"
      case y : Int => "this is an Integer"
      case y : String => "this is an string"
      case _ => "any"
    }
  }

  def matchObject(): Unit ={
    val alice = new Person("Alice", 25)
    val bob = new Person("Bob", 32)
    val charlie = new Person("Charlie", 32)

    for (person <- List(alice, bob, charlie)) {
      person match {
        case Person("Alice", 25) => println("Hi Alice!")
        case Person("Bob", 32) => println("Hi Bob!")
        case Person(name, age) =>
          println("Age: " + age + " year, name: " + name + "?")
      }
    }
  }
  // 样例类
  case class Person(name: String, age: Int)
}

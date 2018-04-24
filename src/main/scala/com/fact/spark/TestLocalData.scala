package com.fact.spark

object TestLocalData {
  
  def main(args : Array[String]) : Unit = {
    
    var arr1 = List(2, 13 ,4534 ,234, 33)
    var result = arr1.par.reduce(_ + _)
    println(result)
    
    var map1 = Map("red" -> 1, "yellow" -> 2, "white" -> 44)
    
   
    
  }
}
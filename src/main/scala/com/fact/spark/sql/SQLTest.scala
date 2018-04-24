package com.fact.spark.sql

import org.apache.spark.sql.SparkSession

object SQLTest {
  
  
  def main(args : Array[String]) : Unit = {
    var arr = Array(2, 3, 4)
    arr.foreach(n => println("elem : " + n))
    test()

  }
  
  
  def test() : Unit = {
        // Encoders are created for case classes
    
//    val caseClassDS = Seq(Person("Andy", 32)).toDS()
//    caseClassDS.show()
//    
//    // Encoders for most common types are automatically provided by importing spark.implicits._
//    val primitiveDS = Seq(1, 2, 3).toDS()
//    primitiveDS.map(_ + 1).collect() // Returns: Array(2, 3, 4)
    
     val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value")
      .master("local")
      .getOrCreate()
    //设置日志级别
    spark.sparkContext.setLogLevel("WARN")
    // For implicit conversions like converting RDDs to DataFrames
    import spark.implicits._
    
    // DataFrames can be converted to a Dataset by providing a class. Mapping will be done by name
    val path = "src/main/resources/people.json"
    val peopleDS = spark.read.json(path).as[Person]
    peopleDS.show()
    peopleDS.select("name").show();

    val peopleDF = peopleDS.toDF()
    println("==================")
//    //register the DataFrame as a peopleDF view
    peopleDF.createOrReplaceTempView("people")
    spark.sql("select name from people")
  }
  
  case class Person(name: String, age: Long)
}

package com.fact.spark.sql

import org.apache.spark.sql.SparkSession

object TestAverage {
   
  def main(args : Array[String]) : Unit = {
    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value")
      .master("local")
      .getOrCreate()
    //设置日志级别
    spark.sparkContext.setLogLevel("WARN")
    
    // Register the function to access it
    spark.udf.register("myAverage", MyAverage)
    
    val df = spark.read.json("src/main/resources/employees.json")
    df.createOrReplaceTempView("employees")
    df.show()
    // +-------+------+
    val result = spark.sql("SELECT myAverage(salary) as average_salary FROM employees")
    result.show()
    
    val personDF = spark.read.json("src/main/resources/people.json");
    personDF.createOrReplaceTempView("person")
    personDF.show()
    
    val resultDF = spark.sql("select myAverage(age) as average_age from person")
    resultDF.show()
    
  }
}
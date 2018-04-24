package com.fact.spark.sql

import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

object sparkSql {
  
  def query() : Unit = {
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    
    // this is used to implicitly convert an RDD to a DataFrame.
    import sqlContext.implicits._
    // Create the DataFrame
    val df = sqlContext.read.json("src/main/resources/people.json")

    // Displays the content of the DataFrame to stdout
    df.show()
    
    println("===========================================")
    // Print the schema in a tree format
    df.printSchema()
    println("===========================================")
    // Select only the "name" column
    df.select("name").show()
    // Select people older than 21
    df.filter($"age" > 21).show()
     // Count people by age
    df.groupBy("age").count().show()
    println("======================10=====================")
    // Register the DataFrame as a SQL temporary view
    df.createOrReplaceTempView("people")
    val sqlDF = sqlContext.sql("SELECT * FROM people")
    sqlDF.show()
    
    println("======================11=====================")
    // Register the DataFrame as a global temporary view
    df.createGlobalTempView("people")
    // Global temporary view is tied to a system preserved database `global_temp`
    sqlContext.sql("SELECT * FROM global_temp.people").show()
    println("======================12=====================")
    // Global temporary view is cross-session
    sqlContext.newSession().sql("SELECT * FROM global_temp.people").show()
    
  }
  
  
  def query1() : Unit = {
     val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value")
      .master("local")
      .getOrCreate()
    // For implicit conversions like converting RDDs to DataFrames
    import spark.implicits._
    
    val df = spark.read.json("src/main/resources/people.json")

    // Displays the content of the DataFrame to stdout
    df.show()
    
     println("===========================================")
    // Print the schema in a tree format
    df.printSchema()
    println("===========================================")
    // Select only the "name" column
    df.select("name").show()
    // Select people older than 21
    df.filter($"age" > 21).show()
     // Count people by age
    df.groupBy("age").count().show()
    println("======================10=====================")
    // Register the DataFrame as a SQL temporary view
    df.createOrReplaceTempView("people")
    val sqlDF = spark.sql("SELECT * FROM people")
    sqlDF.show()
    sqlDF.map(row =>  "name: " + row(0)).show()
    
    println("======================11=====================")
    // Register the DataFrame as a global temporary view
    df.createGlobalTempView("people")
    // Global temporary view is tied to a system preserved database `global_temp`
    spark.sql("SELECT * FROM global_temp.people").show()
    println("======================12=====================")
    // Global temporary view is cross-session
    spark.newSession().sql("SELECT * FROM global_temp.people").show()
    
    
  }
  
  def main(args : Array[String]) : Unit = {
//    query()
    query1()
  }
  
}
package com.fact.spark.sql

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.Row

/**
 * 使用程序动态从RDD到DataFrame
 */
object SparkSqlSchema {
  case class Person(name: String, age: Long)
  
  def exam() : Unit = {
    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value")
//      .master("local")
      .getOrCreate()
      // For implicit conversions from RDDs to DataFrames
    import spark.implicits._
    
    // Create an RDD
    val peopleRDD = spark.sparkContext.textFile("examples/src/main/resources/people.txt")

    // The schema is encoded in a string
    val schemaString = "name age"
    
    // Generate the schema based on the string of schema
    val fields = schemaString.split(" ").map(fieldName => StructField(fieldName, StringType, nullable = true))
    val schema = StructType(fields)
    // Convert records of the RDD (people) to Rows
    val rowRDD = peopleRDD.map(_.split(",")).map(record => Row(record(0), record(1)))
    // Apply the schema to the RDD
    val peopleDF = spark.createDataFrame(rowRDD, schema)
    // Creates a temporary view using the DataFrame
    peopleDF.createOrReplaceTempView("people")
    // SQL can be run over a temporary view created using DataFrames
    val results = spark.sql("SELECT name FROM people")
    
    // The results of SQL queries are DataFrames and support all the normal RDD operations
    // The columns of a row in the result can be accessed by field index or by field name
    results.map(attributes => "Name: " + attributes(0)).show()
    
    
  }
  
  def main(args : Array[String]) : Unit = {
    
    exam()
  }
}
package com.fact.spark.sql

import java.util.Properties

object JdbcTest {
  def main(args : Array[String]) : Unit = {
    val spark = MySparkFactory.getParkSession()
    val connectionProperties = new Properties()
    connectionProperties.put("user", "root")
    connectionProperties.put("password", "123456")
    val url = "jdbc:mysql://192.168.233.151:3306/hive";  
//    val url = "jdbc:mysql://node1:3306/hive"
    val jdbcDF = spark.read
      .jdbc(url, "ROLES", connectionProperties)
    println("size : " + jdbcDF.rdd.partitioner.size)
    jdbcDF.collect().foreach(println)
    
    jdbcDF.show()
  }
}
package com.fact.spark.sql

import org.apache.spark.sql.SparkSession

object MySparkFactory {
  
  def getParkSession() : SparkSession = {
    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value")
      .master("local")
      .getOrCreate()
    //设置日志级别
    spark.sparkContext.setLogLevel("WARN")
    return spark
  }
}
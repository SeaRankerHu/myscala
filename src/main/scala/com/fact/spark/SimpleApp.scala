package com.fact.spark

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf

object SimpleApp {
  def main(args: Array[String]) {
//    val logFile = "file:/C:\\HPE Work\\6.工具\\hadoop\\spark-2.2.1-source\\README.md" // Should be some file on your system
      val logFile = "hdfs://hhjcluster/user/root/README.md" // Should be some file on your system

    
//    val spark = SparkSession.builder.appName("Simple Application").master("local").getOrCreate()
//    val logData = spark.read.textFile(logFile).cache()
//    val numAs = logData.filter(line => line.contains("a")).count()
//    val numBs = logData.filter(line => line.contains("b")).count()
//    println(s"Lines with a: $numAs, Lines with b: $numBs")
//    spark.stop()
    
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()

    println(s"Lines with a: $numAs, Lines with b: $numBs")
    sc.stop()
    
  }
}
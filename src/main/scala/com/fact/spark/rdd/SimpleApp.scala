package com.fact.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}

object SimpleApp {
  def main(args: Array[String]) {
//    val logFile = "file:/C:\\HPE Work\\6.工具\\hadoop\\hadoop-2.6.5\\README.txt" // Should be some file on your system
    val logFile = "hdfs://hhjcluster/user/root/README.md" // Should be some file on your system

    val conf = new SparkConf().setAppName("Simple Application")
//    conf.setMaster("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
    val logData = sc.textFile(logFile, 2).cache()
    //定义累加器
    val accum = sc.longAccumulator("wordCount")
    val wordData = logData.repartition(5).filter(line => {
      println("filter : "+Thread.currentThread().getId + " length:" + line.split(" ").length)
      line.contains("a")
    }).flatMap(line => {
      println("flatMap:"+ Thread.currentThread().getId + " length:" + line.split(" ").length)
      line.split(" ")
    })
    val wordMap =  wordData.map(word => {
//      val accum = sc.longAccumulator("wordCount")
      accum.add(1)
      println("map:"+ Thread.currentThread().getId )
      (word, 1)
    }).cache() //此处增加cache，避免重复计算

//    val wordMap = wordData.mapPartitions(it => {
//      println("map:"+ Thread.currentThread().getId + "  "+ it.length)
//      for(key <- it) yield (key, 1)
//    }).cache() //此处增加cache，避免重复计算

    val result = wordMap.reduceByKey((a, b) => {
      println("reduce : " + Thread.currentThread().getId)
      a + b
    })
    //=================action==============
    val numAs =wordMap.count()
    println("============================1")
    val numRs = result.collect()
    println("===================================2")
//    numRs.foreach(u => println(u._1 + " = " + u._2))
//    println(numRs.mkString(","))
    println(s"Lines with a: $numAs")
    val wordCount = accum.value
    println(s"wordCount is $wordCount")

    //    val numBs = logData.filter(line => line.contains("b")).count()
//    println(s"Lines with a: $numAs, Lines with b: $numBs")
    sc.stop()
    
  }
}
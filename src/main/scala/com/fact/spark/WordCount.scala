package com.fact.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WordCount {
    def main(args : Array[String]) : Unit = {
      val logFile = "file:/C:\\HPE Work\\6.工具\\hadoop\\hadoop-2.6.5\\README.txt" // Should be some file on your system
      val conf = new SparkConf().setAppName("Simple Application").setMaster("local[2]")
      val sc = new SparkContext(conf)
      sc.setLogLevel("WARN")
      
      //从Driver程序的数据集生成RDD
      val data = Array(1, 2, 3, 4, 5)
      val distData = sc.parallelize(data, 2)
      var result = distData.reduce((a, b) => a * b)
      println("result :" + result)
      
      
      //从外部数据集生成RDD
      var logData = sc.textFile(logFile, 2).cache()
      //统计单词个数
      var wordCount = logData.map(str => str.split(" ").length).reduce((a, b) => a+b)
      println("wordCount:"+ wordCount)
      
      //单词计数
      var words = logData.flatMap(line => line.split(" "))
      var pairs = words.map(word => (word, 1))
      var wordsCount = pairs.reduceByKey((a, b) => a+b)
      wordsCount.collect().foreach(row => println(row._1 +" : " +row._2))
     
      
      //var files = sc.wholeTextFiles("file:/C:\\HPE Work\\6.工具\\hadoop\\spark-2.2.1-source\\", 2)
      //声明广播变量
      val broadcastVar = sc.broadcast(Array(1, 2, 3))
      println("broadcast var:" + broadcastVar.value)
      
      //定义累加器
      val accum = sc.doubleAccumulator("my double accumulator")
      accum.add(222)
      println("accum: "+ accum.value)
      
      sc.stop()
    }
}

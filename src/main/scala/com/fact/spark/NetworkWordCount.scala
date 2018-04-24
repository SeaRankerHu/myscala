package com.fact.spark

import org.apache.spark.SparkConf
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.storage.StorageLevel
import org.apache.spark.SparkContext

object NetworkWordCount{
  
  def myUpdateState(newValues : Seq[Int], runningCount : Option[Int]) : Option[Int] = {
    var sum = 0
    newValues.foreach(num => sum = num + sum)
    println("sum: "+ sum)
    return Some(sum)
  }
  
  def toCreateContext() : StreamingContext = {
    val conf = new SparkConf().setAppName("NetworkWordCount").setMaster("local[2]")
    val sc = new SparkContext(conf)
     //初始化spark streaming
    val ssc = new StreamingContext(sc, Seconds(60))
    //定义输入源(socket)，创建DStream
//    val lines = ssc.socketTextStream("localhost", 9000, StorageLevel.MEMORY_AND_DISK_SER)
//    val lines = ssc.textFileStream("file:/C:\\HPE Work\\6.工具\\hadoop\\etc\\hadoop\\")
    //设置检查点
//    ssc.checkpoint("file:/C:\\HPE Work\\6.工具\\hadoop\\etc\\")
    ssc
  }
  
  def main(args : Array[String]) : Unit = {
//    var conf = new SparkConf().setAppName("NetworkWordCount").setMaster("local[2]")
//    val sc = new SparkContext(conf)
//    
//    //初始化spark streaming
//    var ssc = new StreamingContext(sc, Seconds(60))
    val ssc = StreamingContext.getActiveOrCreate(toCreateContext)
    //定义输入源(socket)，创建DSStream
//    val lines = ssc.socketTextStream("localhost", 9000, StorageLevel.MEMORY_AND_DISK_SER)
    val lines = ssc.textFileStream("file:/C:\\HPE Work\\6.工具\\hadoop\\etc\\hadoop\\")
    
    //输入源可以为文件
//    ssc.fileStream(directory, filter, newFilesOnly)
    val words = lines.flatMap(_.split(" "))
    val pairs =  words.map(x => (x, 1))
   
    val wordCounts = pairs.reduceByKey(_ + _)
//    val wordCountsState = pairs.updateStateByKey(myUpdateState)
//    wordCounts.print()
    wordCounts.foreachRDD(rdd => {
      rdd.foreach(unit => println(unit._1 + ":"+ unit._2))
    })
        
    //开始接受和处理数据
    ssc.start()
    //等待执行完成
    ssc.awaitTermination()
    
    ssc.stop(false)
    
    
//    sc.stop()
  }
}
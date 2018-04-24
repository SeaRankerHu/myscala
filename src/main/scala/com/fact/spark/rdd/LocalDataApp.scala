package com.fact.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}

object LocalDataApp {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("LocalDataApp").setMaster("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
    val list = List(8, 22, 81, 9, 32, 21, 7, 3, 4, 5, 7, 11)
    //从本地数据集新建rdd
    val localData = sc.parallelize(list)
    val result = localData.flatMap(num => Array(num, num + 1)).reduce(_ + _).toDouble
    println("result : " + result)

    val list1 = List("hello", "one", "world", "spark", "hadoop", "shell", "word", "hello", "one", "tom", "cat",
      "hello", "world", "spark", "one", "hadoop", "shell","hadoop", "word", "hello", "one", "tom")

    val localWordData = sc.parallelize(list1).map((_, 1))
    val wordData = localWordData.reduceByKey(_ + _).cache()
    println(wordData.collect().mkString(","))
    //排序
    val sortData = wordData.sortByKey(ascending = false)
    println(sortData.collect().mkString(","))

    //分组
    val groupData = localWordData.groupByKey()
    println(groupData.collect().mkString(","))

    //再次map
    val secondMap = groupData.map(elem => (elem._1, elem._2.mkString(",")))
    println(secondMap.collect().mkString(","))

    val list2 = List("hello", "one", "world", "spark", "hadoop", "shell", "word", "hello", "one", "tom", "cat",
      "hello", "world", "spark")
    val wordData2 = sc.parallelize(list2).map((_, 1)).reduceByKey(_ + _).cache()
    //连接
    val joinData = wordData.join(wordData2)
    println(joinData.collect().mkString(","))
  }
}

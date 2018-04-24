package com.fact.spark.sql

object ParquetTest {
  
  def test() : Unit = {
      val spark = MySparkFactory.getParkSession()
      val usersDF = spark.read.load("src/main/resources/users.parquet")
      usersDF.show()
      //查询并保存?????
      usersDF.select("name", "favorite_color").write.save("namesAndFavColors.parquet")
  }
  
  def main(args : Array[String]) : Unit = {
    test()
  }
}
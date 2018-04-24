package com.fact

object TestHighOderFunction {

  def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
    val schema = if (ssl) "https://" else "http://"
    (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
  }

  private def calculate(salaries : List[Double], calFunction : Double => Double) : List[Double] = {
    salaries.map(calFunction)
  }

  def calculateSalary(salaries : List[Double]): List[Double] ={
    calculate(salaries, x => x * 2)
  }
  def main(args: Array[String]): Unit = {
    val domainName = "www.example.com"
    def getURL = urlBuilder(ssl=true, domainName)
    val endpoint = "users"
    val query = "id=1"
    val url = getURL(endpoint, query)
    println(url)

    calculateSalary(List(3, 4,5, 88)).foreach(d => println("list:"+d))
  }
}



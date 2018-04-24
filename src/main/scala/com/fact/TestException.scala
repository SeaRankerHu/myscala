package com.fact

import java.io.{FileNotFoundException, FileReader, IOException}

object TestException {

  def main(args: Array[String]): Unit = {
    var file : FileReader = null
    try{
        file  = new FileReader("test.txt")
        var buf  = new Array[Char](1024)
        file.read(buf)
    }catch {
      case ex : FileNotFoundException => ex.printStackTrace()
      case ex : IOException => println(ex)
    }finally {
      if(file != null) file.close()
    }
  }
}

package com.thl.test.threadPool

object StringTest01 {
  def main(args: Array[String]): Unit = {
    var arr = new Array[String](3)
    arr(0) = "fs";
    arr(1) = "ffg"
    arr(2) = "ffg"

    for (x <- arr){
      println(x)
    }

    for (x <- arr.indices){
      println(arr(x))
    }

    for (value <- arr){
      println(value)
    }




  }

}

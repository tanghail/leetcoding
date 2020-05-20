package com.thl.test.threadPool

object Matched {
  def main(args: Array[String]): Unit = {
    println(matchTest(5))

  }

  def matchTest(x:Int) : String = x match {
    case 1 => "1"
    case 2 => "2"
    case 3 => "3"
    case _ => "other"
  }

}

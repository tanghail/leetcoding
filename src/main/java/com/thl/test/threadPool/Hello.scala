package com.thl.test.threadPool

object Hello {
    def main(args: Array[String]) : Unit = {
      println("muliplier(1) value = " + multiplier(1))
      println("muliplier(2) value = " + multiplier(2))
    }
    var factor = 3
    val multiplier: Int => Int = (i:Int) => i * factor

    def time(): Long = {
      println("获取当前的事件--")
      System.nanoTime()
    }

    def delayed(t: => Long): Unit ={
      println("在delayed的方法内")
      println("时间： " + t )
      t
    }

}

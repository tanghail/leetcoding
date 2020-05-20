package com.thl.test.threadPool

object CollectionsTest {
  def main(args: Array[String]): Unit = {
    val fruit = "test01" :: ("google" :: ("test02" :: ("baidu" :: Nil)))
    val fruit2 = "test01" :: "google" :: "test02" :: "baidu" :: Nil

    for (value <- fruit)
      println(value)

    val site = List.fill(3)("test")
    for (value <- site)
      println(value)

    val squares = List.tabulate(4)(n => n + 3)
    for (value <- squares){
      print(value + " ")
    }


    println(fruit.head)
    println(fruit2.tail)


  }

}

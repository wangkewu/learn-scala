package com.wkw.function

object HelloWorld {


  def main(args: Array[String]): Unit = {

    hello
    hello()
  }

  def hello(): Unit ={
    println("hello world")
  }
}

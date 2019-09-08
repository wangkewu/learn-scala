package com.wkw.exception

object HelloWorld {

  def main(args: Array[String]): Unit = {

    try {

    } catch {

      case e: ArithmeticException =>{
        println("除0异常")
      }
      case e: Exception =>{
        println("未知异常")
      }
    } finally {
      println("finally...")
    }
  }
}

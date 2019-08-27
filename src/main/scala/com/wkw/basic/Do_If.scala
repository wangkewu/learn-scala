package com.wkw.basic

import scala.io.StdIn

object Do_If {
  def main(args: Array[String]): Unit = {

    print("请输入分数")
    val score:Int = StdIn.readLine().toInt
    if (score < 60) {
      println("不及格")
    } else if (score >= 60 && score < 75) {
      println("及格")
    } else if (score >= 75 && score < 80){
      println("良")
    } else {
      print("优")
    }
  }

}

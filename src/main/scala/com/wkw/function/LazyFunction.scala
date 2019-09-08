package com.wkw.function

/**
  * 惰性函数
  *
  * 可以将耗时的计算推迟到需要的时候
  * lazy 关键字只能修改val类型变量
  * 声明lazy变量也是一样 值分配也会推迟  lazy val x:Int = 10
  */
object LazyFunction {

  def main(args: Array[String]): Unit = {

    lazy val result:Int = sum(5,10);
    println("=================")
    println("result:"+result)
    lazy val x:Int = 10
  }

  def sum(x:Int, y:Int): Int={
    return x + y
  }
}

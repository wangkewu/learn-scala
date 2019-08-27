package com.wkw.basic
import util.control.Breaks._
object Do_While {

  def main(args: Array[String]): Unit = {

    var i = 0
    //先判断再执行
    while(i < 10) {
      print(i+" ")//0 1 2 3 4 5 6 7 8 9
      i += 1  //scala中无 ++ --符号
    }
    println()
    var j = 0
    do {
      j+= 1
      print(j +" ")//1 2 3 4 5 6 7 8 9 10
    }while(j < 10)

    var k = 1
//    while (k < 10) {
//      if (k >5) {
//        break //抛出一个异常 scala.util.control.BreakControl 要进行处理 才可以进行后面
//      }
//      k += 1
//    }

    //高阶函数
    breakable{
      while(k < 10 ) {
        if (k > 5) {
          break()
        }
        print(k +" ")
        k+= 1
      }
    }  //这样就处理了异常 处理 后面可以继续下去
    println()
    print("hello world")
  }

}

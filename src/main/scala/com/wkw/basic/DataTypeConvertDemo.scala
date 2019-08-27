package com.wkw.basic

/**
  * 值类型转换
  *
  * 1.自动提升原则 表达式结果的类型自动提升为 操作数中最大的类型
  * byte -->Short -->Int --> Long --> Float-->Double-->BigDecimal
  */
object DataTypeConvertDemo {

  def main(args: Array[String]): Unit = {

    var num = 10
    var num1 = 10.1  //double

    var sum = num + num1

    print(sum.getClass.getName) //int to double

    var num2 :Byte = 10
//    var num3 :Char = num2 //error byte not convert to char
    var decimal :BigDecimal=2
    decimal = num1  //double --> BigDecimal


    //强制类型转换 数据类型从大至小 需要使用强制转换类型
    var num3:Int = num1.toInt  // java --> a = (int) 2.5

    //强制转换符号只对最近的操作数有效
    var num4 :Int = 2 * 0.5.toInt
    var num5 :Int = (2*0.5).toInt

    //也支持String 转换值类型
    var numStr = "20"
    var num6 = numStr.toInt //toDouble toFloat...

    var numStr1 = "20a"
//    var num7 = numStr1.toInt // NumberFormatException

//    var numStr2:Int = "20.5".toInt  //NumberFormatException
    var numStr3:Double = "20.3".toDouble
    var numStr4:Float = "29.3".toFloat

  }

}

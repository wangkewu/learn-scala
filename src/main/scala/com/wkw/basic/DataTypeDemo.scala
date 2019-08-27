package com.wkw.basic

object DataTypeDemo {
  def main(args: Array[String]): Unit = {

    var score: Int = 90
    var score1: Float = 90.3f
    var score2: Double = 99.0
    var score3: Long = 99l

    //auto
    var num =90


    var num1 = 90f
    var num2 = 99.0
    var num3 = 99l
    //    println(num.getClass.getName +"\t" + num1.getClass.getName+"\t"+num2.getClass.getName+"\t"+num3.getClass.getName)

    var success1 = true
    var success: Boolean = true

    var char1: Char = 'a'
    var char2 = 'b'
    println(char2 - char1)

    var result = "hello world"
    var result1:String = "hello world"
    println(result+"\t"+result1)

    var change:Int = 120
    change = 130

    //change = 130.2 // error   strong typed languages

    /**
      * 声明定义变量时候  可以使用var 或者val 来修饰。var修饰的变量可以修改  val修饰的变量不可以修改
      * val 没有线程安全问题 等同在编译后加 final
      */
    //val noChange:Int = 220
    //noChange = 223    //compile error

    /**
      * Unit  只有一个实例 ()   类似 void
      * Null  只有一个实例 null  类似java 的null  可以赋值给任意引用类型 AnyRef 但是不能赋值给AnyRel(Int Float Double Boolean Byte Short Char)
      * Nothing 其他任意类型的子类  bottom class
      */

      var unit = hello();
      println(unit)//====> ()

      val person:Person = null

//      val t:Char = null  //error
//      println(t)

  }
  def hello():Unit={


  }

}

class Person {

}

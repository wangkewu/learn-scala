package com.wkw.implicittype

import com.wkw.oop.Person

/**
  * 隐式转换发生在
  *   方法中的参数类型与目标类型不一致  或者是赋值时候
  * 隐式转换函数名是任意的  与函数名称无关  只与函数参数类型和返回值类型有关
  * 在编译的时候会做好调用操作
  * 隐式函数允许有多个存在 但是不能在当前环境下 只有一个被识别
  */
object ImplicitMethodDemo {
  def main(args: Array[String]): Unit = {

    val age :Int = 18.5

    val age_2 :Int = 18.5f

    //增加用户可以说英语的功能
    implicit def addSpeakEnglish(person: Person):English ={
      new English
    }
    var person:Person = new Person()
    person.speakEnglish()

  }

  implicit def doubleToInt(d:Double): Int={
    println("double to int:"+d)
    d.toInt

  }

  //这样程序无法识别要调用哪一个 编译失败
//  implicit def doubleToInt_2(d:Double):Int = {
//    println("double to int 2...:"+d)
//    d.toInt
//  }

  implicit def floatToInt(f:Float):Int={
    println("float to int :"+f)
    f.toInt
  }

  //隐式转换丰富类库功能
  class English {
    def speakEnglish(): Unit ={
      println("speak english...")
    }
  }
}

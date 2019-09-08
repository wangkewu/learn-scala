package com.wkw.oop

/**
  * 属性
  */
object AttrsDemo {

  def main(args: Array[String]): Unit = {

    var a:Aminal = new Aminal
    a.sayHello()
    var count = a.sum(1,2)
    println(count)
    println(a.name +"\t" + a.age +"\t" + a.flag) //null 0 false
    a.name = "hello"
    a.age = 18
    a.flag = true
    println(a.name +"\t" + a.age +"\t" + a.flag) //hello 18 true
  }
}

class Aminal{

  var name:String = _ //默认属性null

  var age:Int = _ //默认 0
  var flag:Boolean = _ //default false
//  var color = _ //error 如果用默认值 一定要确定声明类型

  def sayHello(): Unit ={
    println("hello world")
  }

  def sum(a:Int, b:Int):Int ={

    return a + b
  }
}

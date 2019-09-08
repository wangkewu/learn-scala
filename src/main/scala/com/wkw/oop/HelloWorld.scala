package com.wkw.oop

object HelloWorld {

  def main(args: Array[String]): Unit = {

    var hello:Hello = new Hello
    println(hello.name+"---"+hello.age)
  }

}

class Hello{
  var name:String = "world"
  var age:Int = 18
}


package com.wkw.oop

import scala.beans.BeanProperty

/**
  * 构造器
  *   分为主构造器
  *   辅助构造器 （支持多个） 编译器 通过不同参数来区分
  *
  *   创建对象的流程:
  *     加载类信息
  *     堆中开辟空间
  *     使用父类构造器(主 辅)进行初始化
  *     使用主构造器堆属性进行初始化
  *     使用辅助构造器对属性进行初始化
  *     将地址赋值给变量x引用
  */
object ConstructorDemo {

  def main(args: Array[String]): Unit = {

    var d:Dog = new Dog("hello",10)

    var tiger:Tigger = new Tigger("hello", 11)
    println(tiger.inAge+"\t"+tiger.inName+"\t"+tiger.age+"\t"+tiger.name)
//    tiger.inAge = 11 //private 可读
    tiger.inName = "world" //private 可读写
    tiger.getColor
    tiger.setColor("yellow")
  }
}
//构造器参数  使用 val关键字声明  作为类的私有的只读属性使用
//var 关键字声明 作为类的成员属性使用  并提供对应的get /set方法 私有能读写
/**
  *
  * @param inName
  * @param inAge
  */
class Tigger(var inName:String, val inAge:Int) {

  var name = inName  //private 可读写
  var age = inAge //private 可读
  //自动生成 get /set
  @BeanProperty
  var color:String = _
}

class Cat(){

  var name:String = _
  var age:Int = _

  def this(name:String, age:Int) {
    this() //直接调用构造器
    this.name = name
    this.age = age
  }

  def this(name:String) {
    this();//直接调用显示构造器
    this.name = name
  }

  def this(age:Int) {
    this("default") //间接调用构造器 有this(name:String) 里的辅助构造器里已经调用了主构造器
    this.age = age

  }
}

//主构造器 主构造器的形参未用任何修饰符修饰 那么这个参数是局部变量
class Dog (inName:String, inAge:Int){
  var name:String = inName
  var age:Int = age
  println("main constructor...")
  def this(name:String){
    //辅助构造器 必须在第一行显示调用主构造器
    this(name, 10) //直接显示调用主构造器
  }
  //不允许 辅助构造器 通主构造器一样 会发生构造器重名错误
//  def this(name:String, age:Int) {
//    this(name, age)
//  }
  override def toString: String = {
    "name=" +this.name+"\t age=" + this.age
  }

}

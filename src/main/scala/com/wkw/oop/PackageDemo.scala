package com.wkw.oop

import java.util
import java.util.HashMap

import scala.collection.mutable

/**
  * java 包作用
  *   区分相同类名字
  *   控制访问范围
  *   方便管理
  *   public private protected
  *  scala 包作用
  *   方法访问权限为默认时  默认为public 选项 注:无public 关键字
  *   private为私有权限 只在类的内部使用和伴生对象中使用
  *   protected 受保护权限 只能子类访问  同包无法访问
  *
  *   包引入
  *   import package._   如果要导入包中的所有类 使用 _
  *     导入指定的类 import package.{A, B}
  *    引入多个包含有相同类  可以将类进行 重命名
  *    import java.util.{HashMap => JavaHashMap,List}
  *    隐藏包下指定的类  导入util下所有的包 除了 HashMap
  *    import java.util.{HashMap=>_, _}
  *
  */
object PackageDemo {

  def main(args: Array[String]): Unit = {
      import scala.collection.mutable.{HashSet, HashMap}
      var set = new HashSet()

      var map = new HashMap()
      import java.util.{HashMap=>JavaHashMap, ArrayList=>JavaList}
      var javaHashMap = new JavaHashMap();
      var javaList = new JavaList[String]()
      var person:Person = new Person
//      person.age  //error 私有 无法访问
    //scala 简化开发默认 类属性 自动提供了对应的get/set方法  如果声明为private 那其get/set也是private
    // 省略访问权限修饰符则为public   person.name 底层编译也是调用 getName
  }
}
//伴生类 写非静态的内容
class Dog1{
  var name:String = "hello"
  private var age:Int = 18
  //包访问权限private[package] 代表在该包下也可以访问该属性 同时也可以延展到上层包
  private[oop] var englishName:String = "englishName"
  protected var weight:Int = 180

  def showInfo(): Unit ={
    println(name+"\t"+age+"\t"+weight);
  }
}
//伴生对象 静态内容 scala 中无static
object Dog1{

  def test(dog:Dog1): Unit = {
    println(dog.name+"\t"+dog.age+"\t"+dog.weight);
  }
}

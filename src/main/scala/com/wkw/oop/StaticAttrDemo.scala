package com.wkw.oop

/**
  * scala 静态属性 静态方法
  *
  * 伴生对象使用object 关键字声明  伴生对象中声明是静态内容  通过伴生对象直接调用
  * 编译角度看 scala 并没有生成静态的内容 而是将伴生对象生成了一个新的类
  *
  *
  * 伴生对象中定义apply方法：
  *   类名(参数) 创建实例 省略new
  *
  */
object StaticAttrDemo {

  def main(args: Array[String]): Unit = {

    println(Fruit_2.color) //直接调用 不能调用Fruit_2.name

    var fruit_1:Fruit_2 = Fruit_2()
    println("fruit_1:"+fruit_1.name)
    var fruit_2 = Fruit_2("hello")
    println("fruist2:"+fruit_2.name)
  }
}

/**
  * 伴生类
  * 非静态内容写到这里
  */
class Fruit_2{

  var name:String = _
  def this(name:String) {
    this()
    this.name = name
  }
}

/**
  * 伴生对象
  * 静态内容写到这里
  * 伴生对象里的属性或者方法 可以直接 Fruit_2.attr Fruit_2.method
  */
object Fruit_2{

  def apply(): Fruit_2 = new Fruit_2()

  def apply(inName:String): Fruit_2 = new Fruit_2(inName)
  var color:String="red"
}

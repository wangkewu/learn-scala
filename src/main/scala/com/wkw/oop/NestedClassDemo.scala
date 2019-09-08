package com.wkw.oop

/**
  * 嵌套类
  */
object NestedClassDemo {

  def main(args: Array[String]): Unit = {

    val out :Outer = new Outer

    val inner = new out.Inner
    inner.showOuterInfo()
    inner.showOuterInfoByAlisOuter
    out.testProjection(inner)
    val staticInner = new Outer.InnerStatic


  }
}

/**
  * 内部类访问外部类的属性
  *   外部类名.this.attr
  *   外部类别名访问 外部类名别名.attr
  */
class Outer{
  //外部类别名  可以看做是外部类的一个属性
  alisOuter=>
  var name:String = "hello"
  private var age:Int = 18

  //成员内部类
  class Inner{
    var innerName:String = "inner Hello"
    def showOuterInfo(): Unit ={
      println("showOuterInfo name:"+Outer.this.name+"\t age:"+Outer.this.age)
    }
    def showOuterInfoByAlisOuter: Unit ={
      println("showOuterInfoByAlisOuter name:"+alisOuter.name+"\t age:" +alisOuter.age)
    }
  }
  //类型投影 屏蔽了外部对象对内部类对象的影响
  def testProjection(projection:Outer#Inner): Unit ={
    println("test projection :"+projection +"\t innerAttr:"+projection.innerName)

  }
}

object Outer{
  //静态内部类
  class InnerStatic{

  }
}

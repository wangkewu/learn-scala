package com.wkw.oop

/**
  * scala 中覆盖写字段
  */
object OverrideAttr {

  def main(args: Array[String]): Unit = {

    val fruit:Fruit = new Fruit

    val apple:Apple = new Apple

    println("fruit:"+fruit.weight+"\t apple:"+apple.weight)//1 11

    //实例化抽象类 即要全部实现抽象属性 方法  也称匿名子类
    var f:Fruit_1 = new Fruit_1 {
      override def showInfo(): Unit = {

      }

      override var color: String = _
    }
  }
}

/**
  * 抽象类不可以实例化
  * 抽象类不一定包含抽象属性 抽象方法
  * 类含有抽象类 必须声明为抽象类
  * 继承抽象类 必须实现抽象属性 方法 除非也声明为abstract
  */
abstract class Fruit_1{

  val weight:Int = 1  //普通属性
  var color:String //抽象属性

  def showInfo() //抽象方法 省略方法体 即可以

  def sayHello(): Unit ={
    println("hello world")
  }

}

class Orange extends Fruit_1{
//  override var color: String = _  //子类重写父类的抽象属性 相当于实现了抽象方法
  var color:String = _ //可以写override 也可以不写  抽象属性 即未初始化的属性必须在抽象类 会自动生成一个抽象方法
  //父类抽象属性生成抽象方法 所以非抽象类继承一个抽象类 必须要实现该方法 没有涉及到方法重写的概念 所以可以忽略override
//  def showInfo(): Unit = {   //省略override
//    println("orange show info...")
//  }
  override def showInfo(): Unit = {
    println("orange show info...")
  }
}



class Fruit{
  //修改成var 就会报错  因为var只能重写一个抽象的var属性 抽象属性就是没有被初始化的属性
  val weight:Int=1  //public
//  var color:String //抽象的属性 类要被标记为抽象abstract

}
class Apple extends Fruit{

  override val weight: Int = 11 //public
}

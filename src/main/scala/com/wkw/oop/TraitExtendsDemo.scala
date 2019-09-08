package com.wkw.oop

/**
  * 特质可以继承
  *   混入特质的类已经有继承的类 则要求继承的类是特质超类的子类
  *
  *  自身类型
  *
  */
object TraitExtendsDemo {

  def main(args: Array[String]): Unit = {

    var fly:Fly = new Bird
  }
}

class Message{
  def show(): Unit ={
    println("message show...")
  }
}

class Message_2{
  def show(): Unit ={
    println("Message 2 show....")
  }
}
class Message_3 extends Message{
  def sayShow(): Unit ={
    println("message 3 show ...")
  }
}
trait Fly extends Message {

  def fly(): Unit ={
    println("fly.....")
    show();
  }
}
//错误 因为混入的特质Fly已经继承了Message 所以其继承Message_2必须是Message类的子类
//否则就出现了 多继承
//error
//class Bird extends Message_2 with Fly {
//
//}
//Message_3是Message的子类
class Bird extends Message_3 with Fly{

}
//自身类型 解决其循环依赖问题  限制混入该特质的类 类型 只有Message类型 才能进行混入
trait Fly_2 {
  //声明其为Message类  如果无这句话 者下面show 方法无法使用
  this:Message =>
  def fly(): Unit ={
    show()
  }
}
//因为其属于Message的子类 固可以混入Fly_2
class Bird_2 extends Message with Fly_2{

}
//error 因为Fly_2 特质声明了自身类型为Message
//class Bird_2 extends Fly_2{
//
//}
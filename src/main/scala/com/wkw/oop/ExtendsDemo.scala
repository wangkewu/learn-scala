package com.wkw.oop

/**
  * 继承
  * class 子类名 extends 父类名 {
  *
  * }
  *
  *多态 类型转换 classOf[String]
  * object.isInstanceOf[E] 判断对象是否属性 E类型
  * obj.asInstanceOf[E]  强转成E类型
  *
  * 超类构造
  *   辅助构造器 必须调用 主构造器
  */
object ExtendsDemo {

  def main(args: Array[String]): Unit = {

    var worker:Worker = new Worker("hello")
//    worker.name = "hello"
    worker.age = 18
    worker.idNo="999999999"


    /**
      * 类型转换 classOf[String]
      * object.isInstanceOf[E] 判断对象是否属性 E类型
      * obj.asInstanceOf[E]  强转成E类型
      */
   // println(classOf[Worker]) //java object.class

//    var  person = new Person
//    person = worker //子类转换父类 向上转型 自动转型
//    person.showInfo()
//    var worker1 = person.asInstanceOf[Worker] //向下转型 父类引用转出子类引用  向下转型 多态
//    worker1.working()
  }
}

class Person(inName:String){
  var name:String = _
  var age:Int = _
  var idNo:String = _
  private var others:String = _

  def this(){
    this("person auxiliary")
    println("person auxiliary constructor...")
  }

  println("person main constructor...")
  def showInfo(): Unit ={
    println("person:"+this.name+"\t"+this.age+"\t"+this.idNo)
  }
}

/**
  * 子类继承父类的所有属性 但是private 属性和方法是无法访问的
  */
//class Worker(name:String) extends Person(){ //right 可以通过这样进行调用父类的构造器  主构造器或者辅助构造器都可以
//class Worker(name:String) extends Person{ //right 可以通过这样进行调用父类的构造器  主构造器或者辅助构造器都可以
class Worker(name:String) extends Person(name){ //可以通过这样进行调用父类的构造器  主构造器或者辅助构造器都可以

  println("worker main constructor....")
//  super(name)//错误  scala中不允许 子类调用父类的构造器
  def this(){
    //super(name)
    this("auxiliary...") //必须调用主构造器
    println("worker auxiliary constructor...")
  }

  def working(): Unit ={
    println("working:"+this.name+"\t"+this.age+"\t"+this.idNo)
//    this.others//
    this.showInfo();//通过方法区访问 父类 私有属性
  }
//重写方法
  override def showInfo(): Unit = {
    //子类中调用父类的方法 使用super
    super.showInfo()
    println("worker:"+this.age+"\t"+this.idNo+"\t"+this.name)
  }
}

class Student extends Person{

}

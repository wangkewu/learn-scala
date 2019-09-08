package com.wkw.implicittype

/**
  * 隐式值 也叫隐式变量  将某个形参变量标记为implicit
  */
object ImplicitAttrDemo {

  def main(args: Array[String]): Unit = {
    //隐式值
//    implicit val name:String = "world"
//    implicit val name_2:String = "China"
    //编译器在方法省略隐式参数的情况下搜索作用域内的隐式值作为缺省参数 传入
    // 不能有二义性 -->不允许在同一环境下有多个 这样无法确认传入哪一个
//    hello

    //参数类型传参顺序: 传值 > 隐式值 > 默认值  如果三个参数类型都没有 函数调用会直接报错
//    hello2  //hello world 因为implicit 类型大于 默认值类型
    hello2("china") //hello china  传值大于 隐式 大于默认值

//    hello3 //error 因为既没有默认值 也没有隐式值 也没有传值
  }
  //隐式参数
  def hello(implicit name:String): Unit ={
    println("hello:"+name)
  }

  def hello2(implicit name:String = "China"): Unit = {
    println("hello2 :"+name)
  }

  def hello3(implicit name:String): Unit ={
    println("helllo3 :"+name)
  }
}

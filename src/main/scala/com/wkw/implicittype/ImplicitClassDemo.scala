package com.wkw.implicittype

import com.wkw.oop.Person

/**
  * 当对象调用所在类不存在方法或者成员时 编译器会根据类型自动将对象进行隐式转换 如果有。
  * 隐式类
  *   implicit 修饰的类 即为隐式类 同前面隐式转换方法更方便 丰富类库的功能
  *   构造参数有且只有一个
  *   作用域内不能有与之相同的标识符
  *   必须定义在 类 或 伴生对象 或包对象里 隐式类不能是top level objects
  *   隐式类不能为 case class
  *
  */
object ImplicitClassDemo {

  def main(args: Array[String]): Unit = {

    val person:Person = new Person()
    person.name = "XiaoMing"
    //implicit class
    //  public English(final Person person) {
    //    this.person = person;
    //  }
    /**
      * public String speakEnglish() {
      *   return new StringBuilder().append((Object)this.person().name()).append((Object)" can speak english").toString();
      *}
      */
    //Predef$.MODULE$.println((Object)this.English(person).speakEnglish());
    println(person.speakEnglish())
  }

  implicit class English(val person:Person){

    def speakEnglish(): String = {
      person.name +" can speak english"
    }
  }

}


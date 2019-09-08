package com.wkw.oop

/**
  * scala中接口使用trait 进行表示java中接口的概念   trait = (interface + abstract class)
  *
  * trait TraitName {
  *
  * }
  * 在scala 中 java 的interface 都可以当做trait 来使用
  * class ClassName extends trait with trait with trait{ }
  * class ClassName extends ParentClass with trait with trait{}
  * 同java 一样 对单继承机制进行补充
  *
  *
  *  动态混入 trait 可以在声明时候继承trait 也可以在new时候进行混入特质
  *
  *  动态混入多个特质 称为叠加特质  声明顺序从左到右 方法执行顺序从右到左
  *
  *  富接口 既有抽象方法又有非抽象方法
  *
  *  特质构造顺序
  *      1.声明类 同时继承特质
  *         a调用当前类超类的构造器
  *         b第一个特质父特质构造器
  *         c第一个特质构造器
  *         d第二个特质构造器父特质构造器  如果已经执行过  就不再执行
  *         e第二个特质构造器
  *         f重复调d e如果还有特质
  *         g当前类的构造器
  *         例子：
  *         DB main constructor...
  *         DBConnection mmain constructor
  *         CRUD Parent constructor ...
  *         CRUD2 construct ...
  *         CRUD3 construct ...
  *         mysql main constructor
  *         mysql close ...
  *      2.动态混入
  *         a.调用当前类超类构造器
  *         b.当前类构造器
  *         c.第一个特质的父特质构造器
  *         d.第一个特质构造器
  *         e.第二个特质父特质构造器  如果已经执行过就不再执行
  *         f.第二个特质的构造器
  *         g 重复ef步骤
  *
  *
  *       DB main constructor...
  *       mysql_2 main constructor....
  *       DBConnection mmain constructor
  *       CRUD Parent constructor ...
  *       CRUD2 construct ...
  *       CRUD3 construct ...
  *
  */
  object TraitDemo {

  def main(args: Array[String]): Unit = {

    var mySql:MySql = new MySql
    println(mySql.close())
    println("=====================================")
    var mysql2:MySql_2 = new MySql_2 with DBConnection with CRUD_2 with CRUD_3 {
      override def createConnection(): Unit = {
        println("helllo")
      }

      override def close(): Boolean = {
        return false
      }
    }

//    var mysql2 = new MySql with CRUD {
//      override def add(id: Int): Unit = {
//        println("addd crud mysql ")
//      }
//
//      override var flag = false
//    }
//    mysql2.insert(2)


  }
}

//class Fruit_3 extends Serializable with Cloneable {
//
//
//}
trait CRUD_Parent{
  println("CRUD Parent constructor ...")
}
trait CRUD_2 extends CRUD_Parent{
  println("CRUD2 construct ...")
}
trait CRUD_3 extends CRUD_Parent{
  println("CRUD3 construct ...")
}
//特质中的字段 是直接被加入到对象中 抽象字段 则在具体的子类必须被重写
trait CRUD{

  println("crud construct...")
  var flag:Boolean
  var updated:Boolean = true
  def add(id:Int)

  def insert(id:Int):Boolean={
    println("insert id:"+id)
    return true
  }
}


/**
  * 当一个trait 有抽象方法和非抽象方法时
  * 编译有两个类 DBConnection.class  DBConnection$class.class 如果只有抽象方法时 只有一个类 DBConnection.class
  *
  *
  */
trait DBConnection {
  println("DBConnection mmain constructor")
  def createConnection()

  def close():Boolean

  //也可以有非抽象方法
  def showInfo(): Unit ={
    println("show info ...")
  }
}
class DB {
  println("DB main constructor...")
}
class MySql_2 extends DB {
  println("mysql_2 main constructor....")
}
class MySql extends DB with DBConnection with CRUD_2 with CRUD_3{
  println("mysql main constructor")
  override def createConnection(): Unit = {
    println("create mysql connection...")
  }

  override def close():Boolean = {
    println("mysql close ...")
    return true
  }
}

class DB2 extends DBConnection{
  override def createConnection(): Unit = {
    println("create DB2 connection...")
  }

  override def close():Boolean = {
    println("db2 close ...")
    return true
  }
}

class Oracle extends DBConnection{
  override def createConnection(): Unit = {
    println("create oracle connection ...")
  }

  override def close():Boolean = {
    println("oracle close ...")
    return true
  }
}

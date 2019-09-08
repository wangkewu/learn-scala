package com.wkw.function

object FunctionDefine {


  def main(args: Array[String]): Unit = {

    var z = sum(1, 2);
    var z1: Int = sum(2, 3);
    println(z+"\t"+z1)  ///3 5

//    var a:Int = sum2(2,3 ); //无返回类型
//    var b:Int = sum3(2,3 );//无返回值 类型 即使写return

//    var c:Int = sum4(5,4) // error 不能明确定义类型 只能使用自动类型判断
    var c = sum4(5,4)
    var d = sum4(10,10) ///自动判断类型
    println(c+"\t"+d)// 9  hello

    //函数形参 可以初始默认值 调用函数时 不指定实参 则会使用默认值  指定实参 就会覆盖默认值
    var s5 = sum5();// 形参默认值相加 15
    var s6 = sum5(10);//20
    var s7 = sum5(y=20);//指定覆盖哪个形参值 25
    println("s5:"+s5+"--s6:"++"--s7:"+s7)

    //可变参数函数 0 至多个
    sum6(0,1,2,3,4) //0 1 2 3 4
    sum6()
    println()
    //可变参数 1 至 多个  可变参数要放在形参后面
    var s8:Int = sum7(1,2,3,4,5); //15
    println(s8+" 可变参数1至多个")


    hello // hello or hello() ===》hell world
    //类里定义函数
    def hello(): Unit ={
      println("hello world")
      hellohello()
      def hellohello(): Unit ={
        println("函数里定义函数")
      }
    }
  }

  //自动判断返回类型  不能使用 return  返回值类型可以省略 :返回类型
  def sum1(x:Int, y:Int)  ={

    x+y
  }
  //return 关键字就不能省略返回类型
  def sum(x:Int, y:Int):Int={

    return x + y
  }
  //无返回值
  def sum2(x:Int, y:Int): Unit ={
    x+y
  }
  //无返回值 直接省略 返回值编写 即使return
  def sum3(x:Int, y:Int) {
    return x + y
  }

  //返回值类型不明确 直接 返回Any
  def sum4(x:Int, y:Int): Any={
    if ((x+y) > 16) {
      return "hello"
    } else {
      return x+y
    }
  }
  //形参指定初始值
  def sum5(x:Int=5, y:Int=10): Int={

    x+y
  }

  //支持0到多个参数
  def sum6(args:Int*): Unit ={

    for (item <- args) {
      print(item+" ----")
    }
  }
  //支持1 到多个参数
  def sum7(x:Int, args:Int*): Int = {
    var sum:Int = x;
    for(item <- args) {
      sum+=item;
    }
    return sum
  }
}

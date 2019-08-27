package com.wkw.basic

object Do_For {
  def main(args: Array[String]): Unit = {

    //前后闭合
    for (i <- 1 to 3) {
      print(i +" ") // 1 2 3
    }
    println()
    //前闭后开
    for (i <- 1 until 3){
      print(i +" ") // 1 2
    }
    println()
    //控制步长
    for (i <- Range(1, 10, 2)) {
      print(i +" ")// 1 3 5 7 9
    }
    println()
    //实现continue  循环守卫
    for (j <- 1 to 3 if j != 1) {
      print(j +" ") // 2 3
    }
    println()
    for (i <- 1 to 3; j = 10 - i) {
      print(j+" ") // 9 8 7
    }
    println()
    for (i <- 1 to 3) {
      var j = 10 -i
      print(j+" ");
    }
    println()
    //嵌套循环
    for (i <- 1 to 3; j <- 1 to 3) {
      println(i+"--->"+j) // 1--->1  1--->2 1--->3  2--->1
    }
    //嵌套循环
    for (i <- 1 to 3) {
      for(j <- 1 to 3) {
        println(i+"<----"+j)
      }
    }

    //循环 返回值
    var result = for (i <- 1 to 10) yield {
      i * 2
    }
    println(result) //1-10的数放大两倍
    /**
      * {} 和 ()对于for 表达式  都可以
      * 当有多个条件时 用大括号  只有一个条件时使用圆括号
      * 使用{} 不用写分号 换行就可以
      */
    for {
       i <- 1 to 3
       if i != 2 }{
      print(i +" ") // 1 3
    }
    println()

  }

}

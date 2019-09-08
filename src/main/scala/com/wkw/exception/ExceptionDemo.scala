package com.wkw.exception

/**
  * scala无编译期异常 这一种说法 异常都是运行时的异常
  *
  * try {
  * }catch {
  *   case e: Exception1 =>{
  *
  *   }
  *   case e: Exception2 =>{
  *
  *   }
  *   case e: Exception3 => println("如果只有一行可以这么写")
  * } finally{
  *     clear
  * }
  * Exception1 < Exception2 < Exception3
  */
object ExceptionDemo {

  def main(args: Array[String]): Unit = {
    //异常处理方式
    exception()
    try{
      exception1

    } catch {
      case e:ArithmeticException=>{
        println("处理除0异常")
      }
    }
    try {
//      customerException(1) //ArithmeticException
        customerException(-1) //InvalidScoreException
    } catch {

      case e:InvalidScoreException=>println(e)
      case e:ArithmeticException=>println(e)
    }

    println("end")
  }
  //声明异常
  @throws(classOf[InvalidScoreException])
  @throws(classOf[ArithmeticException])
  def customerException(score:Int) {
    if (score < 0)
      throw new InvalidScoreException("无效分数异常")

    if (score <10) {
      throw new ArithmeticException("不及格异常")
    }
  }
  def exception(): Unit ={
    try {
      1/ 0
    } catch {

      case e: ArithmeticException =>{
        println("除0异常")
      }
      case e: Exception =>{
        println("未知异常")
      }
    } finally {
      println("finally...")
    }
  }
  //声明异常
  @throws(classOf[ArithmeticException])
  @throws(classOf[InvalidScoreException])
  def exception1(): Nothing ={
    throw new ArithmeticException("除0异常抛出")
  }
}

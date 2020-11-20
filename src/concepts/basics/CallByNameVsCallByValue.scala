package concepts.basics

/**
 * Created by Abhisek Bastia on 5/4/2020.
 */
object CallByNameVsCallByValue extends App {
  def calledByValue(x: Long): Unit = {
    println("by value: " + 89503410558700000L)
    println("by value: " + 89503410558700000L)
  }

  def calledByName(x: => Long): Unit = {     // "=>" tells that parameter is called by name
    println("by name: " + System.nanoTime())
    println("by name: " + System.nanoTime())
  }

  calledByValue(1257387745764245L)
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(),34)  //It will crash and gives stackoverflow error
  printFirst(34, infinite())   //It will just print the first element as method takes the second parameter by name
}

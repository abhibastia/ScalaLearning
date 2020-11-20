package concepts.basics

/**
 * Created by Abhisek Bastia on 5/4/2020.
 */
object DefaultArguments extends  App{
  def fact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else fact(n-1, n*acc)

  val fact10 = fact(10, 2)
  println("Factorial of 10 is :"+fact10)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")
  savePicture(width = 800)

  savePicture(height = 600, width = 800, format = "bmp")  //we can change the order of parameters but the name should be there
  savePicture() //Default values are provided
}

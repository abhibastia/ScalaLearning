package concepts.oops

/**
 * Created by Abhisek Bastia on 5/7/2020.
 */
object MethodNotations extends App{
  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)
    def unary_! : String = s"$name, what the heck?!"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
    def learns(thing: String) = s"$name is learning $thing"
    def learnsScala = this learns "Scala"
  }


  val abhi = new Person("Abhi", "Cast Away")
  println(abhi.likes("Inception"))
  println(abhi likes "Inception") // equivalent
  // infix notation = operator notation (syntactic sugar)


  // "operators" in Scala
  val chikun = new Person("Chikun", "The Terminal")
  println(abhi + chikun)
  println(abhi.+(chikun))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS.
  // Akka actors have ! ?

  // prefix notation
  val x = -1  // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!abhi)
  println(abhi.unary_!)

  // postfix notation
  println(abhi.isAlive)
  println(abhi isAlive)

  // apply  object is called  as function
  println(abhi.apply())
  println(abhi()) // equivalent

  /*
    1.  Overload the + operator
        abhi + "the rockstar" => new person "Abhi (the rockstar)"
    2.  Add an age to the Person class
        Add a unary + operator => new person with the age + 1
        +abhi => abhi with the age incrementer
    3.  Add a "learns" method in the Person class => "Abhi learns Scala"
        Add a learnsScala method, calls learns method with "Scala".
        Use it in postfix notation.
    4.  Overload the apply method
        abhi.apply(2) => "Abhi watched Cast Away 2 times"
   */

  println((abhi + "the Rockstar").apply())
  println((+abhi).age)
  println(abhi learnsScala)
  println(abhi(10))
}

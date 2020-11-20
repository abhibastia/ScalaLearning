package concepts.oops

import misc.{PrinceCharming, Cinderella => Princess}

/**
 * Created by Abhisek Bastia on 5/13/2020.
 */
object PackagingAndImports extends App {

  import java.util.Date
  import java.sql.{Date => SqlDate}

    // package members are accessible by their simple name
    val writer = new Writer("Abhisek", "Bastia", 2018)

    // import the package
    val princess = new Princess  // playground.Cinderella = fully qualified name

    // packages are in hierarchy
    // matching folder structure.

    // package object
    sayHello
    println(SPEED_OF_LIGHT)

    // imports
    val prince = new PrinceCharming


    val date = new Date
    // 1. use FQ names
    //val sqlDate = new java.sql.Date(2018, 5, 4)
   // 2. use aliasing
    val sqlDate = new SqlDate(2020, 5, 4)
   println(sqlDate)

    // default imports
    // java.lang - String, Object, Exception
    // scala - Int, Nothing, Function
    // scala.Predef - println, ???
}

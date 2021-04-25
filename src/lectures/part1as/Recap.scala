package lectures.part1as

import scala.annotation.tailrec

object Recap extends App {
  val aCondition: Boolean = false
  val aConditionedVal = if (aCondition) 42 else 65
  // instructions vs expression

  // compiler infers types for us
  val aCodeBlock = {
    if (aCondition) 54
    56
  }

  // Unit = void
  val theUnit = println("hello, Scala")

  // function
  def aFunction(x: Int): Int = x + 1

  // recursion: stack and tail
  // It avoid to throw StackOverFlow with using `@tailrec`
  // When compile, make to convert to iteration such as using while.
  @tailrec def factorial(n: Int, acc: Int): Int =
    if (n <= 0) acc
    else factorial(n - 1, n * acc)

  // object-oriented programming
  class Animal
  class Dog extends Animal
  val aDog: Animal = new Dog // subtyping polymorphism

  trait Carnivore {
    def eat(a: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override def eat(a: Animal): Unit = println("crunch!")
  }

  // method notations
  val aCroc = new Crocodile
  aCroc eat aDog //natural language

  // anonymous classes
  val aCarnivore = new Carnivore {
    override def eat(a: Animal): Unit = println("roar!")
  }

  // generics
  abstract class MyList[+A] // variance and variance problems is THIS course
  // singletons and companions
  object MyList

  // case classes
  case class Person(name: String, age: Int)

  // exceptions and try/catch/finally
  val throwsException: Nothing = throw new RuntimeException // Nothing
  val aPotentialFailure =
    try {
      throw new RuntimeException
    } catch {
      case e: Exception => "I caught an exception"
    } finally {
      println("some logs")
    }

  // packaging and imports
  val incrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }

  incrementer(1)

  val anonymousIncrementer = (x: Int) => x + 1
  List(1, 2, 3).map(anonymousIncrementer) // higher order function
  // map, flatMap, filter

  // for-comprehension
  val pairs = for {
    num <- List(1, 2, 3) // if condition
    char <- List('a', 'b', 'c')
  } yield num + "-" + char

  // Scala collections: Seqs, Arrays, Lists, Vectors, Maps, Tuples
  val aMap = Map(
    "Daniel" -> 789,
    "Jess" -> 555
  )

  // collections" Options, Try
  val aOption = Some(2)

  // pattern matching
  val x = 2
  val order = x match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => x + "th"
  }

  val bob = Person("bob", 22)
  val greeting = bob match {
    case Person(n, _) => s"hi, my name is $n"
  }

}

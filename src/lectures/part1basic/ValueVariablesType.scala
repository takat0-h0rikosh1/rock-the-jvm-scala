package lectures.part1basic

object ValueVariablesType extends App {
  val x: Int = 42
  println(x)
  // vals are immutables
  // compiler can infer types

  val aString: String = "hello"
  val anotherString = "googBye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 4187140187417419741L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4
  aVariable = 5 // side effects
}

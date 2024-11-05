// Databricks notebook source
def f(x: Int): Int = x * 2
def g(x: Int): Int = x + 2
def h(x: Int): Int = f(g(x))

// COMMAND ----------

val input = 4
println(s"g($input) = ${g(input)}")
println(s"f(g($input)) = ${f(g(input))}")
println(s"h($input) = ${h(input)}")

// COMMAND ----------

val name: String = "Scala"
val age: Int = 25

// COMMAND ----------

def add(x: Int, y: Int): Int = x + y
val sum = add(10, 20)

// COMMAND ----------

val x = 10
val y = 20
val z = x + y

// COMMAND ----------

trait Shape {
  def area(): Int
}

class Square(length: Int) extends Shape {
  def area = length * length
}

class Rectangle(length: Int, width: Int) extends Shape {
  def area = length * width
}

val square = new Square(10)
val rect = new Rectangle(10, 20)

val square_area = square.area
val rect_area = rect.area

// COMMAND ----------

val twoElements = ("10", true)
val threeElements = ("10", "harry", true)

// COMMAND ----------

val first = threeElements._1
val second = threeElements._2
val third = threeElements._3

// COMMAND ----------

var arr = Array(10, 20, 30, 40)

arr(0)

// COMMAND ----------

var xs = List(10, 20, 30, 40)

// COMMAND ----------

val ys = (1 to 100).toList

// COMMAND ----------

val zs = arr.toList

// COMMAND ----------

val v1 = Vector(0, 10, 20, 30, 40)

// COMMAND ----------

val v2 = v1 :+ 50

// COMMAND ----------

val v3 = v2(5)

// COMMAND ----------

val fruits = Set("apple", "orange", "pear", "banana")

// COMMAND ----------

fruits.contains("Ananas")

// COMMAND ----------

val capitals = Map("France" -> "Paris", "USA" -> "Washington D.C.", "UK" -> "London")

// COMMAND ----------

capitals("France")

// COMMAND ----------

val myList = List(1.0, 2.0, 3.0, 4.0)
myList.map(_ * 10)

// COMMAND ----------

val myList2 = List(1, 2, 3, 4)
myList2.map(_ * 10.0)

// COMMAND ----------

val line = "Scala is fun"
val singleSpace = " "

val words = line.split(singleSpace)

val arrOfListOfChars = words.map(x => x.toList)
val arrayOfChars = words.flatMap(x => x.toList)

// COMMAND ----------

val myNewList = (1 to 100).toList

// COMMAND ----------

val even = myNewList.filter(_ % 2 == 0)

// COMMAND ----------

words.foreach(println(_))

// COMMAND ----------

val reduceList = List(2, 4, 6, 8, 10)
val mul = reduceList.reduce((x, y) => x * y)

// COMMAND ----------

val min = reduceList.min
val max = reduceList.max

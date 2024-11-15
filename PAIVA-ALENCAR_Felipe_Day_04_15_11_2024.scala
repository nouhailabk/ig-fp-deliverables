// Databricks notebook source
def multiply(a: Int, b: Int): Int = a * b

// COMMAND ----------

val res = multiply(3, 5)

// COMMAND ----------

val res2 = multiply(3, 4)

// COMMAND ----------

var total = 0

def addToTotal(a: Int) = {
  total += a
  total
}

// COMMAND ----------

val res3 = addToTotal(5)

// COMMAND ----------

val list = List(1, 2 ,3)

// COMMAND ----------

val newList = 0 :: list

// COMMAND ----------

def applyTwice(f: Int => Int, x: Int): Int = f(f(x))

// COMMAND ----------

val increment = (x: Int) => x + 1

// COMMAND ----------

println(applyTwice(increment, 5))

// COMMAND ----------

def multiplier(factor: Int): Int => Int = {
  (x: Int) => x * factor
}

// COMMAND ----------

val triple = multiplier(3)

// COMMAND ----------

println(triple(30))

// COMMAND ----------

val anon = (x: Int, y: Int) => x + y

anon(4, 5)

// COMMAND ----------

val numbers = List(1, 2 , 3)
val hello = numbers.map(_ + 1)
println(hello)

// COMMAND ----------

def add(x: Int)(y: Int): Int = x + y

// COMMAND ----------

add(10)(20)

val res5 = add(10)_
val res6 = res5(60)

// COMMAND ----------

def log(level: String)(message: String): Unit = {
  println(s"[$level] $message")
}

val infoLog = log("INFO")_
val errorLog = log("ERROR")_

infoLog("Hello, World!")
errorLog("Kernel Panic!")

// COMMAND ----------

val numbers = List(1, 2, 3, 4, 5)
val doubledEvens = numbers.collect { case x if x % 2 == 0 => x * 2 }
println(doubledEvens)

// COMMAND ----------

val evens = numbers.filter(_ % 2 == 0)
val odds = numbers.filterNot(_ % 2 == 0)

// COMMAND ----------

val lessThanFour = numbers.takeWhile(_ < 4)
println(lessThanFour)

// COMMAND ----------

val fromFourOnwards = numbers.dropWhile(_ < 4)
println(fromFourOnwards)

// COMMAND ----------

val sum = numbers.reduce(_ + _)
println(sum)

// COMMAND ----------

val words = List("Scala", "is", "fun")
val sentence = words.foldLeft("Programming in")(_ + " " + _)
val sentence2 = words.foldRight("!")(_ + " " + _)

// COMMAND ----------

val maxNumber = numbers.reduceLeft((x, y) => if (x > y) x else y)
println(maxNumber)

// COMMAND ----------

val sumOfSquares = numbers.aggregate(0)(
  (acc, num) => acc + num * num,
  (acc1, acc2) => acc1 + acc2
)
println(sumOfSquares)

// COMMAND ----------

val ages = Map("Faaiz" -> 42, "Vincent" -> 9, "Joe" -> 10)



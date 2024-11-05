// Databricks notebook source
println("Hello World")

// COMMAND ----------

var x = 1

// COMMAND ----------

x = 20

// COMMAND ----------

val y = 5

// COMMAND ----------

y = 10

// COMMAND ----------

def add(firstInput: Int, secondInput: Int): Int = {
  val sum = firstInput + secondInput
  return sum
}

// COMMAND ----------

val addNumbers = add(5376, 6256)

// COMMAND ----------

def addSimple(firstInput: Int, secondInput: Int) = firstInput + secondInput

// COMMAND ----------

val addTwoNumbers = addSimple(10, 3)

// COMMAND ----------

def encode(n: Int, f: (Int) => Long): Long = {
  val x = n * 10
  f(x)
}

// COMMAND ----------

encode(10, (x: Int) => {x+100})

// COMMAND ----------

encode(5, (x: Int) => x + 100)

// COMMAND ----------

encode(5, (x) => x + 100)

// COMMAND ----------

encode(5, _ + 100)

// COMMAND ----------

class Car(mk: String, ml: String, cr: String) {
  val make = mk
  val model = ml
  var color = cr
  def repaint(newColor: String) = {
    color = newColor
  }
}

// COMMAND ----------

val mustang = new Car("Ford", "Mustang", "Red")
val corvette = new Car("GM", "Corvette", "Black")

// COMMAND ----------

corvette.repaint("Yellow")

// COMMAND ----------

case class Message(from: String, to: String, content: String)

// COMMAND ----------

val request = Message("harry", "sam", "discussion")

// COMMAND ----------

def colorToNumber(color: String): Int = {
  val num = color match {
    case "Red" => 1
    case "Blue" => 2
    case "Green" => 3
    case "Yellow" => 4
    case _ => 0
  }
  num
}

// COMMAND ----------

colorToNumber("Red")

// COMMAND ----------

def f(x: Int, y: Int, operator: String): Double = {
  operator match {
    case "+" => x + y
    case "-" => x - y
    case "*" => x * y
    case "/" => x / y.toDouble
  }
}

// COMMAND ----------

val sum = f(10, 20, "+")
val product = f(10, 20, "*")

// COMMAND ----------

import 

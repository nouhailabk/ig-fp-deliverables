// Databricks notebook source
import org.apache.spark.sql.SparkSession

// COMMAND ----------

val logFile = "/FileStore/tables/README.md"
// val spark = SparkSession.builder
//   .appName("Simple Application")
//   .master("local[*]")
//   .getOrCreate()

spark.sparkContext.setLogLevel("ERROR")

val logData = spark.read.textFile(logFile).cache()
val numAs = logData.filter(line => line.contains("a")).count()
val numBs = logData.filter(line => line.contains("b")).count()
println(s"Lines with a: $numAs, Lines with b: $numBs")
// spark.stop()

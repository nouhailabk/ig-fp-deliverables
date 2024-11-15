// Databricks notebook source
val df = spark.read.option("header", "true").csv("/FileStore/data.csv")

// Filter users aged 25 and above
val filteredDf = df.filter($"age" >= 25)

// Transform data to extract names and cities
val transformedDf = filteredDf.select($"name", $"city")

// Group users by city
val groupedDf = transformedDf.groupBy($"city").count()

// Print the result
groupedDf.show()


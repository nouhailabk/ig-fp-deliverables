// Databricks notebook source
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}

// COMMAND ----------

val csvDataFile = "/FileStore/tables/stackoverflow.csv" 

val df = spark.read
      .option("header", "false")
      .option("inferSchema", "true")
      .csv(csvDataFile)

println(s"\nCount of records in CSV file: ${df.count()}")

df.printSchema()
df.show(5)

// COMMAND ----------

val schema = new StructType()
  .add("postTypeId", IntegerType)
  .add("id", IntegerType)
  .add("acceptedAnswer", StringType)
  .add("parentId", IntegerType)
  .add("score", IntegerType)
  .add("tag", StringType)

// COMMAND ----------

val df = spark.read
  .option("header", "false")
  .schema(schema)
  .csv(csvDataFile)
  .drop("acceptedAnswer")


println(s"\nCount of records in CSV file: ${df.count()}")
df.printSchema()
df.show(5)

// COMMAND ----------

import spark.implicits._

println("")

val highScorePosts = df.filter(col("score") > 20)
highScorePosts.show(20)

// COMMAND ----------

df.createOrReplaceTempView("stackoverflow")

// COMMAND ----------

val popularTags = spark.sql("""
  SELECT tag, COUNT(*) as frequency
  FROM stackoverflow
  WHERE tag IS NOT NULL
  GROUP BY tag
  ORDER BY frequency DESC
  LIMIT 10
""")
popularTags.show()

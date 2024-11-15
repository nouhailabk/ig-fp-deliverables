// Databricks notebook source
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

// COMMAND ----------

val inputFolder = "/FileStore/cve"
val outputFile = "/FileStore/filter-cve.json"

val inputDF = spark.read.option("multiline", "true").json(inputFolder)

println(inputDF)

val filteredDF = inputDF
  .select(explode(col("CVE_Items")).as("item"))
  .select(
    col("item.cve.CVE_data_meta.ID").as("ID"),
    col("item.impact.baseMetricV3.cvssV3.baseScore").as("baseScore"),
    col("item.impact.baseMetricV3.cvssV3.baseSeverity").as("baseSeverity"),
    col("item.impact.baseMetricV2.exploitabilityScore").as("exploitabilityScore"),
    col("item.impact.baseMetricV2.impactScore").as("impactScore")
  )

filteredDF.coalesce(1)
  .write
  .mode("overwrite")
  .json(outputFile)

// COMMAND ----------

display(filteredDF)

package com.atguigu.spark1015.RDD.KV

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author atguigu
 * Date 2020/3/14 10:18
 */
object GroupByKey {
    def main(args: Array[String]): Unit = {
        val conf: SparkConf = new SparkConf().setAppName("GroupByKey").setMaster("local[2]")
        val sc: SparkContext = new SparkContext(conf)
        val rdd1 = sc.parallelize(Array("hello", "hello", "world", "hello", "atguigu", "hello", "atguigu", "atguigu"))
        val wordOne= rdd1.map((_, 1))
        val wordOneGrouped = wordOne.groupByKey().mapValues(_.sum)
        wordOneGrouped.collect.foreach(println)
        sc.stop()

    }
}

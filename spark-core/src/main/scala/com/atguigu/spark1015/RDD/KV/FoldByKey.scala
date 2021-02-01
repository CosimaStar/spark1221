package com.atguigu.spark1015.RDD.KV

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author atguigu
 * Date 2020/3/14 10:39
 */
object FoldByKey {
    def main(args: Array[String]): Unit = {
        val conf: SparkConf = new SparkConf().setAppName("GroupByKey").setMaster("local[4]")
        val sc: SparkContext = new SparkContext(conf)
        val rdd1 = sc.parallelize(Array("hello", "hello", "world", "hello", "atguigu", "hello", "atguigu", "hello"))
        val wordOne = rdd1.map((_, 1))

        val result = wordOne.foldByKey(1)(_ + _)
        result.collect.foreach(println)

        sc.stop()
    }
}

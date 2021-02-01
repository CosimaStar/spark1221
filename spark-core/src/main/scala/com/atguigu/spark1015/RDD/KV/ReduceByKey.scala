package com.atguigu.spark1015.RDD.KV

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
/*
  Array((hello,1), (hello,1), (world,1), (hello,1), (atguigu,1), (hello,1), (atguigu,1), (atguigu,1))

 */
object ReduceByKey {
    def main(args: Array[String]): Unit = {
        val conf: SparkConf = new SparkConf().setAppName("ReduceByKey").setMaster("local[2]")
        val sc: SparkContext = new SparkContext(conf)
        val rdd1 = sc.parallelize(Array("hello", "hello", "world", "hello", "atguigu", "hello", "atguigu", "atguigu"))
        val wordOne= rdd1.map((_, 1))
        val rdd2 = wordOne.reduceByKey((x,y)=>4)  //分组  两两相加
        rdd2.collect.foreach(println)
        sc.stop()


    }
}

package com.atguigu.spark1015

import org.apache.spark.{SparkConf, SparkContext}

object test {
  def main(args: Array[String]): Unit = {
    val conf =new SparkConf().setMaster("local[2]").setAppName("sparkconf")
    val sc =new SparkContext(conf)

    val rd = sc.makeRDD(List(2, 4, 6, 8))
    rd.collect.foreach(println)


  }
}



package com.atguigu.spark1015.RDD.single

import org.apache.spark.{SparkConf, SparkContext}

object Test {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("SortBy").setMaster("local[2]")
    val sc: SparkContext = new SparkContext(conf)
    val rdd1 = sc.parallelize(new Person(10, "lisi") :: new Person(20, "zs") :: new Person(15, "ww") :: Nil)

    implicit val ord:Ordering[Person] = new Ordering[Person] {
      override def compare(x: Person, y: Person): Int = x.age - y.age
    }
    val rdd2 = rdd1.sortBy(x => x)

    rdd2.collect.foreach(println)

    sc.stop()
  }
}
case class Person1(age:Int,name:String)
package com.atguigu.spark.streaming.day01.kafka


import kafka.serializer.StringDecoder
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @Author: ****
 * @Date: 2021/2/1-15:27
 * @Description:
 * @version: 1.0
 */
object WordCount1 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[2]").setAppName("WordCount1")
    val ssc = new StreamingContext(conf, Seconds(3))
    val params = Map[String, String](
      "bootstrap.servers" -> "hadoop102:9092",
      "group.id" ->"1015"
    )
    val sourceStream = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](
      ssc,
      params,
      Set("first1015")
    ).flatMap{
      case (_, v) => v.split("\\W+")
    }.map((_,1)).reduceByKey(_+_)
    sourceStream.print()
    ssc.start()
    ssc.awaitTermination()


  }
}

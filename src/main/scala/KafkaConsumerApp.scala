import java.util.Properties

import org.apache.kafka.clients.consumer.{ConsumerRecord, ConsumerRecords, KafkaConsumer}
import org.apache.kafka.common.serialization.StringDeserializer
import scala.collection.JavaConverters._
import scala.collection.JavaConversions._

/**
  * Created by James Yang on 08/04/2017.
  */
object KafkaConsumerApp extends App{

  val prop = new Properties()
  prop.setProperty("bootstrap.servers", "127.0.0.1:9092")
  prop.setProperty("key.deserializer", classOf[StringDeserializer].getName)
  prop.setProperty("value.deserializer", classOf[StringDeserializer].getName)
  prop.setProperty("group.id", "test-2")
  prop.setProperty("enable.auto.commit", "true")
  // prop.setProperty("auto.commit.interval.ms", "1000")

  // start from the very beginning
  prop.setProperty("auto.offset.reset", "earliest")

  val consumer = new KafkaConsumer[String, String](prop)

  consumer.subscribe(List("second_topic").asJava)

  while(true) {
    val records: ConsumerRecords[String, String] = consumer.poll(100)
    records.toList.foreach(x => {
      println(s"RECORD KEY ${x.key()}")
      println(s"RECORD VALUE ${x.value()}")
      println(s"RECORD PARTITION ${x.partition()}")
      println(s"RECORD TOPIC ${x.topic()}")
      println(s"RECORD OFFSET ${x.offset()}")
      println()
    })
    // auto sync, so auto.commit.interval.ms don't need
    consumer.commitSync()
  }
}


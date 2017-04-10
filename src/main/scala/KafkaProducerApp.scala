import java.util.Properties

import KafkaProducerApp.record
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.kafka.common.serialization.StringSerializer

/**
  * Created by James Yang on 08/04/2017.
  */
object KafkaProducerApp extends App {
  val prop = new Properties()

  prop.setProperty("bootstrap.servers", "127.0.0.1:9092")
  prop.setProperty("key.serializer", classOf[StringSerializer].getName)
  prop.setProperty("value.serializer", classOf[StringSerializer].getName)
  prop.setProperty("ack", "1")
  prop.setProperty("retries", "3")


  val producer: KafkaProducer[String, String] = new KafkaProducer(prop)

  val record = new ProducerRecord[String, String]("second_topic", "3", "message test II")

  for (i <- 1 to 10) {
    val record = new ProducerRecord[String, String]("second_topic", i.toString, s"message partition test $i")
    producer.send(record)
  }

  producer.send(record)
  producer.flush()
  producer.close()
}

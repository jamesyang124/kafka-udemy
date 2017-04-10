name := "kafka-udemy"

version := "1.0"

scalaVersion := "2.11.8"

resolvers ++= Seq(
  Resolver.typesafeRepo("releases"),
  Resolver.sonatypeRepo("releases"),
  "Twitter" at "http://maven.twttr.com",
  "Maven Repository" at "https://mvnrepository.com/",
  "Maven Repository 2" at "http://repo1.maven.org/maven2/")

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka-clients" % "0.10.2.0"
)

scalacOptions := Seq("-target:jvm-1.8", "-encoding", "UTF-8", "-unchecked", "-deprecation", "-Xfuture", "-Yno-adapted-args", "-Ywarn-dead-code", "-Ywarn-numeric-widen", "-Ywarn-unused")
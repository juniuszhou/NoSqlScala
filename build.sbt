name := "NoSqlScala"

version := "1.0"

scalaVersion := "2.10.4"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "rediscala" at "http://dl.bintray.com/etaty/maven"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.10" % "2.3.10"

libraryDependencies += "com.etaty.rediscala" % "rediscala_2.10" % "1.4.0"

libraryDependencies += "org.mongodb" %% "casbah" % "2.8.1"

libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.7.12"

libraryDependencies += "redis.clients" % "jedis" % "2.7.2"

libraryDependencies += "org.apache.hbase" % "hbase-client" % "1.1.1"

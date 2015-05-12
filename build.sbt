name := "NoSqlScala"

version := "1.0"

scalaVersion := "2.10.4"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "rediscala" at "http://dl.bintray.com/etaty/maven"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.10" % "2.3.10"

libraryDependencies += "com.etaty.rediscala" % "rediscala_2.10" % "1.4.0"

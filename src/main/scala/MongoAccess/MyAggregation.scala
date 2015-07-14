package MongoAccess

import com.mongodb.casbah.AggregationOptions
import com.mongodb.casbah.commons.MongoDBObject

object MyAggregation {
  val tableName = "database1_table1"
  val coll = MongoCommon.getCollection(tableName)

  def aggregate(): Unit = {
    coll += MongoDBObject("title" -> "Programming in Scala" ,
      "author" -> "Martin",
      "pageViews" -> 50,
      "tags" -> ("scala", "functional", "JVM") ,
      "body" -> "...")
    coll += MongoDBObject("title" -> "Programming Clojure" ,
      "author" -> "Stuart",
      "pageViews" -> 35,
      "tags" -> ("clojure", "functional", "JVM") ,
      "body" -> "...")
    coll += MongoDBObject("title" -> "MongoDB: The Definitive Guide" ,
      "author" -> "Kristina",
      "pageViews" -> 90,
      "tags" -> ("databases", "nosql", "future") ,
      "body" -> "...")

    val aggregateOptions = AggregationOptions(AggregationOptions.CURSOR)

    val results = coll.aggregate(
      List(
        MongoDBObject("$project" ->
          MongoDBObject("author" -> 1, "tags" -> 1)
        ),
        MongoDBObject("$unwind" -> "$tags"),
        MongoDBObject("$group" ->
          MongoDBObject("_id" -> "$tags",
            "authors" -> MongoDBObject("$addToSet" -> "$author")
          )
        )
      ),
      aggregateOptions
    )

    for(result <- results) println(result)
  }

  def main (args: Array[String]) {
    aggregate()
  }
}

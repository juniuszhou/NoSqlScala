package MongoAccess

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.query.dsl.GeoCoords

/**
 * Created by junius on 15-5-16.
 */
object MyDSL {
  def basic(): Unit = {
    // Create a GeoJson geometry document
    val geo = MongoDBObject("$geometry" ->MongoDBObject("$type" -> "polygon",
        "coordinates" -> ((GeoCoords(74.2332, -75.23452), GeoCoords(123, 456),
          GeoCoords(74.2332, -75.23452)))))


    // Example
    val obj = "location" $geoWithin geo
    println(obj)
    //"location" $geoWithin $box((74.2332, -75.23452), (123, 456))
    //"location" $geoWithin $center ((50, 50), 10)
    //"location" $geoWithin $centerSphere ((50, 50), 10)
  }
  def main (args: Array[String]) {
    basic()
  }
}

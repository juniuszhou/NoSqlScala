package MongoAccess

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.MongoCollection

/**
 * Created by junius on 15-5-16.
 */
object MongoCommon {
  val address = "localhost"
  val port = 11223
  val database = "database1"
  def getCollection(name: String): MongoCollection = {
    val mongoClient = MongoClient(address, port)
    val db = mongoClient(database)
    db(name)
  }
}

package MongoAccess

import com.mongodb.casbah.commons.MongoDBObject

/**
 * Created by junius on 15-5-16.
 */
object BulkOps {
  val tableName = "database1_table1"
  val coll = MongoCommon.getCollection(tableName)

  def continuousOp(): Unit = {
    val builder = coll.initializeOrderedBulkOperation

    // some operations can be continuously called via builder.
    builder.find(MongoDBObject("x" -> 1))
      .update(MongoDBObject("x" -> 1, "x" -> 11))

    builder.find(MongoDBObject("x" -> 1))
      .replaceOne(MongoDBObject("x" -> 1))

      //.remove(MongoDBObject("x" -> 1))
  }
}

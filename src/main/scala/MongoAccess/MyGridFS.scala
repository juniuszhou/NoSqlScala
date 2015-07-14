package MongoAccess

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.MongoCollection
import com.mongodb.casbah.gridfs.GridFS

/**
 * GridFS is a specification for storing and retrieving files that exceed the BSON-document size limit of 16MB
 */

object MyGridFS {
 def main (args: Array[String]) {
   val address = "localhost"
   val port = 11223
   val database = "database1"
     val mongoClient = MongoClient(address, port)
   val db = mongoClient(database)

   val gridfs = GridFS(db)


  }
}

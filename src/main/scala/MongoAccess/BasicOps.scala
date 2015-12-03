package MongoAccess

import com.mongodb.{WriteConcern, WriteResult}
import com.mongodb.casbah.commons.MongoDBObject

object BasicOps{
  def main (args: Array[String]) {
    val tableName = "database1_table1"
    val coll = MongoCommon.getCollection(tableName)

    def insert() = {
      val a = MongoDBObject("x" -> 1)
      // error got via throw exception from insert operation
      val res: WriteResult = coll.insert(a)
      val error = res.getN
      println("if error",error.toString)
      println("insert result is ", res)
    }

    def insertWithConcern() = {
      val a = MongoDBObject("x" -> 1)
      // error got via throw exception from insert operation
      // write 2 times, 2 seconds timeout, fsync and journal.
      val concern = new WriteConcern(2, 2, true, true)
      val res: WriteResult = coll.insert(a)
      val error = res.getN
      println("if error",error.toString)
      println("insert result is ", res)
    }

    def find() = {
      coll.find().foreach(println(_))
    }

    def update() = {
      val old = MongoDBObject("x" -> 1)
      val updated = MongoDBObject("x" -> 11)
      coll.update(old, updated)
    }

    def remove() = {
      val cond = MongoDBObject("x" -> 1)
      coll.remove(cond)
    }
  }
}

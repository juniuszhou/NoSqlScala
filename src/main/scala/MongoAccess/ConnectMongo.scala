package MongoAccess

import com.mongodb.casbah.Imports._

/**
 * Created by junius on 15-5-14.
 */
object ConnectMongo {

  //connect to multiple server, driver will choose fit one.
  def multipleConn(): Unit = {
    val addr1 = new ServerAddress("localhost",11221)
    val addr2 = new ServerAddress("localhost",11222)
    val addr3 = new ServerAddress("localhost",11223)

    val client = MongoClient(List(addr1, addr2, addr3))

    // or via client URI object

    val mongoClientURI = MongoClientURI("mongodb://localhost:11221,localhost:11222,localhost:11223")
    val client2 = MongoClient(mongoClientURI)
  }
  def main(args: Array[String]) {
    // connection uri format
    // mongodb://[username:password@]host1[:port1][,host2[:port2]]/database.collection[?options]

    //val mongoClientURI = MongoClientURI("mongodb://localhost:11223")
    val mongoClient = MongoClient("localhost",11223)

    //get database
    val db1 = mongoClient("database1")
    //print all collections
    db1.collectionNames().foreach(println(_))

    //get a collection
    val coll = db1("database1_table1")
    //print all documents.
    coll.foreach(println(_))

    println("over")
  }
}

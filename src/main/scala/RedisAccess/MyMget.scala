package RedisAccess

import redis.clients.jedis.Jedis

/**
 * Created by junius on 15-11-13.
 */
object MyMget {
  def main (args: Array[String]) {
    val jedis = new Jedis()
    val list = List("a")
    //jedis.mget(list.toArray.asInstanceOf[java.util.ArrayList[Object]])

    val result = MyMgetJava.callMget(list.toArray)
    result.foreach(println)
  }
}

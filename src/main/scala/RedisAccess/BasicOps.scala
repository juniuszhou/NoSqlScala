package RedisAccess

import redis.RedisClient
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object BasicOps {
  def main(args: Array[String]) {
    implicit val akkaSystem = akka.actor.ActorSystem()

    val redis = RedisClient()

    redis.set("key1", "value1")
    val future = redis.get("key")

    val res = Await.result(future, Duration.Inf)

    res match {
      case Some(str) => println(new String(str.toArray))
      case None => println("got nothing")
    }

    
  }
}

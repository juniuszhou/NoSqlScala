package RedisAccess;

import redis.clients.jedis.Jedis;

/**
 * Created by junius on 15-11-13.
 */
public class MyMgetJava {
    public static void main(String[] args) {
        System.out.println("hello");
        Jedis jedis = new Jedis();
        String[] str = new String[2];
        str[0] = "0";
        str[1] = "1";
        jedis.mget(str);
    }

    public static String[] callMget(String[] args) {
        System.out.println("hello");
        Jedis jedis = new Jedis();
        String[] str = new String[2];
        str[0] = "0";
        str[1] = "1";
        //jedis.mget(str);
        return str;
    }
}

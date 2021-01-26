package learn.jedis.test;

import learn.jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {

    @Test
    public void test1(){
        Jedis jedis = new Jedis("localhost",6379);

        jedis.set("username","zhangsan");

        jedis.close();
    }

    @Test
    public void test2(){
        Jedis jedis = new Jedis("localhost",6379);//如果使用空参构造，默认值是"localhost",6379端口

        jedis.set("username","zhangsan");

        String username = jedis.get("username");

        //System.out.println(username);

        jedis.setex("activecode",20,"hehe");//将 activecode:hehe键值对存入redis,并且20秒后自动删除该键值

        jedis.close();
    }

    @Test
    public void test3(){
        Jedis jedis = new Jedis("localhost",6379);//如果使用空参构造，默认值是"localhost",6379端口

        jedis.hset("user","name","lisi");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","male");

        //获取
        String name = jedis.hget("user", "name");

        System.out.println(name);

        Map<String, String> user = jedis.hgetAll("user");

        Set<String> keyset = user.keySet();

        for(String key : keyset){
            String s = user.get(key);
            System.out.println(key+":"+s);
        }
        jedis.close();
    }

    @Test
    public void test4(){
        Jedis jedis = new Jedis("localhost",6379);//如果使用空参构造，默认值是"localhost",6379端口

        jedis.del("mylist");
        jedis.lpush("mylist","a","b","c");
        jedis.rpush("mylist","a","b","c");

        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        //list弹出
        String e1 = jedis.lpop("mylist");
        String e2 = jedis.rpop("mylist");

        List<String> mylist2 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist2);
        jedis.close();
    }

    @Test
    public void test5(){
        Jedis jedis = new Jedis("localhost",6379);//如果使用空参构造，默认值是"localhost",6379端口

        jedis.sadd("myset","java","php","c++");

        Set<String> myset = jedis.smembers("myset");

        for(String e : myset){
            System.out.println(e);
        }

        jedis.close();
    }

    @Test
    public void test7(){

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

        JedisPool jedisPool = new JedisPool(config,"localhost",6379);

        Jedis jedis = jedisPool.getResource();

        jedis.set("hehe","heihei" );

        jedis.close();
    }

    @Test
    public void test8(){

        //通过连接池工具类获取
        Jedis jedis = JedisPoolUtils.getJedis();

        jedis.set("hehe","heihei" );

        jedis.close();
    }
}

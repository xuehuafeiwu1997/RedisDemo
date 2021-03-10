package com.xmy;import redis.clients.jedis.Jedis;import java.util.Set;/** * @author xmy * @date 2021/3/10 3:18 下午 */public class TestPing {    //1. new Jedis对象即可    public static void main(String[] args) {        //依赖导入成功，jedis无法找到相应的依赖的情况下，重新启动idea就可以解决        //1.new Jedis对象        Jedis jedis = new Jedis("127.0.0.1",6379);        //jedis中所有的命令就是我们之前学习的所有指令        System.out.println(jedis.ping());        System.out.println("清空数据:" + jedis.flushDB());        System.out.println(jedis.exists("username") + "判断某个键是否存在");        System.out.println("新增<username,xmy>的键值对" + jedis.set("username","xmy"));        System.out.println("新增<password,123456>的键值对" + jedis.set("password","123456"));        System.out.print("系统中所有的键如下:");        Set<String> keys = jedis.keys("*");        System.out.println(keys);        System.out.println("删除键password"+jedis.del("password"));        System.out.println(jedis.exists("password") + "判断password键是否存在");        System.out.println("查看键username所存储的值的类型:" + jedis.type("username"));        System.out.println("随机返回key空间的一个:" + jedis.randomKey());        System.out.println("重命名key " + jedis.rename("username","name"));        System.out.println("取出改名后的name:"+jedis.get("name"));        System.out.println("按索引查询:"+jedis.select(0));        System.out.println("删除当前数据库中所有的key:" + jedis.flushDB());        System.out.println("返回当前数据库key的数目" + jedis.dbSize());        System.out.println("删除所有数据库中所有的key"+jedis.flushAll());    }}

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.*;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        // 键不能重复，值可以重复
        map.put("san", "张三");
        map.put("si", "李四");
        map.put("wu", "王五");
        map.put("wang", "老王");
        map.put("wang", "老王2");// 老王被覆盖
        map.put("lao", "老王");
        System.out.println("-------直接输出hashmap:-------");
        System.out.println(map);//{san=张三, wang=老王2, si=李四, lao=老王, wu=王五}
        /**
         * 遍历HashMap
         */
        // 1.获取Map中的所有键
        System.out.println("-------foreach获取Map中所有的键:------");
        Set<String> keys = map.keySet();                                       //TODO Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.print(key + "  ");//san  wang  si  lao  wu
        }
        System.out.println();//换行
        // 2.获取Map中所有值
        System.out.println("-------foreach获取Map中所有的值:------");
        Collection<String> values = map.values();                               //TODO  Collection<String> values = map.values();
        for (String value : values) {
            System.out.print(value + "  ");//张三  老王2  李四  老王  王五
        }
        System.out.println();//换行
        // 3.得到key的值的同时得到key所对应的值
        System.out.println("-------得到key的值的同时得到key所对应的值:-------");
        Set<String> keys2 = map.keySet();
        for (String key : keys2) {
            System.out.print(key + "：" + map.get(key) + "   ");//san：张三   wang：老王2   si：李四   lao：老王   wu：王五   san--张三

        }
        /**
         * 另外一种不常用的遍历方式
         */
        // 当我调用put(key,value)方法的时候，首先会把key和value封装到
        // Entry这个静态内部类对象中，把Entry对象再添加到数组中，所以我们想获取
        // map中的所有键值对，我们只要获取数组中的所有Entry对象，接下来
        // 调用Entry对象中的getKey()和getValue()方法就能获取键值对了
        Set<Map.Entry<String, String>> entrys = map.entrySet();//TODO  Collection<String> values = map.values();
        for (Map.Entry<String, String> entry : entrys) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
/*
wang--老王2
si--李四
lao--老王
wu--王五
 */
        /**
         * HashMap其他常用方法
         */
        System.out.println("after map.size()：" + map.size());//after map.size()：5
        System.out.println("after map.isEmpty()：" + map.isEmpty());//after map.isEmpty()：false
        System.out.println(map.remove("san"));//张三
        System.out.println("after map.remove()：" + map);//after map.remove()：{wang=老王2, si=李四, lao=老王, wu=王五}
        System.out.println("after map.get(si)：" + map.get("si"));//after map.get(si)：李四
        System.out.println("after map.containsKey(si)：" + map.containsKey("si"));//after map.containsKey(si)：true
        System.out.println("after containsValue(李四)：" + map.containsValue("李四"));//after containsValue(李四)：true
        System.out.println(map.replace("si", "李四2"));//李四
        System.out.println("after map.replace(si, 李四2):" + map);//after map.replace(si, 李四2):{wang=老王2, si=李四2, lao=老王, wu=王五}
    }

}
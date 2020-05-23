import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class FindFrequency {



    //用HashMap,key作为数字，对应value作为出现次数
    @Test
    public void t1() {
        int[] arr = {1, 1, 3, 5, 6, 6, 8, 8, 9, 2, 8, 3};
        HashMap<Integer, Integer> map = new HashMap<>();//数字key->次数value
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {//方法用于检查特定键是否被映射到HashMap。它将key元素作为参数，如果该元素在map中映射，则返回True。
                //20=Geeks 将字符串值映射到整数键。  4=15, Geeks=20 将整数值映射到字符串键。
                map.put(arr[i], map.get(arr[i]) + 1);//put 覆盖上一次的value(上一次的值会被返回).  get 返回一个Map对象中与指定键相关联的值
            } else {
                map.put(arr[i], 1);//没有映射相当于初始化value为1次，第一次出现
            }
        }
        System.out.println(map);//{1=2, 2=1, 3=2, 5=1, 6=2, 8=3, 9=1}
        System.out.println(map.values());//[2, 1, 2, 1, 2, 3, 1]
        Integer maxCount = Collections.max(map.values());
        Set<Integer> set = map.keySet();
        int num = arr[0];
        for (Integer i : set) {
            if (map.get(i) == maxCount) {
                num = i;
            }
        }
        System.out.println("num:" + num + ",出现次数:" + maxCount);
    }
    //先对数组排序，创建一个数组存放对应位置的重复值
    @Test
    public void t2() {
        int[] arr = {1, 1, 3, 5, 6, 6, 8, 8, 9, 2, 8, 3};
        Arrays.sort(arr);//先对数组排序
        int[] result = new int[arr.length];
        int index = 0;
        result[0] = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] > arr[i]) {
                index = i + 1;
                result[index] = 1;
            } else {
                result[index] = result[index] + 1;
            }
        }
        int maxCount = 0;
        int numIdex = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > maxCount) {
                maxCount = result[i];
                numIdex = i;
            }
        }
        int num = arr[numIdex];
        //
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(result));
        System.out.println("出现次数最多的值:" + num + ",次数:" + maxCount);
    }

    //创建一个对应的数组，来存储目标数组的重复个数
    @Test
    public void t3() {
        int[] arr = {1, 4, 3, 4, 6, 6, 6, 8, 8, 9, 2, 8, 8};
        int[] countArr = new int[arr.length];
        int countIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            countArr[i] = 1;
            int temp = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (i != j && temp == arr[j]) {
                    countArr[i] += 1;
                }
            }
            if (countArr[i] > countArr[countIndex]) {
                countIndex = i;
            }
        }
        System.out.println(Arrays.toString(countArr));
        System.out.println("countIndex:" + countIndex);

    }




}

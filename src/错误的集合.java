/*
集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，
导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，
导致集合丢失了一个整数并且有一个元素重复。

给定一个数组 nums 代表了集合 S 发生错误后的结果。
你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。

输入: nums = [1,2,2,4]
输出: [2,3]


给定数组的长度范围是 [2, 10000]。
给定的数组是无序的。
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] findErrorNums(int[] nums) {  
		int[] rs={0,0};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){     
			map.put(i+1,1);//写入数组长度的map对  初始化
        }
		 for(int i=0;i<nums.length;i++){             
            if(map.get(nums[i])==1){
                map.put(nums[i], 2);//  出现一次
            }else{
                map.put(nums[i],map.get(nums[i])+1);// 出现两次
            }
        }
		
		Set set = map.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()) {
        Map.Entry entry = (Map.Entry)it.next();
            if(entry.getValue().equals(3)) {// 出现两次
                 rs[0] = (int)entry.getKey();        
            }
            if(entry.getValue().equals(1)) {
                 rs[1] = (int)entry.getKey();        
            }
        }
 return rs;
	
    }
}

/*
具体思路：
1.创建一个用于统计nums中每个数字出现次数的数组count,注意count的长度要比nums数组的长度多1（因为nums中的数字是从1开始的）
2.遍历nums，统计每个数字出现次数。
3.遍历count,出现两次的为重复元素，出现0次的为错误元素。
*/
/*
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length+1];
        for(int num : nums) {
            count[num]++;
        }
        int[] res = new int[2];
        for(int i = 1; i <= nums.length; i++) {
            if(count[i] == 2) {
                res[0] = i;
            } else if(count[i] == 0) {
                res[1] = i;
            }
        }
        return res;
    }
}*/
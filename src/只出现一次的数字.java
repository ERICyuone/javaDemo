import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均   出现两次   。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class 只出现一次的数字 {


    public static void main(String[] args) {
        int[] tt = {2, 2, 1};
        System.out.println(singleNumber(tt));
    }

//    private static HashMap<Integer, Integer> map = new HashMap<>();
//
//    public static int singleNumber(int[] nums) {
//
//        for (int a : nums) {
//
//            if (map.get(a) == null) {
//                map.put(a, 0);
//            } else {
//                map.put(a, map.get(a) + 1);
//            }
//
//        }
//        Set<Integer> keys = map.keySet();
//        Iterator<Integer> itor = keys.iterator();//获取key的Iterator便利
//        while (itor.hasNext()) {//存在下一个值
//            int key = itor.next();//当前key值
//            if (map.get(key).equals(0)) {
//                return key;
//            }
//        }
//        return -1;
//    }


    /**
     * 方法二（去重法）：

     　　思路：利用HashSet的特性，删除重复的数组元素，最后剩下一个单独的元素，返回即可。
     * @param nums
     * @return
     */
//    public static int singleNumber(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!set.add(nums[i])) { // add成功返回true，如果set中已有相同数字，则add方法会返回false
//                set.remove(nums[i]); // 删除重复出现的数字
//            }
//        }
//        return set.iterator().next();
//    }


    /**
     * 方法四（异或法）：

     　　思路：根据异或运算的特点，相同的数字经过异或运算后结果为0，除单独出现一次的数字外，其他数字都是出现两次的，
     那么这些数字经过异或运算后结果一定是0。而任何数字与0进行异或运算都是该数字本身。所以对数组所有元素进行异或运算，运算结果就是题目的答案。
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }


}

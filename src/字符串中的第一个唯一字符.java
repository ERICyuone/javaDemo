import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 字符串中的第一个唯一字符 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String s) {
        //返回字符中indexof（string）中字串string在父串中首次出现的位置
        //lastIndexOf最后出现的位置
        int index = s.length();
        for (char k = 'a'; k <= 'z'; k++) {
            int p1 = s.indexOf(k);// -1 不存在
            int p2 = s.lastIndexOf(k);
            if (p1 == p2 && p1 != -1) {
                index = Math.min(index, p1);//存放扫描到的唯一字符位置，比较实用最小的（第一次出现的）
            }
        }
        if (index == s.length()) {
            return -1;
        }
        return index;
    }


}

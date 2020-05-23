import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 有效的字母异位词 {


    public boolean isAnagram(String s, String t) {
        //-------------------------------------------------------------------------------
        /*int size1 = s.length();
        int size2 = t.length();
        if (size1 != size2) return false;


        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < size1; i++) {
            char a = s.charAt(i);
            if (map.get(a) == null) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a) + 1);
            }
        }
        for (int j = 0; j < size2; j++) {
            char a = t.charAt(j);
            if (map.get(a) == null) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a) - 1);
            }
        }

        for (Map.Entry<Character, Integer> i : map.entrySet()) {
            if (i.getValue() != 0) {
                return false;
            }
        }

        return true;*/

        //-------------------------------------------------------------------------------
       /* char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);*/

        //-------------------------------------------------------------------------------

        int len1=s.length();
        int len2=t.length();
        if(len1!=len2)return false;
        int arr[]=new int [26];
        for(int i=0;i<len1;i++) {
//			实际上一个数组就够了
            arr[s.charAt(i)-'a']++;//字符转换成数据作为下标 该下标+1
            arr[t.charAt(i)-'a']--;
        }
        for(int i:arr) {
            if(i!=0)return false;
        }
        return true;


    }
}

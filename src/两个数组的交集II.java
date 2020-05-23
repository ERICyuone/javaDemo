import java.util.ArrayList;
import java.util.Arrays;

public class 两个数组的交集II {

    public static void main(String[] args) {
        int[] tt1 = {1, 2, 2, 1};
        int[] tt2 = {2, 2};
        int[] tt3 = intersect(tt1, tt2);
        for (int tt : tt3
                ) {
            System.out.println(tt);
        }

    }


    //排好序后比较移动指针
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int size1 = nums1.length;
        int size2 = nums2.length;
        ArrayList<Integer> array = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < size1 && j < size2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                array.add(nums1[i]);
                i++;
                j++;
            }

        }

        int[] rs = new int[array.size()];
        int k = 0;
        for (int ar : array) {
            rs[k] = ar;
            k++;
        }
        return rs;
    }

}

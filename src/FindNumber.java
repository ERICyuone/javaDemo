import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 顺序查找
 */
public class FindNumber {


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();   //获取开始时间
        int a[] = {1, 2, 14, 123414, 45435, 642, 2, 47, 46, 756, 87, 83, 5234, 23563, 4, 2, 4, 34, 3241, 5, 246};
        int fin = findNumb(a, 5);
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("++:" + fin);
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int findNumb(int a[], int num) {
        for (int i = 0; i < a.length; i++) {
            if (i == num)
                return i;
        }
        return -1;
    }


    public boolean Find(int target, int[][] array) {
        int[] n;
        int len = 0;
        // 计算一维数组长度
        for (int[] element : array) {
            len += element.length;
        }
        // 复制元素
        n = new int[len];
        int index = 0;
        for (int[] element : array) {
            for (int element2 : element) {
                n[index++] = element2;
            }
        }
        //暴力查找
//        for (int i = 0; i < len; i++) {
//            if (target == n[i]) {
//                return true;
//            }
//        }
//        return false;

        //二分查找 有序
        int low, high, mid;
        low = 0;
        high = len-1;
        while(low<=high)
        {
            mid = (low+high)/2;
            if(n[mid]==target)
                return true;
            if(n[mid]>target)
                high = mid-1;
            if(n[mid]<target)
                low = mid+1;
        }
        return false;




    }



}

/**
 * https://www.cnblogs.com/CBDoctor/p/4077574.html
 */

public class 快速排序算法 {
    public static void main(String[] args) {
        int[] ii = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};

        quick_sort(ii, 0, 9);
    }

    public static void quick_sort(int[] a, int left, int right) {
        //结束迭代
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;

        int temp = a[left];//设置基准值，将最左端元素作为基准值
        //先从右往左找一个小于6的数，再从左往右找一个大于6的数，然后交换他们。
        while (i != j) {
            //往左移位，直到大于temp
            while (i < j && a[j] >= temp) {
                j--;
            }
            //往右移位，直到小于temp
            while (i < j && a[i] <= temp) {
                i++;
            }
            if (i < j) {
                //交换彼此的数据
                int tt = a[i];
                a[i] = a[j];
                a[j] = tt;
            }

        }

        //交换基位数据
        int kk = a[i];
        a[i] = temp;
        a[left] = kk;

        //下一次迭代
        quick_sort(a, left, i - 1);//左半边
        quick_sort(a, j + 1, right);//右半边


    }
}


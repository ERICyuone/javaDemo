import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class ComparatorTest {

    /**
     * 原始数组:
     * [-1, 3, 3, -5, 7, 4, -9, -7]
     * Collections.reverse(arrayList):
     * [-7, -9, 4, 7, -5, 3, 3, -1]
     * Collections.sort(arrayList):
     * [-9, -7, -5, -1, 3, 3, 4, 7]
     * 定制排序后：
     * [7, 4, 3, 3, -1, -5, -7, -9]
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println("原始数组:");
        System.out.println(arrayList);
        // void reverse(List list)：反转
        Collections.reverse(arrayList);
        System.out.println("Collections.reverse(arrayList):");
        System.out.println(arrayList);

        // void sort(List list),按自然排序的升序排序
        Collections.sort(arrayList);
        System.out.println("Collections.sort(arrayList):");
        System.out.println(arrayList);//[-9, -7, -5, -1, 3, 3, 4, 7]
        // 定制排序的用法
        Collections.sort(arrayList, new Comparator<Integer>() {
            /**
             int compare(Object o1, Object o2) 返回一个基本类型的整型
             如果要按照升序排序，
             则o1 小于o2，返回-1（负数），相等返回0，01大于02返回1（正数）
             如果要按照降序排序
             则o1 小于o2，返回1（正数），相等返回0，01大于02返回-1（负数）
             */
            @Override
            public int compare(Integer o1, Integer o2) {
                //升序
//                return o2.compareTo(o1);//==return o2-o1;
                return o2-o1;
            }
        });
        System.out.println("定制排序后：");
        System.out.println(arrayList);

    }

}



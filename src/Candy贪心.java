import java.util.Arrays;
/**
 * N个孩子站成一排，给每个人设定一个权重（已知）。按照如下的规则分配糖果： (1)每个孩子至少分得一颗糖果 （2）权重较高的孩子，会比他的邻居获得更多的糖果。
 * 问：总共最少需要多少颗糖果？请分析算法思路，以及算法的时间，空间复杂度是多少。
 * 假设每个孩子分到的糖果数组为A[N]，初始化为{1}，因为每个人至少分到一颗糖。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 实现：
 * 1、与前面的邻居比较，前向遍历权重数组ratings，如果ratings[i]>ratings[i-1]，则A[i]=A[i-1]+1；
 * 2、与后面的邻居比较，后向遍历权重数组ratings，如果ratings[i]>ratings[i+1]且A[i]<A[i+1]+1，则更新A，A[i]=A[i+1]+1；
 * 3、对A求和即为最少需要的糖果。
 * ————————————————
 */

public class Candy贪心 {
    public static void main(String[] args) {
        int L[] = {3, 6, 3, 5, 6, 2};
        System.out.println(candy(L));
    }

    // 分别从两边遍历选取较大值，计算结果
    public static int candy(int[] ratings) {
        int L[] = new int[ratings.length];
        int R[] = new int[ratings.length];
        // 每人至少一个糖果
        Arrays.fill(L, 1);
        Arrays.fill(R, 1);
        for (int i = 1; i < ratings.length; i++)
            if (ratings[i] > ratings[i - 1])
                L[i] = L[i - 1] + 1;
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                R[i] = R[i + 1] + 1;
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++)
            sum += Math.max(L[i], R[i]);
        return sum;
    }
}

//泰波那契序列 Tn 定义如下： 
//
//T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
//
//给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
//
//输入：n = 4
//输出：4
//解释：
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4




import java.util.Arrays;

public class 第N个泰波那契数 {

    /********************************************************************/
    //本题是一道动态规划的经典入门题目，可以采用从上向下的记忆化搜索方式，也可以采用从下到上的动态规划解题。
    //见微知著，本题虽然简单，但是这两种思路对于动态规划的题目是十分重要的。
    //
    //0:记忆化搜索（顺着结果往下找）
    //通过一个数组，保存在递归过程中的大量重复计算，保证算法的时间复杂度。
    //
    private int[] memo;

    public int tribonacci(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return getTribonacci(n);
    }

    private int getTribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        if (memo[n] == -1) {
            memo[n] = getTribonacci(n - 1) + getTribonacci(n - 2) + getTribonacci(n - 3);
        }

        return memo[n];
    }


    /********************************************************************/
    //1.动态规划（反向递推）
    public int tribonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }



}

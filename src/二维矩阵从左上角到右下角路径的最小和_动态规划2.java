public class 二维矩阵从左上角到右下角路径的最小和_动态规划2 {
    /**
     * 题目
     给定一个矩阵m，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有路径中最小的路径和。
     * 思路：
     解法1中使用dp数组的空间大小为M*N，其实可以对dp数组的空间压缩至N，定义大小为N的dp数组，
     对于第一行，dp[i]=dp[i-1]+m[0][i],在求第二行中的 dp[i] 时可以覆盖第一行 dp[i] ,
     第二行dp[i]=Math.min（dp[i],dp[i-1]）+m[i][j]。
     * @param arr
     * @return
     */
    public static int shortestRoad1(int arr[][])
    {
        //m=arr[0].length
        //n=arr.length
        int dp[]=new int[arr[0].length];
        dp[0]=arr[0][0];
        for(int j=1;j<arr[0].length;j++)
        {
            dp[j]=dp[j-1]+arr[0][j];
            //求出第一行的dp
        }
        for(int i=1;i<arr.length;i++)
        {
            dp[0]=arr[i][0]+dp[0];
            //dp[0]代表每一行最左边的dp，
            //后一行的dp覆盖前一行的dp
            for(int j=1;j<arr[0].length;j++)
            {
                dp[j]=Math.min(dp[j-1]+arr[i][j], dp[j]+arr[i][j]);
            }
        }
        return dp[arr[0].length-1];
    }
    public static void main(String args[]) {
        int cost[][] = {
                { 1, 3, 4 },
                { 2, 1, 2 },
                { 4, 3, 1 }
        };
        System.out.println("达到矩阵右下角的最小成本 = " + shortestRoad1(cost));//7
    }
}



/* 1.0
/**
思路：

使用动态规划，定义 dp[M][N] , M ,N 分别代表矩阵的行和列数 dp[i][j] 表示从左上角到矩阵（i，j）位置是的最短路径和。
则可知 到（i，j）位置有两种情况：1）由（i-1，j）向下走，2）由（i，j-1）向右走，
所以dp[i][j]=Math.min（dp[i-1][j],dp[i][j-1]）+m[i][j];对于dp[0][j]
只能由 dp[0][j-1] 向右走，dp[i][0] 只能由 dp[i-1][0] 向下走。
所以 dp[0][j]=dp[0][j-1]+m[0][j], dp[i][0]=dp[i-1][0]+m[i][0].

public static int shortestRoad(int arr[][])
    {
        int dp[][]=new int [arr.length][arr[0].length];
        dp[0][0]=arr[0][0];
        for(int i=1;i<arr.length;i++)
        {
            dp[i][0]=dp[i-1][0]+arr[i][0];
            //第一列只能由上向下
        }
        for(int j=1;j<arr[0].length;j++)
        {
            dp[0][j]=dp[0][j-1]+arr[0][j];
            //第一行只能由左向右
        }
        for(int i=1;i<arr.length;i++)
            for(int j=1;j<arr[0].length;j++)
            {
                dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+arr[i][j];
            }

        return dp[arr.length-1][arr[0].length-1];
    }
————————————————
版权声明：本文为CSDN博主「HankingHu」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/u013309870/article/details/69569456
 */
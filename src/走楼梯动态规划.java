import java.util.*;

class 走楼梯动态规划 {

    public static void main(String[] args) {
        int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        String [] rs;

        System.out.println(minCostClimbingStairs(arr));

    }

    static int minCostClimbingStairs(int[] cost) {
        if(cost.length==0){
            return 0;
        }
        int[] res=new int[cost.length];
        res[0]=cost[0];
        res[1]=Math.min(cost[1],cost[0]+cost[1]);
        for(int i = 2 ;i<cost.length;i++){
            res[i]=cost[i]+Math.min(res[i-1],res[i-2]);
        }
        return Math.min(res[res.length-1],res[res.length-2]);
    }

}
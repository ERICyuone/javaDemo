import java.util.Arrays;

public class 零钱兑换 {

    public static class CoinsExchange {
        public static void main(String[] args) {
            int [] coins = {1,2,5,11};
            int amount = 12;
            int len = coins.length;
            int [] dp = new int[amount+1];
            Arrays.fill(dp,-1);
            dp[0] = 0;
            for(int i=1;i<=amount;i++){//迭代计算从1到amount的找钱数量
                int min = -1;
                for(int j=0;j<len;j++){//找i-coins[j]中大于零且最小的
                    if(i-coins[j] >= 0){
                        if(dp[i-coins[j]] >= 0){
                            if(min < 0){
                                min = dp[i-coins[j]]+1;
                            }else{
                                min = min-1 < dp[i-coins[j]]?min:dp[i-coins[j]]+1;
                            }
                        }
                    }
                }
                dp[i] = min;
            }
            System.out.println(dp[amount]);
        }
    }

}



public class 分糖果2 {
    //排排坐，分糖果。
    //
    //我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
    //
    //给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
    //
    //然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
    //
    //重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。
    // 注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
    //
    //返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
    //
    public static void main(String[] args) {


        System.out.println(distributeCandies(80,4));

    }

    static int[] distributeCandies(int candies, int num_people) {
        int[] np=new int[num_people];
        int index=0,sent=1;
        while(candies>0){//判断糖果是否足够
            if(candies>=sent){//糖果是否够发出去
                if(index>num_people-1) index=0;//到队伍最后 返回队首
                np[index]=np[index]+sent;//发的糖果和有的糖果相加
                candies=candies-sent;//糖果总数减去发掉的糖果数

            }else{
                if(index>num_people-1) index=0;//糖果不够发了，把剩下的发出去
                np[index]=np[index]+candies;
                candies=0;
            }
            index++;//下一个人
            sent++;//下一次要发的糖果数量
        }
        return np;
    }


}

/**
 * 动态规划之背包问题（两个限定条件）
 题目描述：

 维克多博士创造了一个裂变反应堆，可取用处于液体状态的放射性物质。反应堆的容量是V加仑。他有N瓶的放射性液体，每个都有一定的质量和一定的体积。当液体倒入反应堆时，也产生一些单位的能量。现在，维克多想要将能量输出最大化。但是，有一个限制条件。他研究了原子元素的物理知识和历史，认识到反应堆内放射性液体的总量不能超过特定的临界质量M，否则反应就会失控，并引发剧烈的爆炸。

 写一个算法，帮助他从反应堆获得最大的能量，而不会让他丢掉性命。

 输入：

 该函数/方法的输入包括六个参数------

 reactorCap，一个整数，表示反应堆的容量(V);

 numberOfRadLiquid,一个整数，表示现有小瓶的数量(N);

 criticalMass，一个整数，表示反应堆的最大临界质量(M);

 volumes，一个整数列表，按顺序表示N份放射性液体的体积;

 masses，一个整数列表，按顺序表示N份放射性液体的质量;

 energies,一个整数列表，按顺序表示N份放射性液体产生的能量。

 输出：

 返回一个整数，表示可给定的约束条件下从反应堆中产生的最大能量。

 示例：

 输入：

 reactorCap=100

 numberOfRadLiquid=5

 criticalMass=15

 volumes=[50,40,30,20,10]

 masses=[1,2,3,9,5]

 energies=[300,480,270,200,180]

 输出：

 960

 解释：

 通过选择1、2、5号瓶中的液体，产生的能量=300+480+180=960.

 这种液体组合产生的总体积=50+40+10=100，不大于reactorCap,造成反应堆中的总质量=1+2+5=8，

 不大于criticalMass。

 解答

 动态规划代码，在解决这道题时，我们应该使用三维vector向量F(k,i,j)F(k,i,j)表示k个物体在最大质量为i，
 最大体积为j时可以获得的最大能量，
 则其状态转移方程为F(k,i,j) = max(F(k,i,j),F(k-1,i,j),F(k,i-m(k),j-v(k)))F(k,i,j)=max(F(k,i,j),F(k−1,i,j),F(k,i−m(k),j−v(k))) 　　
 为简化代码，我使用二维vector表示当质量为i，体积为j时可以获得的最大能量。对状态（i，j）进行更新时，
 由于需要使用（i-m(k),j-v(k)）时的状态，所以我们从后往前进行更新。
 */


public class DynamicPlanningBackpackProblem
{
    public static void main(String[] args)
    {
        int reactorCap = 100; // 反应堆的容量（V）
        int numberOfRadLiquid = 5; // 现有小瓶数量（N）
        int criticalMass = 15; // 反应堆的最大临界质量（M）
        int volume[] = { 50, 40, 30, 20, 10 };// 体积
        int masses[] = { 1, 2, 3, 9, 5 };// 质量
        int energies[] = { 300, 480, 270, 200, 180 }; // 能量
        int energiesMax[] = { 0 }; // 输出最大能量

        getMaxEnergies(volume, reactorCap, masses, criticalMass, numberOfRadLiquid, energies, energiesMax);
        System.out.println("最大能量为:" + energiesMax[0]);
    }

    public static void getMaxEnergies(int volume[], int reactorCap, int masses[], int criticalMass,
                                      int numberOfRadLiquid, int energies[], int energiesMax[])
    {
        int i;
        int input[] = new int[numberOfRadLiquid]; // 构造待组合的数据
        for (i = 0; i < numberOfRadLiquid; i++) // 对应上面数据，input={0,1,2,3,4}
        {
            input[i] = i;
        }

        for (i = 1; i <= numberOfRadLiquid; i++) // 最大能量可能是由1、2、3、4、5个数据之和
        {
            int out[] = new int[i];
            combination(input, numberOfRadLiquid, i, out, i, volume, reactorCap, masses, criticalMass,
                    numberOfRadLiquid, energies, energiesMax);
        }

    }

    public static void combination(int input[], int inputLen, int m, int out[], int outLen,
                                   int volume[],int reactorCap, int masses[], int criticalMass, int numberOfRadLiquid, int energies[], int energiesMax[])
    {
        // 函数的含义是：获取数组input前inputLen部分的长度为m的组合数，并存储到out数组中
        // @input 输入待组合的数据，本例是{0,1,2,3,4}，数字代表数组的位置
        // @inputLen 截取input的前inputLen部分，比如inputLen=3，则截取input为{0,1,2}
        // @m 获取长度为m的组合，比如m=2,inputLen=3，则可能的情况有：{0,1}{0,2}{1,2}
        // @out 最后可能组合的结果。比如最开始输入，m=3，则out可能为{1,2,3}{1,2,4}等
        // @outLen out的长度
        // 其余参数均为题目所给
        if (m == 0) // 退出递归，已取到一种情况
        {
            // 判断该种情况下的能量和是否最大，同时又满足约束条件
            int volumeSum = 0, massesSum = 0, energiesSum = 0;
            for (int j = 0; j < outLen; j++) {
                volumeSum += volume[out[j]];
                massesSum += masses[out[j]];
                energiesSum += energies[out[j]];
            }
            if (volumeSum <= reactorCap && massesSum <= criticalMass)// 是否满足约束条件
            {
                if (energiesSum > energiesMax[0]) // 判断是否比上一个存储的值大
                {
                    energiesMax[0] = energiesSum;
                    for (int j = 0; j < outLen; j++) //
                    {
                        System.out.print(out[j]);// 输出能量最大时的组合
                        System.out.print(" ");

                    }
                    System.out.print(energiesMax[0]); // 输出最大能量
                    System.out.println("");
                }
            }

            return;
        }

        for (int i = inputLen; i >= m; i--) // 循环递归获取组合数
        {
            out[m - 1] = input[i - 1];
            combination(input, i - 1, m - 1, out, outLen, volume, reactorCap, masses, criticalMass, numberOfRadLiquid,
                    energies, energiesMax);
        }
    }
}

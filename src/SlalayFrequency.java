import java.io.*;
import java.util.Scanner;


/**
 * 某公司中有N名员工。给定所有员工工资的清单，财务人员要按照特定的顺序排列员工的工资。他按照工资的频次降序排列，
 * 即给定清单中所有频次较高的工资将在频次较低的工资之前出现。如果相同数量的员工都有相同的工资，则将按照给定清单中该工资第一次出现的顺序排列。

 输入：该函数/方法的输入包括两个参数num(一个整数，表示员工的人数)和salaries(一个正整数列表，表示N名员工的工资)。

 输出：返回一个正整数列表，该列表按照员工工资的频次排序。

 约束条件

 1<=num<=10^5

 1<=salaries[i]<=10^9

 0=<i<num

 用例：10,[20,40,26,25,40,20,40,20,40,25]

 输出：40 40 40 40 20 20 20 25 25 26
 */

public class SlalayFrequency
{
    public static void main(String[] args) {
        int num = 19;
        int slalay[] = { 10000, 20000, 40000, 30000, 30000, 30000, 40000, 20000, 50000, 50000, 50000, 50000, 60000,
                60000, 60000, 70000, 80000, 90000, 100000 };// 测试数据
        slalay = b(num, slalay); // 保存结果
        int i;
        System.out.println("输出结果为：");
        for (i = 0; i < num; i++)// 输出结果
        {
            System.out.print(" ");
            System.out.print(slalay[i]);
        }
    }

    public static int[] b(int num, int slalay[]) {
        int i, j, k;
        int temp_frequency;
        int temp_slalay;
        int frequency[] = new int[num]; // 频次
        for (i = 0; i < num; i++) // 给频次赋初值
        {
            frequency[i] = 0;
        }

        for (i = 0; i < num; i++) // 对已排序的数据统计频次
        {
            for (j = 0; j < num; j++) {
                if (slalay[i] == slalay[j])
                {
                    frequency[i]++;
                }
            }
        }

        for (i = 1; i < num; i++) // 对频次进行插入排序，同时根据频数交换的顺序排列原数据
        {
            temp_frequency = frequency[i];
            temp_slalay = slalay[i];
            j = i - 1;
            while (j >= 0 && temp_frequency > frequency[j]) //频次递减排序
            {
                frequency[j + 1] = frequency[j];
                slalay[j + 1] = slalay[j]; // 变换原数据
                j--;
            }
            frequency[j + 1] = temp_frequency;
            slalay[j + 1] = temp_slalay;
        }

        for (i = 1; i < num; i++) // 再进行一次插入排序
        {
            temp_slalay = slalay[i];
            j = i - 1;
            k = i - 1;
            while (k >= 0)
            {
                if (temp_slalay == slalay[k]) // 判断前半部分子序列是否存在当前当前数据
                {
                    while (j >= 0 && temp_slalay != slalay[j]) // 插入到相同的数的后面
                    {
                        slalay[j + 1] = slalay[j];
                        j--;
                    }
                    slalay[j + 1] = temp_slalay;
                    break; // 退出循环判断下个数
                }
                k--;
            }

        }

        return slalay;
    }
}
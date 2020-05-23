package DFS;

/**
 * ####求排列组合数
 * <p>
 * 假设给定3个数：1，2，3，求出其所有的排列组合情况。
 * <p>
 * 例如：
 * 1，1，1
 * 1，1，2
 * 1，1，3
 * 1，2，1
 * 1，2，2
 * 1，2，3
 * ……
 * <p>
 * 3，3，3
 * <p>
 * 这个问题也可以使用DFS算法求解。
 */
class DFSDemo {

    int[] num = new int[3];

    public void dfsExample(int index) {

        // 边界条件
        if (index == 3) {

            for (int i = 0; i < 3; i++) {
                System.out.print(num[i] + " ");
            }

            System.out.println();

            //走不下去了就 return了
            return;
        }

        for (int i = 1; i <= 3; i++) {
            num[index] = i;
            // index+1 枚举下一种情况
            dfsExample(index + 1);
        }

    }

    public static void main(String[] args) {
        DFSDemo dfsdemo = new DFSDemo();
        dfsdemo.dfsExample(0);
    }

}


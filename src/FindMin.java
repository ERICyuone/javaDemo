public class FindMin {

    public static void main(String[] args) {
        Integer[] in = new Integer[]{1, 2, 3};
        Double[] dou = new Double[]{1.2, 2.2, -1d};
        System.out.println(min(in));
        System.out.println(min(dou));

    }

    //    private <T> T getListFisrt(List<T> data)    这个<T> T 可以传入任何类型的List
//    参数T
//     *     第一个 表示是泛型
//     *     第二个 表示返回的是T类型的数据
//     *     第三个 限制参数类型为T
    private static <T extends Number & Comparable<? super T>> T min(T[] values) {
        if (values == null || values.length == 0) return null;
        T min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (min.compareTo(values[i]) > 0) min = values[i];
        }
        return min;
    }
}

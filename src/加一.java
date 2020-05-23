import java.util.ArrayList;

public class 加一 {

    public static void main(String[] args) {
        int[] in = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] out = plusOne(in);

        for (int o :
                out) {
            System.out.println(o);
        }

    }

    //    public static int[] plusOne(int[] digits) {
//        StringBuffer str = new StringBuffer();
//        for (int s : digits) {
//            str.append(s);
//        }
//
//        Integer s2i = Integer.parseInt(str.toString()) + 1;//转换有位数限制
//        String i2s = String.valueOf(s2i);
//
//        ArrayList<Integer> arry = new ArrayList<Integer>();
//        for (int j = 0; j < i2s.length(); j++) {
//            String ch = i2s.substring(j, j + 1);
//            arry.add(Integer.parseInt(ch));
//        }
//        int k = 0;
//        int[] rs = new int[arry.size()];
//        for (int arrya : arry) {
//            rs[k] = arrya;
//            k++;
//        }
//
//        return rs;
//    }
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[len + 1];
        res[0] = 1;
        return res;
    }


}

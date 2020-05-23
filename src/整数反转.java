/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 假设我们的环境只能存储 32 位有符号整数，
 * 其数值范围是 [−2(31),  2(31) − 1]。根据这个假设，
 * 如果反转后的整数溢出，则返回 0。
 */
public class 整数反转 {

    public static void main(String[] args) {
        int i=reverse(112);
        System.out.println(i);
    }

    public static int reverse(int x) {
        int r = 0;
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
            return 0;
        }
        while (x != 0) {
            r = 10 * r + x % 10;
            x = x / 10;
            if (r > Integer.MAX_VALUE / 10 && x > 0 ||
                    r == Integer.MAX_VALUE / 10 && x > 7 ||
                    r < Integer.MIN_VALUE / 10 && x < 0 ||
                    r == Integer.MIN_VALUE / 10 && x < -8) {
                return 0;
            }
        }
        return r;
    }

}

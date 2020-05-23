public class 移动零 {
    public static void main(String[] args) {
        int[] in = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//        System.out.println(moveZeroes(in));
    }


    public static void moveZeroes(int[] nums) {
        if (nums.length <= 0) {
            return;
        }

        int index = 0;

        for (int i = 0;i < nums.length;i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}

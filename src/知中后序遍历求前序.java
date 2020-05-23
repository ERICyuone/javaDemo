


/**
 * 二叉树的遍历方法
 * 前序遍历：根左右。先打印，再遍历左子树，再遍历右子树；
 * 中序遍历：左根右。先遍历左子树，再打印，再遍历右子树；
 * 后序遍历：左右根。先遍历左子树，再遍历右子树，再打印。
 */
public class 知中后序遍历求前序 {
    /**
     * [9,3,15,20,7]
     * [9,15,7,20,3]
     *
     * @return [3, 9, 20, null, null, 15, 7]
     */
    public static void main(String[] args) {
        int [] i={9,3,15,20,7};
        int [] j={9,15,7,20,3};
        preOrderTraverse1(buildTree(i,j));
        System.out.println();
    }


    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        return bt(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }


    public  static TreeNode bt(int[] inorder, int[] postorder, int in_l, int in_r, int p_l, int p_r) {
        if (in_l > in_r) return null;
        int root_val = postorder[p_r];
        TreeNode root = new TreeNode(root_val);
        if (in_r - in_l == 0) return root;
        int index = in_l;
        for (index = in_l; index <= in_r; index++) {
            if (inorder[index] == root_val) break;
        }
        int l_cnt = index - in_l;
        root.left = bt(inorder, postorder, in_l, index - 1, p_l, p_l + l_cnt - 1);
        root.right = bt(inorder, postorder, index + 1, in_r, p_l + l_cnt, p_r - 1);
        return root;//目前输出二叉树
    }

    public static void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "->");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }


    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }



}

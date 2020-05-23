import java.util.Stack;

public class 二叉树前中后输出 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
/**
 *                           G
 *                        /     \
 *                    D           M
 *                   /  \        /  \
 *                  A   F       H    Z
 *                     /
 *                    E
 */

    /**
     * 一、前序遍历
     * <p>
     * 　　访问顺序：先根节点，再左子树，最后右子树；上图的访问结果为：GDAFEMHZ。
     * <p>
     *
     * @param root
     */
    //1）递归实现
    public void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "->");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    //2）非递归实现
    public void preOrderTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                System.out.print(node.val + "->");
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                node = tem.right;
            }
        }
    }


    /**
     * 二、中序遍历
     * <p>
     * 　　访问顺序：先左子树，再根节点，最后右子树；上图的访问结果为：ADEFGHMZ。
     */

//1）递归实现
    public void inOrderTraverse1(TreeNode root) {
        if (root != null) {
            inOrderTraverse1(root.left);
            System.out.print(root.val + "->");
            inOrderTraverse1(root.right);
        }
    }
	/* 递归输出 存放到向量类里（长度可变数组）
	private void traverse(TreeNode root, int k, Vector v){
        if(root == null) return;
        if(root.left != null){
            traverse(root.left, k, v);
        }
        v.addElement(root.val);
        //System.out.print(root.val+"\t");
       
        if(root.right != null){
            traverse(root.right, k, v);
        }
    }*/

    //2）非递归实现
    public void inOrderTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                System.out.print(tem.val + "->");
                node = tem.right;
            }
        }
    }

    /**
     * 三、后序遍历
     * <p>
     * 　　访问顺序：先左子树，再右子树，最后根节点，上图的访问结果为：AEFDHZMG。
     */

//1）递归实现
    public void postOrderTraverse1(TreeNode root) {
        if (root != null) {
            postOrderTraverse1(root.left);
            postOrderTraverse1(root.right);
            System.out.print(root.val + "->");
        }
    }

    //2）非递归实现
    public void postOrderTraverse2(TreeNode root) {
        TreeNode cur, pre = null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                System.out.print(cur.val + "->");
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
        }
    }

}

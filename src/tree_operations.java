import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class tree_operations {


    public TreeNode create_new_tree_from_array(Integer[] values) {

        if (values.length == 0 || values[0] == null) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode node = q.peek();

            if (node.left == null) {

                node.left = new TreeNode(values[i]);
                if (values[i] != null) q.add(node.left);

            } else if (node.right == null) {

                node.right = new TreeNode(values[i]);
                if (values[i] != null) q.add(node.right);
                q.remove();

            }
        }
        return root;
    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if (root == null) return l;
        funcPostOrder(root, l);
        return l;
    }

    private void funcPostOrder(TreeNode c, List<Integer> l) {
        if (c.left != null && c.left.val != null) {
            funcPostOrder(c.left, l);
        }
        if (c.right != null) {
            funcPostOrder(c.right, l);
        }
        l.add(c.val);
    }

    public static void main(String args[]) throws IOException {

        tree_operations to = new tree_operations();

        Integer[] val = new Integer[]{3, 9, 20, null, null, 15, 7};

        System.out.println(to.postOrderTraversal(to.create_new_tree_from_array(val)));
    }
}

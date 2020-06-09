

/*
*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*
* */


import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfAnotherTree {

    public static boolean isSubtree(TreeNode s, TreeNode t) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(s);
        while (!q.isEmpty()) {

            if (q.peek().val == t.val) {
                boolean flag = checkFromSubTree(q.peek(), t);
                if (flag)
                    return true;
            }
            if (q.peek().left != null)
                q.offer(q.peek().left);

            if (q.peek().right != null)
                q.offer(q.peek().right);

            q.poll();
        }
        return false;
    }

    public static boolean checkFromSubTree(TreeNode s, TreeNode t) {

        if (s == null || t == null) {
            if (s == null && t == null)
                return true;
            else
                return false;
        }

        if ((s.val != t.val))
            return false;

        return checkFromSubTree(s.left, t.left) && checkFromSubTree(s.right, t.right);

    }


    public static void main(String args[]) {

        Integer[] t1 = new Integer[]{3, 4, 5, 1, 2};
        Integer[] t2 = new Integer[]{4, 1, 2};

        tree_operations to = new tree_operations();
        TreeNode s = to.create_new_tree_from_array(t1);
        TreeNode t = to.create_new_tree_from_array(t2);
        System.out.println(isSubtree(s, t));
    }
}
/*
public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    public boolean equals(TreeNode x,TreeNode y)
    {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }
    public boolean traverse(TreeNode s,TreeNode t)
    {
        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }
*/
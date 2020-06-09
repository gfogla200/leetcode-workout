

/*
*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*
* */

import java.util.*;

public class ZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int counter = 0;
        List res = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode[] temp = new TreeNode[q.size()];
            q.toArray(temp);
            q.clear();
            List currentLevel = new ArrayList<>();
            for (int i = 0; i < temp.length; i++) {

                currentLevel.add(temp[i].val);

                if (temp[i].left != null && temp[i].left.val != null)
                    q.add(temp[i].left);

                if (temp[i].right != null && temp[i].right.val != null)
                    q.add(temp[i].right);


            }
            if (counter % 2 != 0) {
                Collections.reverse(currentLevel);
            }
            counter += 1;
            res.add(currentLevel);


        }
        return res;
    }

    public static void main(String args[]) {

        tree_operations to = new tree_operations();

        Integer[] val = new Integer[]{3, 9, 20, null, null, 15, 7};
        System.out.println(zigzagLevelOrder(to.create_new_tree_from_array(val)));
    }
}

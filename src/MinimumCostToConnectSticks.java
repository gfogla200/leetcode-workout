

/*
*
You have some sticks with positive integer lengths.

You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action until there is one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.



Example 1:

Input: sticks = [2,4,3]
Output: 14
Example 2:

Input: sticks = [1,8,3,5]
Output: 30


Constraints:

1 <= sticks.length <= 10^4
1 <= sticks[i] <= 10^4
*
* */

import java.util.HashMap;
import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {

    public static int connectSticks(int[] sticks){

        if(sticks.length == 0)
            return 0;
        if(sticks.length == 1)
            return sticks[0];

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i =0 ;i<sticks.length;i++){
            q.offer(sticks[i]);
        }

        int res = 0;
        while (q.size()!=1){
            int s1 = q.poll();
            int s2 = q.poll();
            res += s1+s2;
            q.offer(s1+s2);
        }

        return res;
    }

    public static void main(String args[]){

        int[] arr = new int[]{2,4,3};
        System.out.println(connectSticks(arr));
    }
}

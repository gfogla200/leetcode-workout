

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

import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static int[][] kClosest(int[][] points, int K) {

        if (points.length == 0)
            return new int[0][0];

        PriorityQueue<Pair<int[], Double>> Q = new PriorityQueue<>(new Comparator<Pair<int[], Double>>() {
            public int compare(Pair<int[], Double> a1, Pair<int[], Double> a2) {
                return Double.compare(a1.getValue(),a2.getValue());
            }});

        for (int i = 0; i < points.length; i++) {
            double distance = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            Q.offer(new Pair<int[], Double>(points[i], distance));
        }

        int[][] res = new int[K][2];

        for (int i = 0; i < K; i++) {
            res[i] = Q.poll().getKey();
        }
        return res;

    }

    public static void main(String args[]) {

        int[][] arr = new int[][]{{1, 3}, {-2, 2}};
        int[][] res = kClosest(arr, 1);
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i][0] + " " + res[i][1]);
    }
}

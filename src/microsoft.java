

/*
*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
*
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Node {

    public int x;
    public int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class microsoft {

    /*
    public int minMeetingRooms(int[][] intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
          return 0;
        }

        // Min heap
        PriorityQueue<Integer> allocator =
            new PriorityQueue<Integer>(
                intervals.length,
                new Comparator<Integer>() {
                  public int compare(Integer a, Integer b) {
                    return a - b;
                  }
                });

        // Sort the intervals by start time
        Arrays.sort(
            intervals,
            new Comparator<int[]>() {
              public int compare(final int[] a, final int[] b) {
                return a[0] - b[0];
              }
            });

        // Add the first meeting
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

          // If the room due to free up the earliest is free, assign that room to this meeting.
          if (intervals[i][0] >= allocator.peek()) {
            allocator.poll();
          }

          // If a new room is to be assigned, then also we add to the heap,
          // If an old room is allocated, then also we have to add to the heap with updated end time.
          allocator.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }
    */

    public static int GetLargestSum(int[] array, int n)
        {
            int largestSum = 0;
            int previousSum = 0;

            for (int i = 0; i <= array.length - n; i++)
            {
                if (i == 0)
                {
                    for (int j = 0; j < n; j++)
                    {
                        largestSum += array[j];
                    }

                    previousSum = largestSum;
                }
                else
                {
                    int currentSum = previousSum - array[i - 1] + array[i + n - 1];
                    if (currentSum > largestSum)
                    {
                        largestSum = currentSum;
                    }
                    previousSum = currentSum;
                }
            }

            return largestSum;
        }

    public static void main(String args[]) {

        int[] arr = new int[]{-1, -5, -4, -5};
        System.out.println(GetLargestSum(arr, 2));

    }
}

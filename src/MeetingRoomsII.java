

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

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class MeetingRoomsII {

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

    public static int minMeetingRooms(int[][] intervals) {

        if (intervals.length == 0)
            return 0;

        int[][] startTime = intervals.clone();
        int[][] endTime = intervals.clone();

        Arrays.sort(startTime, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        Arrays.sort(endTime, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int count = 0;
        int max = Integer.MIN_VALUE;
        int i=0,j=0;

        while(i<intervals.length || j<intervals.length){

            if (i<intervals.length && (startTime[i][0] < endTime[j][1])){
                count++;
                i++;
            }
            else if (i<intervals.length && (startTime[i][0] == endTime[j][1])){
                i++;j++;
            }
            else {
                count--;
                j++;
            }

            if(max < count)
                max = count;

        }

        return max;
    }

    public static void main(String args[]) {

        int[][] arr = new int[][]{
                {0, 30}, {15, 20}, {5, 10}};
        System.out.println(minMeetingRooms(arr));
    }
}

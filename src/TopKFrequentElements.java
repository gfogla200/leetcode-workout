

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

import java.util.*;

public class TopKFrequentElements {

    public static List<Integer> topKFrequent(int[] nums, int k) {

        if (nums.length == 0)
            return new ArrayList<>();

        if(nums.length == 1){
            return Arrays.asList(nums[0]);
        }

        Arrays.sort(nums);
        List<Pair<Integer, Integer>> fromArray = new ArrayList<>();
        int currentInt = nums[0];
        int count = 1;
        for (int i=1;i<nums.length;i++){
            if (currentInt != nums[i]){
                fromArray.add(new Pair<>(currentInt, count));
                currentInt = nums[i];
                count = 1;
            }
            else
                count++;
        }

        fromArray.add(new Pair<>(nums[nums.length-1], count));
        System.out.println(fromArray);

        Collections.sort(fromArray, new Comparator<Pair<Integer, Integer>>(){
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
                return p2.getValue().compareTo(p1.getValue());
            }
        });

        System.out.println(fromArray);

        List<Integer> res = new ArrayList<>();

        for (int i=0;i<k;i++){
            res.add(fromArray.get(i).getKey());
        }

        return res;

    }

    public static void main(String args[]){

        int[] arr = new int[]{-1,-1,-1,-1,-1,1,1,1,2,2,3};
        System.out.println(topKFrequent(arr, 2));
    }

    /*
        public List<Integer> topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
          count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
          heap.add(n);
          if (heap.size() > k)
            heap.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
          top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
        }
    */
}

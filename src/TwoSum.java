

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

import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tracker = new HashMap<>();

        for(int i =0;i<nums.length;i++){

            int compliment = target - nums[i];
            if(tracker.containsKey(compliment)){
                return new int[]{tracker.get(compliment)+1, i+1};
            }

            tracker.put(nums[i], i);


        }

        return new int[]{};
    }

    public static void main(String args[]){

        int[] arr = new int[]{11,15,7,2};
        int[] res = twoSum(arr, 26);
        for(int i = 0;i<res.length;i++)
            System.out.println(res[i]);
    }
}

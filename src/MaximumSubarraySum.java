public class MaximumSubarraySum {

    public static int maxSubArray(int[] nums) {
        int max = nums[0], sum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (sum < 0 && nums[i] < 0 && sum > nums[i])
                continue;

            if (sum < 0 && nums[i] >= 0)
                sum = 0;

            if (sum < 0 && nums[i] < 0 && sum < nums[i])
                sum = nums[i];
            else
                sum += nums[i];

            if (max < sum)
                max = sum;
        }

        return max;
    }

    public static void main(String args[]){

        int[] arr = new int[]{-2,0};
        System.out.println(maxSubArray(arr));
    }
}

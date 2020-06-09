

/*
*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*
* */

import java.util.HashMap;

public class TrappingRainWater {

    public static int trw(int[] height) {

        if(height.length == 0)
            return 0;

        int[][] maxlr = new int[2][height.length];
        maxlr[0][0] = maxlr[1][height.length - 1] = 0;
        int maxL = 0, maxR = 0;
        for (int i = 1, j = height.length - 2; i < height.length; i++, j--) {

            if (maxL < height[i - 1])
                maxL = height[i - 1];

            if (maxR < height[j + 1])
                maxR = height[j + 1];

            maxlr[0][i] = maxL;
            maxlr[1][j] = maxR;
        }

//        for(int i = 0 ;i<maxlr.length;i++){
//            for(int j=0;j<maxlr[i].length;j++)
//                System.out.print(maxlr[i][j] + " ");
//            System.out.println();
//        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int diff = Math.min(maxlr[0][i], maxlr[1][i]) - height[i];
            res += diff > 0 ? diff : 0;
        }

        return res;
    }

    public static void main(String args[]) {

        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trw(arr));
    }
}

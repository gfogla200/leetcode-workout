

/*
*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lswrc(String s) {

        if(s.length() < 1)
            return 0;

        if(s.length() == 1)
            return 1;


        List checkList = new ArrayList<>();
        checkList.add(s.charAt(0));
        int res = checkList.size();
        int current_pos = 0;

        for(int j=1;j<s.length();j++){

            if(checkList.contains(s.charAt(j))){
                j = current_pos + checkList.indexOf(s.charAt(j));
                current_pos = j+1;
                checkList.removeAll(checkList);
                System.out.println(j +" "+current_pos);
            }
            else
                checkList.add(s.charAt(j));

            if (res < checkList.size())
                res = checkList.size();
        }

        return res;

    }

    public static void main(String args[]){

        int res = lswrc("dvdf");
        System.out.println(res);
    }
}



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
import java.util.Stack;

public class ValidParenthesis {

    public static boolean validParenthesis(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            int asciiVal = (int)(s.charAt(i));
            if (asciiVal == 40 || asciiVal == 91 || asciiVal == 123)
                st.push(s.charAt(i));
            else {
                if(st.empty())
                    return false;

                int pop = (int)(st.pop().charValue());

                if (asciiVal == 41 && pop != 40)
                    return false;

                if ((asciiVal == 125 && pop != 123) || (asciiVal == 93 && pop != 91))
                    return false;
            }

        }
        if(!st.empty())
            return false;

        return true;

//        Stack<Character> stack = new Stack<>();
//        for(char c:s.toCharArray()){
//            if(c=='(')
//                stack.push(')');
//            else if(c=='[')
//                stack.push(']');
//            else if(c=='{')
//                stack.push('}');
//            else if(stack.isEmpty() || stack.pop()!=c)
//                return false;
//            // System.out.println(c);
//        }
//        return stack.isEmpty();
    }

    public static void main(String args[]) {

        System.out.println(validParenthesis("()()[]"));
    }
}



/*
*
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"
Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
*
* */

import java.util.HashMap;

public class IntegerToEnglishWords {

    public static String numberToWords(int num) {

        if (num == 0)
            return "Zero";

        String[] words = new String[]{"", "Thousand ", "Million ", "Billion ", "Trillion "};

        int i = 0;
        StringBuilder res = new StringBuilder("");
        while (num != 0) {
            int threeDigit = num % 1000;
            if (threeDigit > 0)
                res.insert(0, words[i]);
            res.insert(0, getWordFor(threeDigit));
            i++;
            num = num / 1000;
        }
        return res.toString().trim();
    }

    public static String getWordFor(int nbr) {

        int firstTwo = nbr % 100;
        int last = nbr / 100;
        String res = getWordForDigit(last, false);
        if (last > 0)
            res = res.concat("Hundred ");

        if (firstTwo < 20 && firstTwo > 9) {
            res =  res.concat(getWordForTeen(firstTwo));
        } else {
            if (firstTwo > 19)
                res =  res.concat(getWordForDigit(firstTwo, true));

            res =  res.concat(getWordForDigit(firstTwo % 10, false));
        }

        return res;

    }

    public static String getWordForDigit(int nbr, boolean flag) {

        if (flag)
            switch (nbr/10) {

                case 2:
                    return "Twenty ";
                case 3:
                    return "Thirty ";
                case 4:
                    return "Forty ";
                case 5:
                    return "Fifty ";
                case 6:
                    return "Sixty ";
                case 7:
                    return "Seventy ";
                case 8:
                    return "Eighty ";
                case 9:
                    return "Ninety ";
            }
        else
            switch (nbr) {
                case 0:
                    return "";
                case 1:
                    return "One ";
                case 2:
                    return "Two ";
                case 3:
                    return "Three ";
                case 4:
                    return "Four ";
                case 5:
                    return "Five ";
                case 6:
                    return "Six ";
                case 7:
                    return "Seven ";
                case 8:
                    return "Eight ";
                case 9:
                    return "Nine ";
            }
        return "";
    }

    public static String getWordForTeen(int nbr) {

        switch (nbr) {
            case 10:
                return "Ten ";
            case 11:
                return "Eleven ";
            case 12:
                return "Twelve ";
            case 13:
                return "Thirteen ";
            case 14:
                return "Fourteen ";
            case 15:
                return "Fifteen ";
            case 16:
                return "Sixteen ";
            case 17:
                return "Seventeen ";
            case 18:
                return "Eighteen ";
            case 19:
                return "Nineteen ";
        }

        return "";
    }

    public static void main(String args[]) {

        System.out.println(numberToWords(1000000));
    }
}

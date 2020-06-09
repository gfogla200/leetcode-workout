/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

 */


public class LongestPalindromicSubstring {

    public static void main(String args[]) {
//        String s= "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
//        System.out.println(s.length()+" "+s.substring(995-397+1, 995));
        String s="babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        //Dp array for substring palindrome
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j >= 0; --j) {
                boolean startEqEnd = s.charAt(j) == s.charAt(i);

                if (i == j) {
                    //If the same char: 'a' is palindrome
                    dp[i][j] = true;
                } else if (i - j == 1) {
                    //If length 2: 'ab' is palindrome when 'a' == 'b'
                    dp[i][j] = startEqEnd;
                } else if (startEqEnd && dp[i - 1][j + 1]) {
                    //Otherwise: string is palindrome if s(i) == s(j) and substring s(j + 1, i - 1) is palindrome
                    dp[i][j] = true;
                }

                if (dp[i][j] && i - j > end - start ) {
                    end = i;
                    start = j;
                }
            }
            print(dp);
            System.out.println();
        }

        return s.substring(start, end + 1);
    }
//    public static String longestPalindrome(String s) {
//        int[][] dp = new int[s.length()][s.length()];
//        s = s.toLowerCase();
//        StringBuffer sb = new StringBuffer(s);
//        String rev = sb.reverse().toString();
//        int max = 0, pos = 0;
//
//        dp[0][0] = s.charAt(0) == rev.charAt(0) ? 1 : 0;
//
//
//        for (int i = 0; i < s.length(); i++) {
////            System.out.println(i + " ");
////            print(dp);
//            for (int j = 0; j < s.length(); j++) {
//
//                if (i == 0 && j == 0)
//                    continue;
//
//                if (i == 0) {
//                    if (s.charAt(i) == rev.charAt(j))
//                        dp[i][j] = 1;
//                    else
//                        dp[i][j] = dp[i][j - 1];
//
//                    if (dp[i][j] > max) {
//                        max = dp[i][j];
//                        pos = i;
//                    }
//                    continue;
//                }
//                if (j == 0) {
//                    if (s.charAt(i) == rev.charAt(j))
//                        dp[i][j] = 1;
//                    else
//                        dp[i][j] = dp[i - 1][j];
//                    if (dp[i][j] > max) {
//                        max = dp[i][j];
//                        pos = i;
//                    }
//                    continue;
//                }
//
//                if (s.charAt(i) == rev.charAt(j)) {
//                    dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), (dp[i - 1][j - 1] + 1));
//                    if (dp[i][j] > max) {
//                        max = dp[i][j];
//                        pos = i;
//                    }
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                    if (dp[i][j] > max) {
//                        max = dp[i][j];
//                        pos = i;
//                    }
//                }
//
//            }
//        }
////        print(dp);
//        System.out.println(pos + " " + max);
//        return s.substring(pos - max + 1, pos+1);
//    }

    static void print(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
    }
}

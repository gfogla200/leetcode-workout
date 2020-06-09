

/*
*
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.



Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]


Constraints:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.
*
* */

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class ReorderDataInLogFiles {

    public static String[] reorderLogFiles(String[] logs) {

        List<String> letter = new ArrayList<>();
        List<String> digit = new ArrayList<>();

        for (int i = 0; i < logs.length; i++) {
            int index = logs[i].indexOf(' ');
            char c = logs[i].charAt(index + 1);
            if (Character.isDigit(c)) {
                digit.add(logs[i]);
            } else {
                letter.add(logs[i]);
            }
        }

        Collections.sort(letter, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int index1 = s1.indexOf(' ');
                int index2 = s2.indexOf(' ');

                if (s1.substring(index1 + 1, s1.length()).equals(s2.substring(index2 + 1, s2.length())))
                    return s1.substring(0, index1 + 1).compareTo(s2.substring(0, index2 + 1));
                else
                    return s1.substring(index1 + 1, s1.length()).compareTo(s2.substring(index2 + 1, s2.length()));
            }
        });

        String[] res = new String[logs.length];
        int i = 0;
        for (String item : letter) {
            res[i] = item;
            i++;
        }

        for (String item : digit) {
            res[i] = item;
            i++;
        }


        return res;
    }

    public static void main(String args[]) {

        String[] arr = new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        String[] res = reorderLogFiles(arr);
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i]);
    }
}



/*
*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

*
* */

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
//        Map<Integer, List<String>> lengthWise = new HashMap();
//
//        for (int i = 0; i < s.length; i++) {
//            if (lengthWise.containsKey(s[i].length())) {
//                List<String> temp = lengthWise.get(s[i].length());
//                temp.add(s[i]);
//                lengthWise.put(s[i].length(), temp);
//            } else {
//                List<String> temp = new ArrayList<>();
//                temp.add(s[i]);
//                lengthWise.put(s[i].length(), temp);
//            }
//        }
//
//        List<List<String>> res = new ArrayList<>();
//
//        lengthWise.entrySet().forEach(entry -> {
//            List<String> temp = entry.getValue();
//            while (!temp.isEmpty()) {
//                Map<Character, Integer> check = new HashMap<>();
//                String firstChar = temp.get(0);
//
//                List<String> toAddToRes = new ArrayList<>();
//                toAddToRes.add(firstChar);
//
//                temp.remove(0);
//
//
//                for (char c : firstChar.toLowerCase().toCharArray()) {
//                    if (check.containsKey(c)) {
//                        check.put(c, check.get(c) + 1);
//                    } else {
//                        check.put(c, 1);
//                    }
//                }
//
//                check.entrySet().forEach(entryKey-> System.out.println(entryKey.getKey() + " " + entryKey.getValue()));
//                System.out.println();
//                System.out.println();
//
//                for (String item : temp) {
//                    AtomicBoolean toAdd = new AtomicBoolean(true);
//                    Map<Character, Integer> check2 = new HashMap<>();
//                    for (char itemChar : item.toLowerCase().toCharArray()) {
//                        check2.put(itemChar, check2.getOrDefault(itemChar, 0) + 1);
//                    }
//
//                    check.entrySet().forEach(key -> {
//                        if (key.getValue()!=check2.getOrDefault(key.getKey(), -1))
//                            toAdd.set(false);
//                    });
//
//                    if (toAdd.get()) {
//                        toAddToRes.add(item);
//                    }
//                }
//                res.add(toAddToRes);
//                for (String item : toAddToRes)
//                    temp.remove(item);
//
//            }
//        });
//
//        return res;

        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public static void main(String args[]) {

        String[] input = new String[]{"eat", "tea", "tan", "ate"};
        System.out.println(groupAnagrams(input));
    }
}

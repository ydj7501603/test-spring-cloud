package com.yindejin.algorithm.bfs;

import java.util.*;

/** 电话号码的字母组合
 * @author: YDJ
 * @Date: 2020/2/11
 * @Description:
 */
public class LetterCombinations {


    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


    List<String> output = new ArrayList<>();

    private void backtrack(String combination, String next_digits){
        if (next_digits.length() == 0) {
            output.add(combination);
            return;
        }else {
            String letter = next_digits.substring(0, 1);
            String letters = phone.get(letter);
            if (null == letters) {
                backtrack(combination, next_digits.substring(1));
                return;
            }
            char[] chars = letters.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                backtrack(combination + c, next_digits.substring(1));
            }
        }

    }


    public List<String> letterCombinations(String digit){
        if (null == digit || digit.trim().equals("")) {
            return output;
        }
        backtrack("", digit);
        return output;
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        letterCombinations.letterCombinations("23");
        System.out.println(Arrays.toString(letterCombinations.output.toArray()));
    }

}

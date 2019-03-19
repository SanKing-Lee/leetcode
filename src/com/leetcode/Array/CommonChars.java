package com.leetcode.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Sean
 * Date: Created In 23:10 2019/3/19
 * Title: 共同字符
 * Description: 找出给定的字符串中共同的字符
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class CommonChars {
    public List<String> commonChars() {
        String[] A = new String[]{"bella", "label", "roller"};
        List<String> lsCommonChars = new ArrayList<>();
        Map<Character, Integer> mCommonCharsMap = new HashMap<>();
        for (int i = 0; i < A[0].length(); i++) {
            int num = getCharNuminString(A[0].charAt(i), A[0]);
            for (String str : A) {
                if(num > getCharNuminString(A[0].charAt(i), str)){
                    num = getCharNuminString(A[0].charAt(i), str);
                }
            }
            mCommonCharsMap.put(A[0].charAt(i), num);
        }
        for (Map.Entry<Character, Integer> entry : mCommonCharsMap.entrySet()) {
           for(int i = 0; i < entry.getValue(); i++){
               lsCommonChars.add(entry.getKey().toString());
           }
        }
        return lsCommonChars;
    }

    private int getCharNuminString(char ch, String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}

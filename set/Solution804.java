package com.algorithm.set;

import java.util.TreeSet;

/**
 * author : Chip
 * time   : 2023/8/2
 * desc   : leetcode804号题目
 */
class Solution {
    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        // 1. 底层结构为平衡二叉树（红黑树）
        // 2. 定义了更多的操作
        TreeSet<String> set = new TreeSet<>();
        for (String word : words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                //取出单个字的ASC码减去‘a’计算出偏移，结果当做codes取出的索引
                res.append(codes[word.charAt(i) - 'a']);
            }
            //重复元素会自动忽略
            set.add(res.toString());
        }
        return set.size();
    }
}

package com.android.leetcode;

public class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        // equals()判断返回的两个字符串是否相等
        return changeString(s).equals(changeString(t));
    }

    private static String changeString(String str) {
        // 先将字符串转为数组，方便使用双指针法
        char[] x = str.toCharArray();
        // fast 指针用于遍历字符数组，slow 指针用于标记转换后的字符串的结束位置
        int slow = 0;
        for (int fast = 0; fast < x.length; fast++) {
            // 当x[fast] != '#'时，x[fast]覆盖x[slow]，然后slow++（当 fast 指针遇到的字符不是 '#' 时，表示这个字符要保留，所以将其复制到 slow 指针的位置，然后 slow 指针向前移动一位）
            if (x[fast] != '#') {
                x[slow] = x[fast];
                slow++;
            } else if (x[fast] == '#' && slow != 0) {
                // 当x[fast] = '#'且slow!=0时，slow--
                slow--;
            }
        }
        return String.copyValueOf(x, 0, slow);
    }
}

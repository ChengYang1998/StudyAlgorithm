package com.algorithm.leetcode;


import java.util.Collections;
import java.util.PriorityQueue;

/**
 * author : Chip
 * time   : 2023/8/15
 * desc   : 在 N 个元素中选出最小的 K 个元素 , 最大堆实现
 */
class Offer40_2 {
    public int[] getLeastNumbers(int[] arr, int k) {

        // 默认是小根堆，实现大根堆需要重写一下比较器。
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (!pq.isEmpty() && arr[i] < pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        // 返回堆中的元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove();
        }
        return res;

    }
}


package com.algorithm.leetcode;


import java.util.PriorityQueue;
import java.util.Queue;

/**
 * author : Chip
 * time   : 2023/8/15
 * desc   : 在 N 个元素中选出最小的 K 个元素 , 最大堆实现
 */
class Offer40_2 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = res.length - 1;
        for (int num : pq) {
            res[idx--] = num;
        }
        return res;

    }
}


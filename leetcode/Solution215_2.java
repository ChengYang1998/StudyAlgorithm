package com.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * author : Chip
 * time   : 2023/8/15
 * desc   : 使用 堆 解决 Select K 问题
 */
public class Solution215_2 {
    public int findKthLargest(int[] nums, int k) {
        // 创建一个优先队列（默认为最小堆）
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 将数组的前k个元素添加到优先队列（堆）中
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        // 从索引为k元素开始遍历数组
        for (int i = k; i < nums.length; i++) {
            // 若优先队列（堆）不为空，且当前元素值大于堆顶元素值
            if (!pq.isEmpty() && nums[i] > pq.peek()) {
                // 移除堆顶元素（堆中最小的元素）
                pq.remove();
                // 将当前元素添加到堆中
                pq.add(nums[i]);
            }
        }
        // 返回堆顶元素，由于前面的操作保证了堆中始终保持了数组的前k个最大元素，返回的堆顶元素就是第k大的元素
        return pq.peek();
    }
}

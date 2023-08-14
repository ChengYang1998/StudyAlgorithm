package com.algorithm.maxheap;

/**
 * author : Chip
 * time   : 2023/8/14
 * desc   :
 */
public class HeapSort {
    private HeapSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e : data) {
            maxHeap.add(e);
        }
        for (int i = data.length - 1; i >= 0; i--) {
            data[i] = maxHeap.extractMax();
        }
    }

    /**
     * 最大堆原地排序
     */
    public static <E extends Comparable<E>> void sort2(E[] data) {
        if (data.length <= 1) {
            return;
        }
        // 将data转化为堆的形式
        for (int i = (data.length - 2) / 2; i >= 0; i--) {
            siftDown(data, i, data.length);
        }
        // 逐渐将堆顶元素放置最后
        for (int i = data.length; i > 0; i--) {
            swap(data, 0, i);
            siftDown(data, 0, i);

        }
    }

    /**
     * 对 data[0,n) 所形成的最大堆中，索引k的元素，执行siftDown
     *
     * @param data
     * @param k    索引
     * @param n
     * @param <E>
     */
    private static <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {

        // 如果元素有左孩子
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            // 判断元素是否有右孩子，并比较左右孩子的大小
            if (j + 1 < n && data[j + 1].compareTo(data[j]) > 0) {
                // 如果右孩子大于左孩子，将j指向右孩子
                j++;
            }
            // 现在，data[j]是leftChild和rightChild中的最大值
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }

            swap(data, k, j);
            k = j;
        }
    }

    public static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

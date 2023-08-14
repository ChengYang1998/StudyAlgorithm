package com.algorithm.maxheap;

import com.algorithm.array.Array;

/**
 * author : Chip
 * time   : 2023/8/14
 * desc   :
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    /**
     * Heapify
     *
     * @param arr 传入的数组
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        if (arr.length != 1) {
            for (int i = parent(arr.length - 1); i >= 0; i--) {
                siftDown(i);
            }
        }

    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * @param index 索引
     * @return 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 does not have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * @param index 索引
     * @return 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * @param index 索引
     * @return 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     *
     * @param e 元素
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 元素上浮
     *
     * @param k 元素所在索引
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * @return 找出堆中最大元素
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        return data.get(0);
    }

    public E extractMax() {
        E ret = findMax();
        // 将根元素和末尾元素交换
        data.swap(0, data.getSize() - 1);
        // 移除堆中最后一个元素（原来的最大元素）
        data.removeLast();
        // 对新的根元素进行下沉操作，以保持最大堆的性质
        siftDown(0);
        return ret;
    }

    /**
     * @param e 待替换的元素
     * @return 取出堆中的最大元素
     */
    public E replace(E e) {
        E ret = findMax();
        // 将最大元素替换
        data.set(0, e);
        // 对新的根元素进行下沉操作，以保持最大堆的性质
        siftDown(0);
        return ret;
    }

    /**
     * 元素下沉
     *
     * @param k 元素所在索引
     */
    private void siftDown(int k) {

        // 如果元素有左孩子
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            // 判断元素是否有右孩子，并比较左右孩子的大小
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                // 如果右孩子大于左孩子，将j指向右孩子
                j = rightChild(k);
            }
            // 现在，data[j]是leftChild和rightChild中的最大值
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }
}

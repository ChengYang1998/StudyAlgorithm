package com.algorithm.set;

import com.algorithm.bst.BST;

import java.util.ArrayList;

/**
 * author : Chip
 * time   : 2023/8/2
 * desc   : 基于二分搜索树的Set实现
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int size() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("fairyTale.txt");
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("fairyTale.txt", words1);
        System.out.println("Total words: " + words1.size());

        BSTSet<String> set1 = new BSTSet<>();
        for (String word : words1) {
            set1.add(word);
        }
        System.out.println("Different words: " + set1.size());

    }
}



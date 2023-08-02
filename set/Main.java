package com.algorithm.set;

import java.util.ArrayList;

/**
 * author : Chip
 * time   : 2023/8/2
 * desc   :
 */
public class Main {

    private static double testSet(Set<String> set, String filename) {
        long starTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());
            for (String word : words) {
                set.add(word);
            }
            System.out.println("Different words: " + set.size());
        }
        long endTime = System.nanoTime();
        return (endTime - starTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String filename = "fairyTale.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set:" + time1);
        System.out.println();
        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("Linked List Set:" + time2);
    }
}

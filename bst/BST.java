package com.algorithm.bst;

import java.util.*;


public class BST<E extends Comparable<E>> {
    private class Node {

        public E e;

        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    //根节点
    private Node root;
    //存储了多少元素
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向二分搜索树中添加新的元素e
    public void add(E e) {
        root = add(root, e);
    }

    //向以node为根的二分搜索树中插入元素E，递归算法
    //返回 插入新节点后二分搜索树的根
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        //递归调用,返回插入新节点
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);

        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 判断以node为根的二分搜索树中是否存在元素e
     *
     * @param node 节点
     * @param e    查找的元素e
     * @return 向以node为根的二分搜索树中查找元素e，递归算法
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    /**
     * 以node为根的二分搜索树的前序遍历，递归算法
     *
     * @param node node根
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.e + " " + "\n");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二分搜索树的前序遍历，非递归算法
     */
    public void preOrderNR() {

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur.e + "当前访问" + "\n");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }


        }
    }

    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树的中序遍历，递归算法
     *
     * @param node 根节点
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.e + " " + "\n");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    /**
     * 以node为根的二分搜索树的后序遍历，递归算法
     *
     * @param node 根节点
     */
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e + " " + "\n");
    }

    /**
     * 层序遍历以node为根的二分搜索树
     */
    public void levelOrder() {

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // 出队
            Node cur = q.poll();
            System.out.print(cur.e + " " + "\n");
            // 如果有左右孩子，入队
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }

    }

    /**
     * 寻找二分搜索树中最小的元素
     *
     * @return 二分搜索树中最小的元素
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }


    /**
     * 以node为根的二分搜索树的最小元素，递归算法
     *
     * @param node 以node为根的二分搜索树
     * @return 二分搜索树的最小元素
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    /**
     * 以node为根的二分搜索树的最大元素，递归算法
     *
     * @param node 以node为根的二分搜索树
     * @return 二分搜索树的最大元素
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树中的最小元素，递归算法
     *
     * @return 删除节点后新的二分搜索树的根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树中的最大元素，递归算法
     *
     * @return 删除节点后新的二分搜索树的根
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        //递归调用
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            // 找到了元素e
            // 待删除节点左子树为空
            if (node.left == null) {
                //保存
                Node rightNode = node.right;
                //脱离
                node.right = null;
                size--;
                //返回
                return rightNode;
            }

            // 待删除节点右子树为空
            if (node.right == null) {
                //保存
                Node leftNode = node.left;
                //脱离
                node.left = null;
                size--;
                //返回
                return leftNode;
            }

            // 待删除节点左右子树都不为空
            // 找到比待删除节点大的最小节点，即待删除节点右子数的最小节点
            // 用这个节点替换待删除节点位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            //不需要维护大小，因为removeMin()维护过了
            return successor;

        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


    public void print() {
        if (root != null) {
            print(root, "", true);
        }
    }

    private void print(Node node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.e);
            if (node.left != null) {
                print(node.left, prefix + (isTail ? "    " : "│   "), false);
            }
            if (node.right != null) {
                print(node.right, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }


    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMax());
        }

        System.out.println(nums);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                System.out.println("error");
                return;
            }
        }
        System.out.println("right");

    }

}

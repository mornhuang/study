package com.huang.j2ee.ch00;

/**
 * User : Morn
 * Date : 2013-10-17 17:15
 */
public class Tree<T> {
    private TreeNode<T> root;

    public Tree() {
        this.root = new TreeNode<T>();
    }

    public Tree(TreeNode<T> root) {
        this.root = root;
    }
}

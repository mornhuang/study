package com.huang.frame.utils;

import java.util.ArrayList;

/**
 * User : Morn
 * Date : 2013-10-17 16:53
 */
public class TreeNode<T> {
    private TreeNode<T> parent;
    private TreeNode<T> leftCousin;
    private TreeNode<T> rightCousin;
    private ArrayList<TreeNode<T>> children;
    private String id;
    private T value;

    public TreeNode() {
        this.parent = null;
        this.leftCousin = null;
        this.rightCousin = null;
        this.children = null;
        this.id = "";
        this.value = null;
    }

    public TreeNode(TreeNode<T> parent, TreeNode<T> leftCousin,
                    TreeNode<T> rightCousin, ArrayList<TreeNode<T>> children, T value) {
        this.id = "";
        this.parent = parent;
        this.leftCousin = leftCousin;
        this.rightCousin = rightCousin;
        this.children = children;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public TreeNode<T> getLeftCousin() {
        return leftCousin;
    }

    public TreeNode<T> getRightCousin() {
        return rightCousin;
    }

    public boolean hasChildren() {
        return !(children == null || children.size() == 0);
    }

    public int getDepth() {
        if (parent != null) {
            int depth = parent.getDepth();
            return ++depth;
        } else {
            return 0;
        }
    }

    public ArrayList<TreeNode<T>> getChildren() {
        return children;
    }

    public int getChildrenCount() {
        if (children == null)
            return 0;
        else
            return children.size();
    }

    public TreeNode<T> getChild(int index) {
        if (!hasChildren()) {
            return null;
        } else {
            return children.get(index);
        }
    }

    public TreeNode<T> getFirstChild() {
        return getChild(0);
    }

    public TreeNode<T> getLastChild() {
        return getChild(children.size());
    }

/*
    public boolean setParent(TreeNode<T> parent) {
        if (this.parent == null) {
            if ()
        }
        if (parent == null) {

        }
        return;

        TreeNode<T> oldParent = this.parent;
        if (oldParent.removeChild(this)) {
            parent.addChild(this);
        }

    }
*/

    public boolean addChild(TreeNode<T> child) {
        if (child == null)
            return false;

        if (children == null) {
            children = new ArrayList<TreeNode<T>>();
        }

        if (!children.add(child)) {
            return false;
        }
        child.parent = this;

        TreeNode<T> lastChild = getLastChild();
        if (lastChild != null) {
            lastChild.rightCousin = child;
            child.leftCousin = lastChild;
        }
        return true;

    }

    public boolean removeChild(TreeNode<T> child) {
        if (!hasChildren()) {
            return false;
        }

        if (!children.remove(child)) {
            return false;
        }

        if (child.leftCousin != null)
            child.leftCousin.rightCousin = child.rightCousin;

        if (child.rightCousin != null) {
            child.rightCousin.leftCousin = child.leftCousin;
        }

        return true;
    }

    public TreeNode<T> removeChild(int index) {
        if (!hasChildren()) {
            return null;
        }

        TreeNode<T> removed = children.remove(index);
        if (removed == null) {
            return null;
        }

        if (removed.leftCousin != null)
            removed.leftCousin.rightCousin = removed.rightCousin;

        if (removed.rightCousin != null) {
            removed.rightCousin.leftCousin = removed.leftCousin;
        }

        return removed;
    }


    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

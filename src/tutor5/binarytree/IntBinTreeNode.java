package tutor5.binarytree;

public class IntBinTreeNode {
    int key; //khoa giup phan biet du lieu trong nut
    IntBinTreeNode left, right;

    public IntBinTreeNode() {
        left = right = null;
    }

    public IntBinTreeNode(int key) {
        this.key = key;
        left = right = null;
    }
    //tao mot nut voi 2 con da biet

    public IntBinTreeNode(int key, IntBinTreeNode left, IntBinTreeNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public IntBinTreeNode getLeft() {
        return left;
    }

    public void setLeft(IntBinTreeNode left) {
        this.left = left;
    }

    public IntBinTreeNode getRight() {
        return right;
    }

    public void setRight(IntBinTreeNode right) {
        this.right = right;
    }
}

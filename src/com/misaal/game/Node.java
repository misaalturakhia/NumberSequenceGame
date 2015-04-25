package com.misaal.game;

/**
 * Created by Misaal on 25/04/2015.
 */
public class Node {

    public double data;

    public Node left, right;

    public Node(double data, Node left, Node right){
        setData(data);
        setLeft(left);
        setRight(right);
    }

    public Node(double data){
        setData(data);
        setLeft(null);
        setRight(null);
    }

    public Node(){
        setData(0.0);
        setLeft(null);
        setRight(null);
    }


    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }


}

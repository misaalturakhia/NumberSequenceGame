package com.misaal.game;

/**
 * Created by Misaal on 25/04/2015.
 */
public class Tree {

    Node root;

    public Tree(Node root){
        this.root = root;
    }

    public Tree(double data){
        this.root = new Node(data);
    }


    public Node insert(Node node, double data)
    {
        if (node == null)
            node = new Node(data);
        else
        {
            if (data <= node.getData())
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }

    public double getScore(){
        return root.data + root.right.right.data;
    }


}

package com.misaal.game;

/**
 * Created by Misaal on 24/04/2015.
 */
public class Main {


    /**
     *
     * @param args
     */
    public static void main(String[] args){
        calculateAndPrintScore(10000);
//        calculateAndPrintScore(100000000);
    }

    private static void calculateAndPrintScore(int n) {
        double[] s = generateSequence(n);
        System.out.println("Score for : "+n+" = "+ calculate(s, 0, 0, 0, n-1));
    }


    /**
     *
     * @param s
     * @param turnCounter
     * @param finalScore
     * @return
     */
    public static double calculate( double[] s, int turnCounter, double finalScore, int first, int last){
        if(turnCounter == s.length - 1){
            return finalScore;
        }

        double firstScore = getFirstOptionScore(s, first, last);
        double secondScore = getSecondOptionScore(s, first, last);
        if(firstScore > secondScore){
            if(turnCounter % 2 == 0){
                finalScore += s[first];
            }
            first++;
        }else{
            if(turnCounter % 2 == 0){
                finalScore += s[last];
            }
            last--;
        }
        turnCounter++;
        try{
            return calculate(s, turnCounter, finalScore, first, last);
        }catch (StackOverflowError e){
            System.out.println("TC :"+turnCounter + ", s[first] : " + s[first] + ", s[last] : "+s[last]+", finalscore : "+finalScore);
        }
        return 2;
    }



//                     s[first]
//          s[first + 1] , s[last]
//    s[first + 2], s[last] , s[first + 1], s[last - 1]
    private static double getFirstOptionScore(double[] s, int first, int last) {
        Tree tree = new Tree(s[first]);
        Node root = tree.root;
        root.left = new Node(s[first + 1]);
        root.left.left = new Node(s[first + 2]);
        root.left.right = new Node(s[last]);

        root.right = new Node(s[last]);
        root.right.left = new Node(s[first + 1]);
        root.right.right = new Node(s[last - 1]);

        return getScore(root);
    }

//                  s[last]
//              s[first] , s[last - 1]
//    s[first + 1] , s[last - 1] , s[first] , s[last - 2]
    private static double getSecondOptionScore(double[] s, int first, int last) {
        Tree tree = new Tree(s[last]);
        Node root = tree.root;
        root.left = new Node(s[first]);
        root.left.left = new Node(s[first + 1]);
        root.left.right = new Node(s[last - 1]);

        root.right = new Node(s[last - 1]);
        root.right.left = new Node(s[first]);
        root.right.right = new Node(s[last - 2]);

        return getScore(root);
    }

    private static double getScore(Node root) {
        if(root.left.data > root.right.data){
            if(root.left.left.data > root.left.right.data){
                return root.data + root.left.left.data;
            }else{
                return root.data + root.left.right.data;
            }
        }else{
            if(root.right.left.data > root.right.right.data){
                return root.data + root.right.left.data;
            }else{
                return root.data + root.right.right.data;
            }
        }
    }


    /**
     * Generate the sequence
     * @param n : no of numbers in the sequence
     * @return : an array holding the sequence
     */
    private static double[] generateSequence(int n) {
        double[] s = new double[n];
        s[0] = 0;
        for(int i = 1; i < n; i++){
            s[i] = (Math.pow(s[i - 1], 2) + 45) % 1000000007;
        }
        return s;
    }


}

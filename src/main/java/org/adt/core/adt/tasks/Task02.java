

/*
 package org.adt.core.adt.tasks;

import org.adt.core.adt.algorithms.BinaryTreeAlgorithms;
import org.adt.core.adt.definition.IBinaryTree;
import org.adt.core.adt.algorithms.BinaryTreeAlgorithms.*;
import org.adt.core.adt.implementation.dynamic.BinaryTree;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task02 {

    public static int internalNodesSum(IBinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return 0;
        }

        if (binaryTree.getLeft() == null && binaryTree.getRight() == null) {
            return 0;
        }

        int sum = binaryTree.getValue();

        sum += internalNodesSum(binaryTree.getLeft());
        sum += internalNodesSum(binaryTree.getRight());

        return sum;
    }

    public static void getLeafsmin(IBinaryTree binaryTree, List leafs){
        if (binaryTree == null || binaryTree.isEmpty()) {
            return;
        }
        BinaryTreeAlgorithms.inOrder(binaryTree.getLeft());
        BinaryTreeAlgorithms.inOrder(binaryTree.getRight());
        if (binaryTree.getLeft() == null && binaryTree.getRight() == null) {
            leafs.add(binaryTree.getValue());
        }
    }

    public static int getMinValue (int [] leafs){
        int min = leafs[0];
        for (int i=0; i<leafs.length; i++){
            if(leafs[i]<min){
                min = leafs[i];
            }
        }
        return min;

    }

    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.create(1);
        binaryTree.addLeft(2);
        binaryTree.addRight(3);
        binaryTree.getLeft().addLeft(4);
        binaryTree.getRight().addRight(5);


        List<Integer> leafs = new ArrayList<>();
        getLeafsmin(binaryTree, leafs);
        int[] arrayLeafs = leafs.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(internalNodesSum(binaryTree)*getMinValue(arrayLeafs));



    }

 */


/*
    public static int getMinNodeValue(IBinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return 0;
        }

        int min = binaryTree.getValue();
        int minLeft = getMinNodeValue(binaryTree.getLeft());
        int minRight = getMinNodeValue(binaryTree.getRight());
        if (min > minLeft || min > minRight){
            return 0;
        }

        return min;
    }

*/


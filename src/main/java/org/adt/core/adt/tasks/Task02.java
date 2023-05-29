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
        if (binaryTree.getLeft() == null && binaryTree.getRight() == null) {
            leafs.add(binaryTree.getValue());
        }
        getLeafsmin(binaryTree.getLeft(), leafs);
        getLeafsmin(binaryTree.getRight(), leafs);

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

    public static IBinaryTree convertToBST(IBinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return null;
        }
    
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(binaryTree, values); // Realiza un recorrido en orden para obtener los valores ordenados
        Collections.sort(values);
        /*
        for(Integer e : values){
            System.out.println(e);
        }
        System.out.println("---");
         */
        int size = values.size()-1;
        return buildBST (values, 0, size);
    }
    
    private static void inOrderTraversal(IBinaryTree binaryTree, List<Integer> values) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return;
        }
    
        inOrderTraversal(binaryTree.getLeft(), values);
        values.add(binaryTree.getValue());
        inOrderTraversal(binaryTree.getRight(), values);
    }
    
    public static IBinaryTree buildBST(List<Integer> values, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = (start + end) / 2;
        System.out.println(mid);
        IBinaryTree root = new BinaryTree();
        root.create(values.get(mid));
        root.addLeft(buildBST(values, start, mid - 1).getValue());
        root.addRight(buildBST(values, mid + 1, end).getValue());
        
        return root;
    }
    

    public static void main(String[] args){
        IBinaryTree binaryTree = new BinaryTree();
        binaryTree.create(1);
        binaryTree.addLeft(2);
        binaryTree.addRight(3);
        binaryTree.getLeft().addLeft(4);
        binaryTree.getLeft().addRight(6);
        binaryTree.getRight().addRight(5);
        binaryTree.getRight().addLeft(7);
                
        List<Integer> leafs = new ArrayList<>();
        getLeafsmin(binaryTree, leafs);
        int[] arrayLeafs = leafs.stream().mapToInt(Integer::intValue).toArray();
        //System.out.println(internalNodesSum(binaryTree)*getMinValue(arrayLeafs));
        IBinaryTree SBT = convertToBST(binaryTree);
        System.out.println("---");
        BinaryTreeAlgorithms.inOrder(SBT);
    }

}


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


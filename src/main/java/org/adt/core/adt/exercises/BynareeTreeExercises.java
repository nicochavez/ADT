package org.adt.core.adt.exercises;

import org.adt.core.adt.algorithms.BinaryTreeAlgorithms;
import org.adt.core.adt.definition.IBinaryTree;
import org.adt.core.adt.definition.IPriorityQueue;
import org.adt.core.adt.definition.IQueue;
import org.adt.core.adt.implementation.normal.Queue;

import java.util.ArrayList;

public class BynareeTreeExercises {

    public static void binaryTreeToQueue(IBinaryTree binaryTree, IQueue queue){
        if (binaryTree == null || binaryTree.isEmpty()) {
            return;
        }
        binaryTreeToQueue(binaryTree.getLeft(), queue);
        queue.add(binaryTree.getValue());
        binaryTreeToQueue(binaryTree.getRight(), queue);
    }

    public static IPriorityQueue queueToPriorityQueue(IQueue queue){
        while
    }

}

package org.adt.core.adt.exercises;

import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.definition.IStack;
import org.adt.core.adt.implementation.dynamic.Stack;
import org.adt.core.adt.implementation.normal.Set;
import org.adt.core.adt.algorithms.StackAlgorithms;

public class StackExercises {

    public static int count(IStack stack){ //Contador de los elementos de una pila
        IStack stackcopy = StackAlgorithms.copy(stack);
        int count = 0;
        while(!stackcopy.isEmpty()){
            count++;
            stackcopy.remove();
        }
        return count;
    }

    public static int sumElements(IStack stack){
        IStack stackcopy = StackAlgorithms.copy(stack);
        int sum = 0;
        while(!stackcopy.isEmpty()){
            sum+=stackcopy.getTop();
            stackcopy.remove();
        }
        return sum;
    }

    public static float average(IStack stack){
        return sumElements(stack)/count(stack);
    }

    public static boolean isPalindromic(IStack stack){
        boolean palindromic = true;
        IStack aux = new Stack();
        IStack stack2 = StackAlgorithms.copy(stack);
        while(!stack.isEmpty()){
            aux.add(stack.getTop());
            stack.remove();
        }
        while(!aux.isEmpty()){
            if(stack2.getTop() != aux.getTop()){
                palindromic = false;
            }
            stack.add(stack2.getTop());
            aux.remove();
            stack2.remove();
        }
        return palindromic;
    }

    public static void uniqueStack(IStack stack){
        IStack aux = new Stack();
        while(!stack.isEmpty()){
            if(!isInStack(aux, stack.getTop())){
                aux.add(stack.getTop());
            }
            stack.remove();
        }

        while(!aux.isEmpty()){
            stack.add(aux.getTop());
            aux.remove();
        }

    }

    public static boolean isInStack(IStack stack, int a){
        IStack copy = StackAlgorithms.copy(stack);
        while(!copy.isEmpty()){
            if(copy.getTop() == a){
                return true;
            }
            copy.remove();
        }
        return false;
    }

    public static ISet stackToSet(IStack stack){
        ISet set = new Set();
        while(!stack.isEmpty()){
            set.add(stack.getTop());
            stack.remove();
        }
        return set;
    }

    public static IStack setToStack(ISet set){
        IStack stack = new Stack();
        while(!set.isEmpty()){
            int element = set.choose();
            stack.add(element);
            set.remove(element);
        }
        return stack;
    }

    public static ISet setOfReapetedStack(IStack stack){
        ISet set = new Set();
        while(!stack.isEmpty()){
            if(isInStack(stack, stack.getTop())){
                set.add(stack.getTop());
            }
            stack.remove();
        }
        return set;
    }

    public static IStack[] splitStack(IStack stack){
        IStack stack1 = new Stack();
        IStack stack2 = new Stack();
        IStack [] stackArray = new IStack[2];
        IStack copy = StackAlgorithms.copy(stack);
        int count = 0;
        while(!copy.isEmpty()){
            count++;
            copy.remove();
        }
        while(!stack.isEmpty()){
            if(count % 2 == 0){
                stack1.add(stack.getTop());
            } else {
                stack2.add(stack.getTop());
            }
        }
        StackAlgorithms.revert(stack1);
        StackAlgorithms.revert(stack2);
        stackArray[0] = stack1;
        stackArray[1] = stack2;
        return stackArray;
    }

}   








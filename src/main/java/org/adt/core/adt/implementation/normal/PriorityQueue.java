package org.adt.core.adt.implementation.normal;

import org.adt.core.adt.definition.IPriorityQueue;

/**
 * Esta implementación no acepta valores repetidos en las prioridades,
 * de lo contrario la busqueda binaria no sería válida
 */
public class PriorityQueue implements IPriorityQueue {

    private static final int LENGTH = 10000;

    private final int[] array;
    private final int[] priorities;
    private int count;

    public PriorityQueue() {
        this.array = new int[LENGTH];
        this.priorities = new int[LENGTH];
        this.count = 0;
    }

    @Override
    public void add(int a, int priority) {
        int j = this.count;
        while (j > 0 && this.priorities[j-1] > priority) {
            this.array[j] = this.array[j-1];
            this.priorities[j] = this.priorities[j-1];
            j--;
        }
        this.array[j] = a;
        this.priorities[j] = priority;
        count++;
    }

    // Solo para prioridades no repetidas
    /*
         @Override
    public void add(int a, int priority) {
        int index = binarySearch(priority);

        for (int i = this.count; i > index; i--) {
            this.array[i] = this.array[i - 1];
            this.priorities[i] = this.priorities[i - 1];
        }

        this.array[index] = a;
        this.priorities[index] = priority;

        this.count++;
    }

    private int binarySearch(int priority) {
        int low = 0;
        int high = this.count - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (this.priorities[mid] == priority) {
                return mid;
            } else if (this.priorities[mid] < priority) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
     */
    @Override
    public void remove() {
        if (count == 0) {
            System.out.println("Error, no se puede desacolar una cola vacia");
            return;
        }
        for (int i = 0; i < this.array.length - 1; i++) {
            this.array[i] = this.array[i + 1];
            this.priorities[i] = this.priorities[i + 1];
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int getFirst() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener el primero de una cola vacia");
            return -1;
        }
        return this.array[0];
    }

    @Override
    public int getPriority() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener la prioridad del primero de una cola vacia");
            return -1;
        }
        return this.priorities[0];
    }
}

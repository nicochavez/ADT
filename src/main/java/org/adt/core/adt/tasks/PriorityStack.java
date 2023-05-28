package org.example.Ej1;

public class PriorityStack implements PriorityStackInterface {

    private static final int LENGTH = 10000;
    private int [] elements;
    private int [] prioritys;
    int count;

    public PriorityStack(){
        elements = new int[LENGTH]; //Complejida constantes O(1)
        prioritys = new int[LENGTH]; //Complejidad constante O(1)
        count = 0;
    }

    @Override
    public void addPriority(int a, int priority) { //Complejidad O(n)
        int j = this.count; //Complejidad constante O(1)
        while (j > 0 && prioritys[j-1] > priority) { //Complejidad O(n), donde n es la cantidad de elementos que tiene el array, el peor caso es recorrer todo el array.
            elements[j] = elements[j-1]; //Complejidad constante O(1)
            prioritys[j] = prioritys[j-1]; //Complejidad constante O(1)
            j--;
        }
        elements[j] = a; //Complejidad constante O(1)
        prioritys[j] = priority; //Complejidad constante O(1)
        count++; //Complejidad constante O(1)
    }

    @Override
    public void remove() { //Complejidad constante O(1)
        if(isEmpty()){ //Complejidad constante O(1)
            System.out.println("Error, no se puede desapilar una cola vacia"); //Complejidad constante O(1)
            return;
        }
        this.count--; //Complejidad constante O(1)
    }

    @Override
    public boolean isEmpty() { //Complejidad constante O(1)
        return count == 0; //Complejidad constante O(1)
    }

    @Override
    public int getFirst() { //Complejidad constante O(1)
        return elements[count-1]; //Complejidad constante O(1)
    }

    @Override
    public int getPriority() { //Complejidad constante O(1)
        return prioritys[count-1]; //Complejidad constante O(1)
    }
}

package org.adt.core.adt.tasks;

public interface PriorityStackInterface {

    /**
     * Precondicion: La pila con prioridad debe estar inciailizada
     * Postcondicion: Añade el elemento junto con su prioridad, el lugar que va ocupar en la pila depende de su prioridad
     * @param a: valor a insertar
     * @param priority: prioridad
     */
    void addPriority(int a, int priority);

    /**
     * Precondicion: La pila con prioridad debe estar incializada y no vacia.
     * Postcondicion: Elimina el elemento de mayor prioridad de la pila
     */
    void remove();

    /**
     * Precondicion: la pila debe estar inicializada
     * Postcondicion: se va indicar si la pila esta vacia o no
     * @return
     */
    boolean isEmpty();

    /**
     * Precondicion: la pila debe estar inicializa y no vacia.
     * Postcondicion: Obtiene el elemento de arriba de la pila, es decir el de mayor prioridad
     * @return
     */
    int getFirst();

    /**
     * Preconcion: la pila debe estar inicializada y no vacia
     * Poscondicion: Obtiene la prioridad del elemento con mayor prioridad
     * @return
     */
    int getPriority();
}

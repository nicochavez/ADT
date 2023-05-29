package org.adt.core.adt.algorithms;

import org.adt.core.adt.algorithms.extra.adt.BinaryTreeWithReferences;
import org.adt.core.adt.definition.IBinaryTree;

public class BinaryTreeAlgorithms {

    public static void inOrder(IBinaryTree binaryTree) { //recorre el arbol
        if (binaryTree == null || binaryTree.isEmpty()) { // Comprueba si el árbol binario (binaryTree) es nulo o está vacío
            return;
        }

        inOrder(binaryTree.getLeft()); //recorre el subarbol izquierdo
        System.out.println(binaryTree.getValue()); //imprime el nodo actual
        inOrder(binaryTree.getRight()); //recorre el subarbol derecho
    }// En resumen: visita primero el nodo izquierdo, luego el nodo raíz y finalmente el nodo derecho.

    public static void preOrder(IBinaryTree binaryTree) { 
        if (binaryTree == null || binaryTree.isEmpty()) {
            return;
        }

        System.out.println(binaryTree.getValue());
        preOrder(binaryTree.getLeft());
        preOrder(binaryTree.getRight());
    } //visita primero al nodo raiz, luego al nodo izquierdo y finalmente al derecho.

    public static void postOrder(IBinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return;
        }

        postOrder(binaryTree.getLeft());
        postOrder(binaryTree.getRight());
        System.out.println(binaryTree.getValue());
    }//visita primero al nodo izquierdo, luego al nodo derecho y finalmente a la raiz.

    public static int weight(IBinaryTree binaryTree) { //devuelve la cantidad de nodos que tiene un arbol
        if (binaryTree == null || binaryTree.isEmpty()) {
            return 0;
        }
        return 1 + weight(binaryTree.getLeft()) + weight(binaryTree.getRight()); 
    }

    public static int sumNodes(IBinaryTree binaryTree){ //Suma todos los nodos internos del arbol
        if (binaryTree == null || binaryTree.isEmpty()) {
            return 0;
        }
        return binaryTree.getValue() + sumNodes(binaryTree.getLeft()) + sumNodes(binaryTree.getRight());
    }

    public static int height(IBinaryTree binaryTree) {//Obtiene la altura del arbol, el camino desde la raiz hasta el nodo del ultimo nivel
        if (binaryTree == null || binaryTree.isEmpty()) {
            return 0;
        }
        return 1 + Math.max(height(binaryTree.getLeft()), height(binaryTree.getRight()));
    }

    public static int order(IBinaryTree binaryTree, int element) { //devuelve la cantidad de hijos de un nodo
        if (binaryTree == null || binaryTree.isEmpty()) {
            return -1;
        }
        if (binaryTree.getValue() == element) { //si el valor del nodo coincide con el elemento buscado
            int hasLeft = binaryTree.getLeft() == null ? 0 : 1; //si tiene un hijo izquierod hasLeft = 1
            int hasRight = binaryTree.getRight() == null ? 0 : 1;//si tiene un hijo derecho hasRight = 1
            return hasLeft + hasRight; //retorna la suma de hasLeft y HasRight
        }
        int candidate = order(binaryTree.getLeft(), element); //verifica que el nodo se encuentr en el subarbol isquierdo
        if (candidate == -1) { //si no lo esta
            return order(binaryTree.getRight(), element); //busca en el subarbol derecho
        }
        return candidate;
    }

    public static boolean skewed(IBinaryTree binaryTree) { //Devuelve True si el arbol esta sesgado hacia la derecha o a la izquierda.
        return leftSkewed(binaryTree) || rightSkewed(binaryTree);
    }

    public static boolean leftSkewed(IBinaryTree binaryTree) { //Devuelve True si el arbol esta sesgado a la izquierda, es decir no tiene nodos derechos.
        if (binaryTree == null || binaryTree.isEmpty()) {
            return true;
        }
        return binaryTree.getRight() == null && leftSkewed(binaryTree);
    }

    public static boolean rightSkewed(IBinaryTree binaryTree) { //Devuelve True si el arbol esta sesgado a la derecha, es decir no tiene nodos izquierdos.
        if (binaryTree == null || binaryTree.isEmpty()) {
            return true;
        }
        return binaryTree.getLeft() == null && rightSkewed(binaryTree);
    }

    public static boolean degenerate(IBinaryTree binaryTree) {// Devuelve True si el arbol binario es degenerado, es decir, que cada nodo tiene un solo hijo.
        if (binaryTree == null || binaryTree.isEmpty()) { //Comprueba si el arbol esta vacio
            return true;
        }

        if (binaryTree.getLeft() != null) { //Compruea si tiene un hijo izquierdo
            if (binaryTree.getRight() != null) { //Si tien un hijo derecho tambien retorna falso
                return false;
            }
            return degenerate(binaryTree.getLeft());
        }

        if (binaryTree.getRight() != null) { //lo mismo aca
            if (binaryTree.getLeft() != null) {
                return false;
            }
            return degenerate(binaryTree.getRight());
        }

        return true;
    }

    public static boolean complete(IBinaryTree binaryTree) { // Devuelve True si el arbol binario esta completo, es decir que siempre tiene un nodo izquierdo y derecho o no tiene ningun nodo.
        if (binaryTree == null || binaryTree.isEmpty()) {
            return true;
        }

        return binaryTree.getLeft() != null &&
                binaryTree.getRight() != null &&
                complete(binaryTree.getLeft()) &&
                complete(binaryTree.getRight()) ||// Si el nodo tiene hijo izquierdo y dercho exclusivo
                binaryTree.getLeft() == null && binaryTree.getRight() == null; //Si el nodo no tiene hijos
    }

    public static boolean perfect(IBinaryTree binaryTree) { //Devuelve true si arbol binario es perfecto, es decir, todos los niveles están completamente llenos y todas las hojas están en el mismo nivel.
        if (binaryTree == null || binaryTree.isEmpty()) {
            return true;
        }

        if (!complete(binaryTree.getLeft()) || !complete(binaryTree.getRight())) {
            return false;
        }

        if (height(binaryTree.getLeft()) != height(binaryTree.getRight())) {
            return false;
        }

        return perfect(binaryTree.getLeft()) && perfect(binaryTree.getRight());
    }

    private static boolean existsLT(IBinaryTree binaryTree, int value) {// Devuelve true si hay algun nodo menor al valor dado
        if (binaryTree == null || binaryTree.isEmpty()) {
            return false;
        }
        if (binaryTree.getValue() < value) {
            return true;
        }
        return existsLT(binaryTree.getLeft(), value) || existsLT(binaryTree.getRight(), value);
    }

    private static boolean existsGT(IBinaryTree binaryTree, int value) {// Devuelve true si hay algun valor mayor al dado
        if (binaryTree == null || binaryTree.isEmpty()) {
            return false;
        }
        if (binaryTree.getValue() > value) {
            return true;
        }
        return existsGT(binaryTree.getLeft(), value) || existsGT(binaryTree.getRight(), value);
    }

    private static boolean isSBT(IBinaryTree binaryTree) {//Devuelve True si el arbol binario es un arbol binario de busqueda
        if (binaryTree == null || binaryTree.isEmpty()) {
            return true;
        }
        return !existsGT(binaryTree.getLeft(), binaryTree.getValue()) &&
                !existsLT(binaryTree.getRight(), binaryTree.getValue()) &&
                isSBT(binaryTree.getLeft()) &&
                isSBT(binaryTree.getRight());
    }

    public static boolean swap(IBinaryTree binaryTree, int value) { //busca un nodo con un valor dado y realiza el intercambio de sus nodos hijos (El der por el izq, el izq por el der)
        if (binaryTree == null || binaryTree.isEmpty()) {
            return false;
        }
        if ((binaryTree.getLeft() != null &&
                !binaryTree.getLeft().isEmpty() &&
                binaryTree.getLeft().getValue() == value) ||
                (binaryTree.getRight() != null &&
                        !binaryTree.getRight().isEmpty() &&
                        binaryTree.getRight().getValue() == value)
        ) {
            IBinaryTree aux = binaryTree.getLeft();
            copy(binaryTree.getLeft(), binaryTree.getRight());
            copy(binaryTree.getRight(), aux);
            return true;
        }

        return swap(binaryTree.getLeft(), value) || swap(binaryTree.getRight(), value);
    }

    public static void copy(IBinaryTree binaryTree, IBinaryTree binaryTree2) { //copia el contenido del segundo árbol en el primer árbol, manteniendo la estructura de árbol binario.
        if (binaryTree2 == null || binaryTree2.isEmpty() || binaryTree2.getValue() == -1) {
            return;
        }
        binaryTree.create(binaryTree2.getValue());
        binaryTree.addLeft(binaryTree2.getLeft().getValue());
        binaryTree.addRight(binaryTree2.getRight().getValue());
        if (binaryTree2.getLeft() == null) {
            binaryTree2.addLeft(-1);
        }
        if (binaryTree2.getRight() == null) {
            binaryTree2.addRight(-1);
        }
        copy(binaryTree.getLeft(), binaryTree2.getLeft());
        copy(binaryTree.getRight(), binaryTree2.getRight());
        if (binaryTree.getLeft().getValue() == -1) {
            binaryTree.removeLeft();
        }
        if (binaryTree.getRight().getValue() == -1) {
            binaryTree.removeRight();
        }
    }

    public static boolean alternativeSwap(BinaryTreeWithReferences binaryTree, int value) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return false;
        }
        if ((binaryTree.getLeft() != null &&
                !binaryTree.getLeft().isEmpty() &&
                binaryTree.getLeft().getValue() == value) ||
                (binaryTree.getRight() != null &&
                        !binaryTree.getRight().isEmpty() &&
                        binaryTree.getRight().getValue() == value)
        ) {
            BinaryTreeWithReferences aux = (BinaryTreeWithReferences) binaryTree.getLeft();
            binaryTree.addLeft(binaryTree.getRight());
            binaryTree.addRight(aux);
            return true;
        }

        return alternativeSwap((BinaryTreeWithReferences) binaryTree.getLeft(), value) ||
                alternativeSwap((BinaryTreeWithReferences) binaryTree.getRight(), value);
    }

    /**
     * Precondicion: Arbol no vacio
     * @param binaryTree arbol a mappear
     * @return codigo LaTeX que representa el arbol.
     */
    public static String latex(IBinaryTree binaryTree) {
        return "\\begin{tikzpicture}[level distance=1.5cm,\n" +
                "level 1/.style={sibling distance=6cm},\n" +
                "level 2/.style={sibling distance=3cm},\n" +
                "level 3/.style={sibling distance=1.5cm}]\n" +
                String.format("\\node[circle,draw] {$%d$}", binaryTree.getValue()) + "\n" +
                latexChild(binaryTree.getLeft(), 1) + "\n" +
                latexChild(binaryTree.getRight(), 1) + ";\n" +
                "\\end{tikzpicture}";
    }

    private static String latexChild(IBinaryTree binaryTree, int spaces) {
        if(binaryTree.getLeft() == null && binaryTree.getRight() == null) {
            return String.format("child {node[circle,draw] {$%s$}}", binaryTree.getValue());
        }

        if(binaryTree.getLeft() != null && binaryTree.getRight() == null) {
            return String.format("child {node[circle,draw] {$%s$}", binaryTree.getValue()) + "\n" +
                    repeatSpaces(spaces + 1) + latexChild(binaryTree.getLeft(), spaces + 1) + "\n" +
                    "}";
        }

        if(binaryTree.getLeft() == null && binaryTree.getRight() != null) {
            return String.format("child {node[circle,draw] {$%s$}", binaryTree.getValue()) + "\n" +
                    repeatSpaces(spaces + 1) + latexChild(binaryTree.getRight(), spaces + 1) + "\n" +
                    "}";
        }

        return String.format("child {node[circle,draw] {$%s$}", binaryTree.getValue()) + "\n" +
                repeatSpaces(spaces + 1) + latexChild(binaryTree.getLeft(), spaces + 1) + "\n" +
                repeatSpaces(spaces + 1) + latexChild(binaryTree.getRight(), spaces + 1) + "\n" +
                "}";
    }

    private static String repeatSpaces(int n) {
        if(n == 0) {
            return "";
        }
        return " " + repeatSpaces(n - 1);
    }



}

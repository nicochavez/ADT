package org.adt.core.adt.algorithms;

import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.implementation.normal.Set;
import org.adt.core.adt.algorithms.SetAlgorithms;

public class SetOperations {

    public static ISet copySet(ISet set){
        ISet copy = new Set();
        ISet copy2 = new Set();
        while (!set.isEmpty()){
            int aux = set.choose();
            copy.add(aux);
            copy2.add(aux);
            set.remove(aux);
        }
        while (!copy2.isEmpty()){
            int aux = copy2.choose();
            set.add(aux);
            copy2.remove(aux);
        }
        return copy;
    }

    public static boolean Include(ISet set1, ISet set2){
        ISet set1Copy = copySet(set1);
        ISet set2Copy = copySet(set2);
        while(!set2Copy.isEmpty()){
            int a = set2Copy.choose();
            if (!SetAlgorithms.in(set1Copy, a)){
                    return false;
            } else {
                set2Copy.remove(a);
            }
        }
        return true;
    }

    public static ISet difference(ISet set1, ISet set2){
        ISet set1Copy = copySet(set1);
        ISet set2Copy = copySet(set2);
        ISet setDifference = new Set();
        while (!set1Copy.isEmpty()){
            int x = set1.choose();
            if(!SetAlgorithms.in(set2Copy, x)){
                setDifference.add(x);
            }
            set1Copy.remove(x);
        }
        return setDifference;
    }

    public static ISet intersection(ISet set1, ISet set2){
        ISet set1Copy = copySet(set1);
        ISet set2Copy = copySet(set2);
        ISet setIntersect = new Set();
        while (!set1Copy.isEmpty()){
            int x = set1Copy.choose();
            if(SetAlgorithms.in(set2Copy, x)){
                setIntersect.add(x);
            }
            set1Copy.remove(x);
        }
        return setIntersect;
    }

    public static ISet union(ISet set1, ISet set2){
        ISet set1Copy = copySet(set1);
        ISet set2Copy = copySet(set2);
        ISet setUnion = new Set();
        while (!set1Copy.isEmpty()){
            int x = set1Copy.choose();
            setUnion.add(x);
            set1Copy.remove(x);
        }
        while (!set2Copy.isEmpty()){
            int x = set2Copy.choose();
            setUnion.add(x);
            set2Copy.remove(x);
        }
        return setUnion;
    }


}
    


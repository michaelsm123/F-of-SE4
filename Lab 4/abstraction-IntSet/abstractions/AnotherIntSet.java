package abstractions;

import java.util.Vector;

/**
 * This class implements an IntSet using a vector as its underlying data representation.
 * The vector elements are always unique.
 * @author dhou
 *
 */
public class AnotherIntSet {
private Vector elems; 

// constructor
public AnotherIntSet() {
	elems=new Vector();
}

/**
 * @param x the object to be inserted
 * MODIFIES: this
 * EFFECTS: if x is in the set, nothing happens;
 *          otherwise, x is added into this set.
 */
public void insert(Object x) {
	if (elems.contains(x))
		return;
	elems.add(x);
}

/**
 * @param x the integer to be removed
 * MODIFIES: this
 * EFFECTS: removes x from this set if it is in it.
 */
public void remove(Object x) {
	elems.remove(x);
}

/**
 * EFFECTS: returns the set elements as array
 */
public Object[] elements() {
	Object a[] = elems.toArray();
	return a;
}

/**
 * @return the number of integers in set
 */
public int size() {
	return elems.size();
}
/**
 * @param x the object to be checked
 * EFFECTS: returns true if x is in this set
 */
public boolean contains(Object x) {
	return elems.contains(x);
}

/**
 * EFFECTS: Returns a string representation suitable for printing.
 */
public String toString() {
	String tmp ="{";
	for (int i=0; i<elems.size()-1;++i) {
		tmp += elems.get(i)+",";
	}
	if (elems.size()>0) {
		tmp += elems.get(elems.size()-1);
	}
	tmp+="}"; return tmp;
}
}

package abstractions;

import java.util.Vector;

/**
 * This class implements IntSet using an array that is the fasted for insertion 
 * as it always appends a new integer to the end of the array, regardless whether it is already in the set or not.
 * @author dhou
 *
 */
public class YetIntSet {
private Object elems[]; 
private int index; 
private int size;
private static int initialSize=2;

// constructor
public YetIntSet() {
	elems=new Object[initialSize];
	index=0;
	size=0;
}

/**
 * @param x the object to be inserted
 * MODIFIES: this
 * EFFECTS: if x is in the set, nothing happens;
 *          otherwise, x is added into this set.
 */
public void insert(Object x) {
	int xIndex = getIndex(x);
	if (xIndex<0) { ++size;}
    growSize(); elems[index++]=x;
}
/**
 * EFFECTS: if x is in this, returns index where it appears else returns -1.
 * @param x
 * @return
 */
private int getIndex(Object x) {
	for (int i=0; i<index; ++i) {
	if (elems[i].equals(x)) { return i;}
	}
	return -1;
}
private void growSize() {
	if (index==elems.length) {
	Object tmp[]=new Object[elems.length*2];
	System.arraycopy(elems,0,tmp,0,elems.length);	elems = tmp;
	}
}

/**
 * @param x the integer to be removed
 * MODIFIES: this
 * EFFECTS: removes x from this set if it is in it.
 */
public void remove(Object x) {
	boolean found = false;
	while (true){
		int xIndex = getIndex(x);
		if (xIndex<0) {	if (found) size--;	return;}
		found = true;
		for (int i=xIndex; i<index-1;++i) {
			elems[i]=elems[i+1];
		}
		--index;
	}

}

/**
 * EFFECTS: returns the set elements as array
 */
public Object[] elements() {
	Object a[] = new Object[index];
	System.arraycopy(elems,0, a, 0, index);
	return a;
}

/**
 * EFFECTS: @return the number of unique integers in set
 */
public int size() {
	return size;
}
/**
 * @param x the object to be checked
 * EFFECTS: returns true if x is in this set
 */
public boolean contains(Object x) {
	return getIndex(x)>-1;
}

/**
 * EFFECTS: Returns a string representation of the set suitable for printing.
 * abstraction function:
 * [1, 2, 1] ---> {1, 2}
 * [1, 1, 2] ---> {1, 2}
 */
public String toString() {
	Vector printed = new Vector();
	for (int i=0; i<index;++i) {
		if (!printed.contains(elems[i]))
			printed.add(elems[i]);
	}
			
	String tmp ="{";
	for (int i=0; i<printed.size()-1;++i) {
			tmp += printed.get(i)+",";
	}
	if (printed.size()>0) {
		tmp += printed.get(printed.size()-1);
	}
	tmp+="}"; return tmp;
}
}

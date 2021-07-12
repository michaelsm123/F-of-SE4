package abstractions;

import java.util.Iterator;
import abstractions.SetIterator;
import exceptions.NoSuchElement;

/**
 * This class implements an IntSet using an array.
 * The array elements are always unique without duplicates.
 * @author dhou
 *
 */
public class IntSet {
private Object elems[]; 
private int index; // the next spot that can be used
private static int initialSize=2;

// constructor
public IntSet() {
	elems=new Object[initialSize];
	index=0;
}

/**
 * @param x the object to be inserted
 * MODIFIES: this
 * EFFECTS: if x is in the set, nothing happens;
 *          otherwise, x is added into this set.
 */
public void insert(Object x) {
	int xIndex = getIndex(x);
	if (xIndex<0) {
           growSize();  elems[index++]=x;
	}
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
	int xIndex = getIndex(x);
	if (xIndex<0) {	return;
	}
	for (int i=xIndex; i<index-1;++i) {
		elems[i]=elems[i+1];
	}
	--index;
}

/**
 * EFFECTS: returns the set elements as array
 */
//public Object[] elements() {
//	Object a[] = new Object[index];
//	System.arraycopy(elems,0, a, 0, index);
//	return a;
//}

// NEW CODE: iterator and generator
public Iterator elems(){
	return new SetIterator(this);
}
/*
private static class SetIterator implements Iterator{
	private IntSet s;
	private int n;
	
	public SetIterator(IntSet s) {this.s = s;}
	
	public boolean hasNext() { return n<s.index;}
	
	public Object next() throws NoSuchElement{
		if (n>=s.index) throw new NoSuchElement();
		int yield = (Integer)s.elems[n];
		++n;
		return yield;
	}
}
*/
public Object elements(int n) {
	return elems[n];
}


/**
 * @return the number of integers in set
 */
public int size() {
	return index;
}
/**
 * @param x the object to be checked
 * EFFECTS: returns true if x is in this set
 */
public boolean contains(Object x) {
	return getIndex(x)>-1;
}

/**
 * EFFECTS: Returns a string representation suitable for printing.
 */
public String toString() {
	String tmp ="{";
	for (int i=0; i<index-1;++i) {
		tmp += elems[i]+",";
	}
	if (index>0) {
		tmp += elems[index-1];
	}
	tmp+="}"; return tmp;
}
}

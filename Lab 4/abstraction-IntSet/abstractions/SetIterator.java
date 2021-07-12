package abstractions;

import java.util.Iterator;

import exceptions.NoSuchElement;

public class SetIterator implements Iterator {

	IntSet s;
	int n;
	
	public SetIterator(IntSet s) {this.s = s;}
	public boolean hasNext() { return n<s.size();}
	public Object next() throws NoSuchElement{
		if (n>=s.size()) throw new NoSuchElement();
		int yield = (Integer)s.elements(n);
		++n;
		return yield;
	}
	
}

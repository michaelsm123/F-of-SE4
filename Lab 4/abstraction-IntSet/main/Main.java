package main;

import java.util.Iterator;

import abstractions.AnotherIntSet;
import abstractions.IntSet;

public class Main {
       private static int a[]={1,2,3,3,2,1,100,101};

       public static void main(String[] args) {

		IntSet set=new IntSet();
		for (int i=0; i<a.length;++i)
		{
			set.insert(a[i]);
			System.out.println("After inserting "+a[i]+" set contains "+set);
		}
		System.out.println("After insertions, set contains "+set.size()+" elements.");
		
		for (Iterator<Integer> it = set.elems(); it.hasNext();){
			System.out.println(it.next());
		}
//		System.out.println(it.next());
		
//        set.remove(1);
//        set.remove(1);
//        set.remove(2);
//        set.remove(101);
//        set.remove(100);
//        set.remove(102); // 102 is not in the set
//        set.remove(101);
//		System.out.println("\nAfter removals, set contains "+set.size()+" elements.");
//		System.out.println(set);
//
//               /* Part 2 */
//		System.out.println("\nIn the array a, the following integers are duplicated:");
//		AnotherIntSet dupSet=new AnotherIntSet();
//		for (int i=0; i<a.length;++i)
//		{
//			if (dupSet.contains(a[i])){
//			   System.out.print(a[i]+" ");            
//			}
//			dupSet.insert(a[i]);
//		}
//		
//		System.out.println();
	}
}
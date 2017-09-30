package util;

import java.util.Iterator;

public class Util {
	public static void iteratorAllElements(Iterator iterator){
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
	}
}

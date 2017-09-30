package capter1DataStruture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestBag {
	public  static void main(String args[]){
		Bag bag=new Bag<String>();
		bag.add("A");
		bag.add("B");
		bag.add("C");
		bag.add("D");
		bag.add("E");
		System.out.println(bag.size());
		
		Iterator<String> iterator=bag.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
		
		System.out.println(bag.size());
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
		
		
		System.out.println("third times iterator: "+bag.size());
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
	}
	
}

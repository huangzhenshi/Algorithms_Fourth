package capter1DataStruture;

import java.util.Iterator;

import util.Util;

public class TestQue{
	public  static void main(String args[]){
		Queue<String> Queue=new Queue<String>();
		Queue.push("A");
		Queue.push("B");
		Queue.push("C");
		Queue.pop();
		Queue.push("D");
		Queue.push("E");
		System.out.println(Queue.size());

		Iterator<String> iterator=Queue.iterator();
		Util.iteratorAllElements(iterator);
		
		System.out.println("once again"+Queue.size());
		Util.iteratorAllElements(iterator);
	}
	
}
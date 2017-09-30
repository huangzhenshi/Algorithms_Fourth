package capter1DataStruture;

import java.util.Iterator;

import util.Util;

public class TestStack {
	public  static void main(String args[]){
		Stack<String> stack=new Stack<String>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.pop();
		stack.push("D");
		stack.push("E");
		System.out.println(stack.size());

		Iterator<String> iterator=stack.iterator();
		Util.iteratorAllElements(iterator);
		
		System.out.println("once again"+stack.size());
		Util.iteratorAllElements(iterator);
	}
	
}
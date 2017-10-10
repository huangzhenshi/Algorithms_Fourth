package orde;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Test extends Example{
	public static void main(String[] args) {
	/*	MaxMQ mq=new MaxMQ();
		mq.setN(20);
		//test insert
		for(int k=0;k<20;k++){
			int data=mq.generatData();
			System.err.println("generate num is :"+data);
			mq.insert(data);
			mq.print();
		}
		
		for(int k=0;k<20;k++){
			System.out.println("delmax is :"+mq.delMax());
			mq.print();
		}
		*/
/*		List list=generatList(20);
		Heap hp=new Heap();
		hp.list=list;
		
		
		System.out.println(list.toString());
		hp.sort(list);
		System.out.println(list.toString());*/
		
		int[] arr=generateUniqueArr(60);
		Arrays.sort(arr);
		
		
	}
	
	public static int[] generateUniqueArr(int length){
		int MAX_SIZE=10000;
		if(length>MAX_SIZE){
			System.out.println("length bigger than MAX_SIZE");
			return null;
		}
		Set<Integer> resultSet=new HashSet();
		
		int[] result=new int[length];
		while(resultSet.size()<length){
			int ran=(int) Math.round(Math.random()*MAX_SIZE);
			resultSet.add(ran);
		}
		int index=0;
		for(int element: resultSet){
			result[index]=element;
			index++;
		}
		return result;
	}
}

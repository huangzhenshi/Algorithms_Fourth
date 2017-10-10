package orde;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Example {
	int size(){
		return list.size()-1;
	}

	public  int N=0;
	public  int getN() {
		return N;
	}

	public  void setN(int n) {
		N = n;
	}

	public boolean less(int before,int after){
		if(before<after) return true;
		return false;
	}
	
	List<Integer> list= new ArrayList<>();
	
	
	//参数是下标
	void exch(int index1,int index2){
		int k=list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, k);
	}
	
	static int generatData(){
		
		int result=(int)Math.round(Math.random()*5000);
		while(dataSet.contains(result)){
			result=(int)Math.round(Math.random()*5000);
		}
		dataSet.add(result);
		return result;
	}
	
	static Set<Integer> dataSet=new HashSet();
	
	public void print(){
		System.out.println(list.toString());
		
	}
	
	//获取一个随机不重复 指定大小的数组
	public static List<Integer> generatList(int size){
		List<Integer> list = new  ArrayList<>();
		list.add(null);
		for(int k=0;k<size;k++){
			list.add(generatData());
		}
		return list;
		
	}
	
}

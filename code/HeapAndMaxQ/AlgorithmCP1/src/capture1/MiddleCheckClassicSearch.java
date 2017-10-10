package capture1;

import java.util.Arrays;

import commonFunction.Utils;

public class MiddleCheckClassicSearch {
	public static void main(String[] args) {
		Integer[] orginArr={1,3,5,6,11,11,234,2,1,56,2000,34};
		Arrays.sort(orginArr);
		Utils.printArr(orginArr);
		Integer targer=200;
		int index=find(orginArr,targer);
		if(index!=-1){
			System.out.println("we find "+targer+", the "+(index+1)+"'s element is the target");
		}else{
			System.out.println("fail to find "+targer);
		}
		
		
		
	}
	
	public static int find(Integer[] data,Integer target){
		// data has sort before ,grow bigger and bigger
		int index=-1;
		int leftIndex=0;
		int rightIndex=data.length-1;
		while(leftIndex<rightIndex){
			int compareIndex=leftIndex+(rightIndex-leftIndex)/2;
			if(target<data[compareIndex]){
				rightIndex=compareIndex;
			}else if(target>data[compareIndex]){
				leftIndex=compareIndex;
			}else{
				return compareIndex;
			}
			
		}
		return -1;
		
	}
	
	
	
	
}

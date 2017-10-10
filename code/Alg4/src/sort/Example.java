package sort;

import java.util.HashSet;
import java.util.Set;

import util.TimeCostUtil;

/*--API
 * exch() 
 * less()
 * show()
 * isSorted()
 * antiOrder(int[] arr)
 * getCount()
 * getExchCount()
 * 
 * */
public class Example {
	public static final int MAX_SIZE=200000;
	public static boolean less(int a,int b){
		return a<b;
	}
	
	public int compare(int a,int b){
		if(a>b){
			return 1;
		}else if(a<b){
			return -1;
		}else{
			return 0;
		}
	}
	
	public static boolean lessCount(int a,int b){
		count++;
		return a<b;
	}
	public static void exchCount(int[] a,int i,int j){
		int tem=a[i];
		a[i]=a[j];
		a[j]=tem;
		exchCount++;
	}
	
	public static void exch(int[] a,int i,int j){
		int tem=a[i];
		a[i]=a[j];
		a[j]=tem;
	}
	
	public static void show(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"  ");
		}
		System.out.println("");
	}
	
	public static boolean isSorted(int[] a){
		for(int i=1;i<a.length;i++){
			if(less(a[i],a[i-1])) return false;
		}
		return true;
	}
	
	
	public static int[] generateUniqueArr(int length){
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
	
	public static long count=0;
	public static long getCount(){
		return count;
	}
	
	public static long exchCount=0;
	public static long getExchCoount(){
		return exchCount;
	}
	
	public static int[] antiOrder(int[] arr){
		int length=arr.length;
		int[] result=new int[length];
		for(int i=0;i<arr.length;i++){
			result[i]=arr[length-1-i];
			
		}
		return result;
	}
	
	//比较精准的求排序耗时，排除了 生成数组的时间，仅仅只是 sort过程的时间。
	public static long testCostByType(SortInterface exa,int size,boolean isCount){
		TimeCostUtil util=new TimeCostUtil();
		int[] arr=generateUniqueArr(size);
		util.start();
		if( isCount){
			exa.sortCount(arr);
		}else{
			exa.sort(arr);
		}
		//检查每次排序后的数组是否有序
		System.out.println("isSort result: "+isSorted(arr));
		long cost=util.getCost();
		return cost;
	}
	
	public static  long testAveCost(SortInterface exa,int size,int times,boolean isCount){
		long sum=0;
		for(int i=0;i<times;i++){
			sum+=testCostByType(exa,size,isCount);
		}
		System.out.println(sum);
		if( isCount){
			System.out.println("sumLessTimes:"+count);
			System.out.println("sumExchTimes:"+exchCount);
		}
		return sum;
	}
	//根据size 和 sort类型，system.out 耗时,每次都测试1000次，取1000次的sum耗时
	public static void outputCostByGrowSize(int initSize,int grow,SortInterface sort,boolean isCount){
		int size=initSize;
		//最大size 10000个
		while(size<=(MAX_SIZE/20)){
			System.out.println("this time  the arrSize is: "+size);
			testAveCost(sort,size,5,isCount);
			size+=grow;
			count=0;
			exchCount=0;
			
			
		}
	}
	
	
}

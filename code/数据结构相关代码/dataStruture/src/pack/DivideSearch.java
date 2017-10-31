package pack;

public class DivideSearch {
	//二分查找特性 最差情况想的比较次数是 lgN次
	// rank  arr,lo,--mid,key  而不是让hi=mid，因为 --mid的话，最后会有hi<lo的时候
	//所以分为4种情况
	//如果命中就返回该key在 arr中的下标位置；
	//如果小于最小值 就返回 -1； 如果大于最大值就返回 hi+1
	//如果未命中，则返回的是该新元素在arr中 应有的位置
	public static int rank(int[] arr,int lo,int hi,int key){
		 	if(hi==-1) return hi; 
			if(hi<lo) return lo;
			int mid=lo+(hi-lo)/2;
			if(key<arr[mid]){
				return rank(arr,lo,--mid,key);
			}else if (key>arr[mid]){
				return rank(arr,++mid,hi,key);
			}else{
				return mid;
			}
	}
	
	public static void  main(String[] argu){
		int[] data={1,2,3,4,7,8,9};
		int result=rank(data,0,6,5);
		System.out.print(result);
		
		
	} 
	
	public void put(int key,int value){
		int rank=rank(arr,0,arr.length-1,key);
	}
	
	public int[] arr;
}

package sort;

public class Merge extends Example implements SortInterface{
	//数据源是一个不重复的数组
	@Override
	public  void sort(int[] arr){
		/*sort(arr,0,arr.length-1);*/
		sortAdvance(arr,0,arr.length-1);
	}
	//递归按照切分段 给数组排序
	public void sort(int[] arr,int lo,int hi){
		if(lo>=hi) return;
	    int mid=lo+(hi-lo)/2;
		sort(arr,lo,mid);
		sort(arr,mid+1,hi);
		merge(arr,lo,mid,hi);
	}
	
	// arr数组 arr[0] -- arr[mid] 是有序的数组； arr[mid+1] -- arr[hi] 也是有序的数组，当mid=0的时候，就只有一个元素的时候肯定就是有序的数组了
	public void merge(int[] arr, int lo,int mid,int hi){
		//i 表示 arr1 的轮询到的下标位置， lo<=i<=mid  ； i++
		int i=lo;
		
		//j 表示 arr2 的轮询到的下标位置，mid+1<=j<=hi ； j++
		int j=mid+1;
		
		//申明一个数组作为辅助数组，拷贝出
		int[] aux =new int[arr.length];
		for(int k=lo;k<=hi;k++){
			aux[k]=arr[k];
		}
		for(int k=lo;k<=hi;k++){
			//当第一个数组元素用尽的时候，后续就不需要调整了，因为后面的数组本来就是有序的
			if(i>mid) 						return;
			//当第二个数组元素用尽的时候，就需要把前面的i之后的元素，填充到后面当中
			else if(j>hi)					arr[k]=aux[i++];
			//记住这里是 用不变数值的 aux数组进行比较啊，千万不能用 arr 原数组比较啊，坑爹
			else if(less(aux[j],aux[i]))    arr[k]=aux[j++];
			else 							arr[k]=aux[i++];
		}
	}
	
	//递归按照切分段 给数组排序
		public void sortAdvance(int[] arr,int lo,int hi){
			if(lo+10>=hi) {
				new Insertion().sortParty(arr,lo,hi);
				return;	
			}
		    int mid=lo+(hi-lo)/2;
		    sortAdvance(arr,lo,mid);
		    sortAdvance(arr,mid+1,hi);
		    mergeAdvance(arr,lo,mid,hi);
		}
		
		public void mergeAdvance(int[] arr, int lo,int mid,int hi){
			
		/*	if(less(arr[mid],arr[mid+1])){
				return;
			}*/
			
			//i 表示 arr1 的轮询到的下标位置， lo<=i<=mid  ； i++
			int i=lo;
			
			//j 表示 arr2 的轮询到的下标位置，mid+1<=j<=hi ； j++
			int j=mid+1;
			
			//申明一个数组作为辅助数组，拷贝出
			int[] aux =new int[arr.length];
			for(int k=lo;k<=hi;k++){
				aux[k]=arr[k];
			}
			for(int k=lo;k<=hi;k++){
				//当第一个数组元素用尽的时候，后续就不需要调整了，因为后面的数组本来就是有序的
				if(i>mid) 						return;
				//当第二个数组元素用尽的时候，就需要把前面的i之后的元素，填充到后面当中
				else if(j>hi)					arr[k]=aux[i++];
				//记住这里是 用不变数值的 aux数组进行比较啊，千万不能用 arr 原数组比较啊，坑爹
				else if(less(aux[j],aux[i]))    arr[k]=aux[j++];
				else 							arr[k]=aux[i++];
			}
		}
	

	@Override
	public void sortCount(int[] arr) {
		
	}
	
	
}



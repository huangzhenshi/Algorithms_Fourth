package sort;

public class Quick extends Example implements SortInterface{

	//数据源是一个不重复的数组
	//排序规则：
	@Override
	public  void sort(int[] arr){
	/*	sortPart(arr,0,arr.length-1,false);*/
	/*	sortPartAdvance(arr,0,arr.length-1,false,10);*/
		sortRepeatArr(arr,0,arr.length-1);
		
		
	}
	
	//递归按照切分段 给数组排序
	public void sortPart(int[] arr,int lo,int hi,boolean isCount){
		if(lo>=hi) return;
		int index=0;
		if(isCount){
			index=partitionCount(arr,lo,hi);
		}else{
			index=partition(arr,lo,hi);
		}
	
		sortPart(arr,lo,index-1,isCount);
		sortPart(arr,index+1,hi,isCount);
	}
	
	// 功能： 1）移动数组   2）返回切分后的切分下标
	private static int partition(int[] arr,int lo,int hi){
		int i=lo,j=hi+1;
		int v=arr[lo];
		while(true){
			// 5  1 3 8 4 6 9 2 11   --> 1 3 8  i=2  arr[2]=8      
			
			//标杆值 从初始位置挨个和后续元素比较，直到后续元素比标杆元素大，或者是后续元素到了最后的位置
			//下标i 移动，直到找到比标杆元素大的下标为止，获取到i的值，要交换
			while(less(arr[++i],v)){
				if(i>=hi) break;
			}
			
			// 5  1 3 8 4 6 9 2 11  -->2 11 j=7 arr[7]=2 
			
			while(less(v,arr[--j])){
				if(j<=lo) break;
			}

			if(i>=j) break;
			//交换之后 因为i 和 j的值是在外面申明过的，所以不会重复比较之前比较过的对象 从 arr[i] -- arr[j] 区间继续比较
			// 5  1 3 2      4 6 9       8 11  --> 8  和 2 交换位置
			exch(arr,i,j);
		}
		//一定要记得 最后一次要把标杆值 和新的标杆值交换位置啊
		exch(arr,lo,j);
		return j;
	}
	
	private static int partitionCount(int[] arr,int lo,int hi){
		int i=lo,j=hi+1;
		int v=arr[lo];
		while(true){
			// 5  1 3 8 4 6 9 2 11   --> 1 3 8  i=2  arr[2]=8      
			
			//标杆值 从初始位置挨个和后续元素比较，直到后续元素比标杆元素大，或者是后续元素到了最后的位置
			//下标i 移动，直到找到比标杆元素大的下标为止，获取到i的值，要交换
			while(lessCount(arr[++i],v)){
				if(i>=hi) break;
			}
			
			// 5  1 3 8 4 6 9 2 11  -->2 11 j=7 arr[7]=2 
			
			while(lessCount(v,arr[--j])){
				if(j<=lo) break;
			}

			if(i>=j) break;
			//交换之后 因为i 和 j的值是在外面申明过的，所以不会重复比较之前比较过的对象 从 arr[i] -- arr[j] 区间继续比较
			// 5  1 3 2      4 6 9       8 11  --> 8  和 2 交换位置
			exchCount(arr,i,j);
		}
		//一定要记得 最后一次要把标杆值 和新的标杆值交换位置啊
		exchCount(arr,lo,j);
		return j;
	}

	@Override
	public void sortCount(int[] arr) {
		
		sortPart(arr,0,arr.length-1,true);
	}
	
	
	
	public void sortPartAdvance(int[] arr,int lo,int hi,boolean isCount,int argu){
		//当数组为10个以内大小的时候，改用插入排序，会更快
		argu=10;
		if(lo+argu>=hi) {
			Insertion exa=new Insertion();
			int[] shortArr=new int[argu];
			System.arraycopy(arr,lo,shortArr,0,argu);
			exa.sort(shortArr);
			return;
		}
		int index=0;
		if(isCount){
			index=partitionCount(arr,lo,hi);
		}else{
			index=partition(arr,lo,hi);
		}
	
		sortPart(arr,lo,index-1,isCount);
		sortPart(arr,index+1,hi,isCount);
	}
	
	//该方法和 标准的快速排序其实不同，标准的是 左右开弓比较，而下面的比较是仅仅和下一个元素比较，比哨兵小的统统扔到数组的后面去
	public void sortRepeatArr(int[] arr,int lo,int hi){
		if(lo>=hi) return;
		//lt 是哨兵位置，目标是整理一个 数组，找到哨兵的准确位置，哨兵左边的元素都比哨兵小，哨兵右边的元素都比哨兵大
		int lt=lo;
		//比较好的最后一个末位下标， 表示gt前的元素 要么没比较过，要么比哨兵小，gt 后面的所有元素都比哨兵大
		//区分开来，gt不是hi，hi是末位元素，而gt是比较后结果位置
		int gt=hi;
		//i是和哨兵比较的元素下标
		int i=lo+1;
		//哨兵值
		int v=arr[lt];
		while(i<=gt){
			//如果比较元素比 哨兵小 ，则交换 比较元素和哨兵元素的位置
			//同时比较后一个元素 i ++ 
			//同时哨兵的位置往后调整 1，因为交换了元素，所以哨兵的下标也发生了 变化，但是有2种情况，
			  	 //  1 2  5  4 6 3 4 8 9  假设当前哨兵是 5. 和4比较， 4比5小 ，交换位置，
				// 1 2  |4  5| 6 3 4 8 9  此时哨兵元素还是5，交换前 哨兵下边是 arr[2]，交换后 哨兵下标 lt++； 值就是3了，同时比较元素下边i 也要变大
			//第二种情况有多个相同的哨兵的话， lt ++ 就是让下一个哨兵 顶上
			    //  1 2 5 5 4 6 3 4 8 9  当前哨兵下标是arr[2] lt=2   比较元素i=4 ，交换之后
				//  1 2 4 5 5 6 3 4 8 9 交换之后 哨兵位置是3 而老的哨兵 在 arr[4]的 位置，最新的哨兵 之前的arr[3]
			
			if(compare(arr[i],v)<0){  
				exch(arr,lt++,i++);
			}else if(compare(arr[i],v)>0){
				//如果比较元素比哨兵大的话， 则用gt 来维护一群比哨兵大的元素，和gt互换位置，且gt下标左移一次
				// 1 2 5 5 6 7 47 8 3   假设当前哨兵是5 lt=2 arr[2]=5, 当前比较元素 arr[4]=6, 当前gt 为hi
				// 1 2 5 5 3 7 47 8 6  <--交换之后的结果  gt -- ，所以gt就从末位下标 arr[8]  变成7了
				
				exch(arr,gt--,i);
			}else{
				i++;
			}
		}
		sortRepeatArr(arr,lo,lt-1);
		sortRepeatArr(arr,gt+1,hi);
		
	}
	
}

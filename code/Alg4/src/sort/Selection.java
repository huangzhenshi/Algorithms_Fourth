package sort;

public class Selection extends Example implements SortInterface{

	//数据源是一个不重复的数组
	//排序规则： 遍历所有的元素，min作为指针找到最小的元素的下标，结束后，替换第i个元素和最小的元素交换位置
	@Override
	public void sort(int[] arr){
		//reset this count
		count=0;
		exchCount=0;
		//从第一个数组开始和后面 (n-1）个数据比较，但是当i=最后一个的时候  arr[max]的时候就不需要比较了
		for(int i=0;i<arr.length-1;i++){
			int min=i;
			for(int j=i+1;j<arr.length;j++){
				if(less(arr[j],arr[min])) min=j;
			}
			exch(arr,i,min);
		}
	}

	@Override
	public void sortCount(int[] arr) {
		//从第一个数组开始和后面 (n-1）个数据比较，但是当i=最后一个的时候  arr[max]的时候就不需要比较了
		for(int i=0;i<arr.length-1;i++){
			int min=i;
			for(int j=i+1;j<arr.length;j++){
				if(lessCount(arr[j],arr[min])) min=j;
			}
			exchCount(arr,i,min);
		}

	}
	

}

package sort;

public class Insertion extends Example implements SortInterface{

	//数据源是一个不重复的数组
	//排序规则：桥牌打发，从二个元素开始，维护一个递增的数组，如果某元素小于 最大值，就和最大值互换位置，与次大值比较
	@Override
	public  void sort(int[] arr){
		count=0;
		exchCount=0;
		for(int i=1;i<arr.length;i++){
			int j=i;
				while(j>0&&less(arr[j],arr[j-1])){
					exch(arr,j,j-1);
					j--;
				}
		}
	}

	@Override
	public void sortCount(int[] arr) {
		for(int i=1;i<arr.length;i++){
			int j=i;
				while(j>0&&lessCount(arr[j],arr[j-1])){
					exchCount(arr,j,j-1);
					j--;
				}
		}
		
	}
	
}

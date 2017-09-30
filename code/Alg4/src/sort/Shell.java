package sort;

public class Shell extends Example implements SortInterface{

	//数据源是一个不重复的数组
	//排序规则：基于插入排序的加强版，先大跨度的做插入排序（先13调，调完再按4来调），基本接近最后位置，再按照1的一次完整插入排序
	//特点1）任意相隔 H 的元素都是有序的    2）由许许多个独立的有序的小数组组成 
	@Override
	public  void sort(int[] arr){
		count=0;
		exchCount=0;
		int size=arr.length;
		int h=1;
		while(h<size/3) h=h*3+1;   // 1 4 13 40 grow with size ,多乘一次，就多一次跨度的希尔排序
		
		while(h>=1){
			for(int i=h;i<size;i++){
				for(int j=i;j>=h&&less(arr[j],arr[j-h]);j-=h){
					exch(arr,j,j-h);
				}
			}
			h=h/3;
		}
		
	}

	@Override
	public void sortCount(int[] arr) {
		int size=arr.length;
		int h=1;
		while(h<size/3) h=h*3+1;   // 1 4 13 40 grow with size ,多乘一次，就多一次跨度的希尔排序
		
		while(h>=1){
			for(int i=h;i<size;i++){
				for(int j=i;j>=h&&lessCount(arr[j],arr[j-h]);j-=h){
					exchCount(arr,j,j-h);
				}
			}
			h=h/3;
		}
		
	}
}

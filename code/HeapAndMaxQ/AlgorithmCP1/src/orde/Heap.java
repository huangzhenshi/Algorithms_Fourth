package orde;

import java.util.List;

public class Heap extends MaxMQ{
	
	
	//不同于 MaxMQ，已知一个无序的堆，进行排序成 数组有序
	public void sort(List<Integer> list){
		int N=list.size()-1;
		//先把数组构建成堆结构
		for(int k=N/2;k>=1;k--){
			sink(k,N);
		}
		int copySize=N;
		//需要重写 或者扩展 sink 方法，要让 sink 是根据 size大小进行下沉
		//这里递减的要用 copySize啊，因为要循环N 次，如果直接用N--的话， k每增加一次 ，N就减少1次，只能做到一半的数据排序了
		for(int k=1;k<N;k++){
			exch(1,copySize);
			sink(1,--copySize);
		}
	}
}

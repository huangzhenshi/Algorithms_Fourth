package sort;

public class Merge extends Example implements SortInterface{
	//����Դ��һ�����ظ�������
	@Override
	public  void sort(int[] arr){
		/*sort(arr,0,arr.length-1);*/
		sortAdvance(arr,0,arr.length-1);
	}
	//�ݹ鰴���зֶ� ����������
	public void sort(int[] arr,int lo,int hi){
		if(lo>=hi) return;
	    int mid=lo+(hi-lo)/2;
		sort(arr,lo,mid);
		sort(arr,mid+1,hi);
		merge(arr,lo,mid,hi);
	}
	
	// arr���� arr[0] -- arr[mid] ����������飻 arr[mid+1] -- arr[hi] Ҳ����������飬��mid=0��ʱ�򣬾�ֻ��һ��Ԫ�ص�ʱ��϶����������������
	public void merge(int[] arr, int lo,int mid,int hi){
		//i ��ʾ arr1 ����ѯ�����±�λ�ã� lo<=i<=mid  �� i++
		int i=lo;
		
		//j ��ʾ arr2 ����ѯ�����±�λ�ã�mid+1<=j<=hi �� j++
		int j=mid+1;
		
		//����һ��������Ϊ�������飬������
		int[] aux =new int[arr.length];
		for(int k=lo;k<=hi;k++){
			aux[k]=arr[k];
		}
		for(int k=lo;k<=hi;k++){
			//����һ������Ԫ���þ���ʱ�򣬺����Ͳ���Ҫ�����ˣ���Ϊ��������鱾�����������
			if(i>mid) 						return;
			//���ڶ�������Ԫ���þ���ʱ�򣬾���Ҫ��ǰ���i֮���Ԫ�أ���䵽���浱��
			else if(j>hi)					arr[k]=aux[i++];
			//��ס������ �ò�����ֵ�� aux������бȽϰ���ǧ������ arr ԭ����Ƚϰ����ӵ�
			else if(less(aux[j],aux[i]))    arr[k]=aux[j++];
			else 							arr[k]=aux[i++];
		}
	}
	
	//�ݹ鰴���зֶ� ����������
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
			
			//i ��ʾ arr1 ����ѯ�����±�λ�ã� lo<=i<=mid  �� i++
			int i=lo;
			
			//j ��ʾ arr2 ����ѯ�����±�λ�ã�mid+1<=j<=hi �� j++
			int j=mid+1;
			
			//����һ��������Ϊ�������飬������
			int[] aux =new int[arr.length];
			for(int k=lo;k<=hi;k++){
				aux[k]=arr[k];
			}
			for(int k=lo;k<=hi;k++){
				//����һ������Ԫ���þ���ʱ�򣬺����Ͳ���Ҫ�����ˣ���Ϊ��������鱾�����������
				if(i>mid) 						return;
				//���ڶ�������Ԫ���þ���ʱ�򣬾���Ҫ��ǰ���i֮���Ԫ�أ���䵽���浱��
				else if(j>hi)					arr[k]=aux[i++];
				//��ס������ �ò�����ֵ�� aux������бȽϰ���ǧ������ arr ԭ����Ƚϰ����ӵ�
				else if(less(aux[j],aux[i]))    arr[k]=aux[j++];
				else 							arr[k]=aux[i++];
			}
		}
	

	@Override
	public void sortCount(int[] arr) {
		
	}
	
	
}



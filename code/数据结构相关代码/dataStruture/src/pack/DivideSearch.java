package pack;

public class DivideSearch {
	//���ֲ������� ��������ıȽϴ����� lgN��
	// rank  arr,lo,--mid,key  ��������hi=mid����Ϊ --mid�Ļ���������hi<lo��ʱ��
	//���Է�Ϊ4�����
	//������оͷ��ظ�key�� arr�е��±�λ�ã�
	//���С����Сֵ �ͷ��� -1�� ����������ֵ�ͷ��� hi+1
	//���δ���У��򷵻ص��Ǹ���Ԫ����arr�� Ӧ�е�λ��
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

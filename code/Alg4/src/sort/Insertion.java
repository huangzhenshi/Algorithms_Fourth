package sort;

public class Insertion extends Example implements SortInterface{

	//����Դ��һ�����ظ�������
	//����������ƴ򷢣��Ӷ���Ԫ�ؿ�ʼ��ά��һ�����������飬���ĳԪ��С�� ���ֵ���ͺ����ֵ����λ�ã���δ�ֵ�Ƚ�
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

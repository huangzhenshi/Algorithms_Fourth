package sort;

public class Shell extends Example implements SortInterface{

	//����Դ��һ�����ظ�������
	//������򣺻��ڲ�������ļ�ǿ�棬�ȴ��ȵ�������������13���������ٰ�4�������������ӽ����λ�ã��ٰ���1��һ��������������
	//�ص�1��������� H ��Ԫ�ض��������    2���������������������С������� 
	@Override
	public  void sort(int[] arr){
		count=0;
		exchCount=0;
		int size=arr.length;
		int h=1;
		while(h<size/3) h=h*3+1;   // 1 4 13 40 grow with size ,���һ�Σ��Ͷ�һ�ο�ȵ�ϣ������
		
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
		while(h<size/3) h=h*3+1;   // 1 4 13 40 grow with size ,���һ�Σ��Ͷ�һ�ο�ȵ�ϣ������
		
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

package sort;

public class Selection extends Example implements SortInterface{

	//����Դ��һ�����ظ�������
	//������� �������е�Ԫ�أ�min��Ϊָ���ҵ���С��Ԫ�ص��±꣬�������滻��i��Ԫ�غ���С��Ԫ�ؽ���λ��
	@Override
	public void sort(int[] arr){
		//reset this count
		count=0;
		exchCount=0;
		//�ӵ�һ�����鿪ʼ�ͺ��� (n-1�������ݱȽϣ����ǵ�i=���һ����ʱ��  arr[max]��ʱ��Ͳ���Ҫ�Ƚ���
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
		//�ӵ�һ�����鿪ʼ�ͺ��� (n-1�������ݱȽϣ����ǵ�i=���һ����ʱ��  arr[max]��ʱ��Ͳ���Ҫ�Ƚ���
		for(int i=0;i<arr.length-1;i++){
			int min=i;
			for(int j=i+1;j<arr.length;j++){
				if(lessCount(arr[j],arr[min])) min=j;
			}
			exchCount(arr,i,min);
		}

	}
	

}

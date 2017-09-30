package sort;

public class Quick extends Example implements SortInterface{

	//����Դ��һ�����ظ�������
	//�������
	@Override
	public  void sort(int[] arr){
	/*	sortPart(arr,0,arr.length-1,false);*/
	/*	sortPartAdvance(arr,0,arr.length-1,false,10);*/
		sortRepeatArr(arr,0,arr.length-1);
		
		
	}
	
	//�ݹ鰴���зֶ� ����������
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
	
	// ���ܣ� 1���ƶ�����   2�������зֺ���з��±�
	private static int partition(int[] arr,int lo,int hi){
		int i=lo,j=hi+1;
		int v=arr[lo];
		while(true){
			// 5  1 3 8 4 6 9 2 11   --> 1 3 8  i=2  arr[2]=8      
			
			//���ֵ �ӳ�ʼλ�ð����ͺ���Ԫ�رȽϣ�ֱ������Ԫ�رȱ��Ԫ�ش󣬻����Ǻ���Ԫ�ص�������λ��
			//�±�i �ƶ���ֱ���ҵ��ȱ��Ԫ�ش���±�Ϊֹ����ȡ��i��ֵ��Ҫ����
			while(less(arr[++i],v)){
				if(i>=hi) break;
			}
			
			// 5  1 3 8 4 6 9 2 11  -->2 11 j=7 arr[7]=2 
			
			while(less(v,arr[--j])){
				if(j<=lo) break;
			}

			if(i>=j) break;
			//����֮�� ��Ϊi �� j��ֵ���������������ģ����Բ����ظ��Ƚ�֮ǰ�ȽϹ��Ķ��� �� arr[i] -- arr[j] ��������Ƚ�
			// 5  1 3 2      4 6 9       8 11  --> 8  �� 2 ����λ��
			exch(arr,i,j);
		}
		//һ��Ҫ�ǵ� ���һ��Ҫ�ѱ��ֵ ���µı��ֵ����λ�ð�
		exch(arr,lo,j);
		return j;
	}
	
	private static int partitionCount(int[] arr,int lo,int hi){
		int i=lo,j=hi+1;
		int v=arr[lo];
		while(true){
			// 5  1 3 8 4 6 9 2 11   --> 1 3 8  i=2  arr[2]=8      
			
			//���ֵ �ӳ�ʼλ�ð����ͺ���Ԫ�رȽϣ�ֱ������Ԫ�رȱ��Ԫ�ش󣬻����Ǻ���Ԫ�ص�������λ��
			//�±�i �ƶ���ֱ���ҵ��ȱ��Ԫ�ش���±�Ϊֹ����ȡ��i��ֵ��Ҫ����
			while(lessCount(arr[++i],v)){
				if(i>=hi) break;
			}
			
			// 5  1 3 8 4 6 9 2 11  -->2 11 j=7 arr[7]=2 
			
			while(lessCount(v,arr[--j])){
				if(j<=lo) break;
			}

			if(i>=j) break;
			//����֮�� ��Ϊi �� j��ֵ���������������ģ����Բ����ظ��Ƚ�֮ǰ�ȽϹ��Ķ��� �� arr[i] -- arr[j] ��������Ƚ�
			// 5  1 3 2      4 6 9       8 11  --> 8  �� 2 ����λ��
			exchCount(arr,i,j);
		}
		//һ��Ҫ�ǵ� ���һ��Ҫ�ѱ��ֵ ���µı��ֵ����λ�ð�
		exchCount(arr,lo,j);
		return j;
	}

	@Override
	public void sortCount(int[] arr) {
		
		sortPart(arr,0,arr.length-1,true);
	}
	
	
	
	public void sortPartAdvance(int[] arr,int lo,int hi,boolean isCount,int argu){
		//������Ϊ10�����ڴ�С��ʱ�򣬸��ò������򣬻����
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
	
	//�÷����� ��׼�Ŀ���������ʵ��ͬ����׼���� ���ҿ����Ƚϣ�������ıȽ��ǽ�������һ��Ԫ�رȽϣ����ڱ�С��ͳͳ�ӵ�����ĺ���ȥ
	public void sortRepeatArr(int[] arr,int lo,int hi){
		if(lo>=hi) return;
		//lt ���ڱ�λ�ã�Ŀ��������һ�� ���飬�ҵ��ڱ���׼ȷλ�ã��ڱ���ߵ�Ԫ�ض����ڱ�С���ڱ��ұߵ�Ԫ�ض����ڱ���
		int lt=lo;
		//�ȽϺõ����һ��ĩλ�±꣬ ��ʾgtǰ��Ԫ�� Ҫôû�ȽϹ���Ҫô���ڱ�С��gt ���������Ԫ�ض����ڱ���
		//���ֿ�����gt����hi��hi��ĩλԪ�أ���gt�ǱȽϺ���λ��
		int gt=hi;
		//i�Ǻ��ڱ��Ƚϵ�Ԫ���±�
		int i=lo+1;
		//�ڱ�ֵ
		int v=arr[lt];
		while(i<=gt){
			//����Ƚ�Ԫ�ر� �ڱ�С ���򽻻� �Ƚ�Ԫ�غ��ڱ�Ԫ�ص�λ��
			//ͬʱ�ȽϺ�һ��Ԫ�� i ++ 
			//ͬʱ�ڱ���λ��������� 1����Ϊ������Ԫ�أ������ڱ����±�Ҳ������ �仯��������2�������
			  	 //  1 2  5  4 6 3 4 8 9  ���赱ǰ�ڱ��� 5. ��4�Ƚϣ� 4��5С ������λ�ã�
				// 1 2  |4  5| 6 3 4 8 9  ��ʱ�ڱ�Ԫ�ػ���5������ǰ �ڱ��±��� arr[2]�������� �ڱ��±� lt++�� ֵ����3�ˣ�ͬʱ�Ƚ�Ԫ���±�i ҲҪ���
			//�ڶ�������ж����ͬ���ڱ��Ļ��� lt ++ ��������һ���ڱ� ����
			    //  1 2 5 5 4 6 3 4 8 9  ��ǰ�ڱ��±���arr[2] lt=2   �Ƚ�Ԫ��i=4 ������֮��
				//  1 2 4 5 5 6 3 4 8 9 ����֮�� �ڱ�λ����3 ���ϵ��ڱ� �� arr[4]�� λ�ã����µ��ڱ� ֮ǰ��arr[3]
			
			if(compare(arr[i],v)<0){  
				exch(arr,lt++,i++);
			}else if(compare(arr[i],v)>0){
				//����Ƚ�Ԫ�ر��ڱ���Ļ��� ����gt ��ά��һȺ���ڱ����Ԫ�أ���gt����λ�ã���gt�±�����һ��
				// 1 2 5 5 6 7 47 8 3   ���赱ǰ�ڱ���5 lt=2 arr[2]=5, ��ǰ�Ƚ�Ԫ�� arr[4]=6, ��ǰgt Ϊhi
				// 1 2 5 5 3 7 47 8 6  <--����֮��Ľ��  gt -- ������gt�ʹ�ĩλ�±� arr[8]  ���7��
				
				exch(arr,gt--,i);
			}else{
				i++;
			}
		}
		sortRepeatArr(arr,lo,lt-1);
		sortRepeatArr(arr,gt+1,hi);
		
	}
	
}

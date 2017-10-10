package orde;

public class MaxMQ extends Example{
	// ��һ��Ԫ��Ϊnull  �������ּ���
	MaxMQ(){
		list.add(null);
	}
	public void swim(int index){
		while(index>1&&less(list.get(index/2),list.get(index))){
				exch(index/2,index);
			index=index/2;
		}
	}
	
	//�ݹ����������
	//1)������ӽڵ�Ļ����ͼ����Ƚϣ�������1���ӽڵ㣬Ҳ������2���ӽڵ�
	//2)�����2���ӽڵ��ҵڶ����ӽڵ����Ļ�������ӽڵ���±��Ҫ++ ��Ҳ����ȡ�ڶ����ڵ�
	//3)�ж� ���ڵ� �������ӽڵ�Ĵ�С
	public void sink(int index){
		//������ӽڵ�Ļ����ͼ����Ƚϣ�������1���ӽڵ㣬Ҳ������2���ӽڵ�
		while(2*index<=size()){
			int childmax=2*index;
			//�����2���ӽڵ��ҵڶ����ӽڵ����Ļ�������ӽڵ���±��Ҫ++ ��Ҳ����ȡ�ڶ����ڵ�
			if(childmax+1<=size()&&less(list.get(childmax),list.get(childmax+1))){
				childmax++;
			}
			
			if(less(list.get(childmax),list.get(index))) break;
			exch(childmax,index);
			index=childmax;
		}
	}
	
	//size ָ����N 
	public void sink(int index,int size){
		//������ӽڵ�Ļ����ͼ����Ƚϣ�������1���ӽڵ㣬Ҳ������2���ӽڵ�
		while(2*index<=size){
			int childmax=2*index;
			//�����2���ӽڵ��ҵڶ����ӽڵ����Ļ�������ӽڵ���±��Ҫ++ ��Ҳ����ȡ�ڶ����ڵ�
			if(childmax+1<=size&&less(list.get(childmax),list.get(childmax+1))){
				childmax++;
			}
			
			if(less(list.get(childmax),list.get(index))) break;
			exch(childmax,index);
			index=childmax;
		}
	}
	
	public void insert(int value){
		list.add(value);
		swim(size());
	}
	//��ȡ���Ԫ�ز����أ�ĩβԪ����λ��sink
	public int delMax(){
		int result=list.get(1);
		//ĩβԪ����λ��sink
		list.set(1, list.get(size()));
		sink(1);
		//list��С
		list.remove(size());
		
		return result;
	}
	
}

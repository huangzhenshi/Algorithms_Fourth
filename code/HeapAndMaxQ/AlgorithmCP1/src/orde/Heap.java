package orde;

import java.util.List;

public class Heap extends MaxMQ{
	
	
	//��ͬ�� MaxMQ����֪һ������Ķѣ���������� ��������
	public void sort(List<Integer> list){
		int N=list.size()-1;
		//�Ȱ����鹹���ɶѽṹ
		for(int k=N/2;k>=1;k--){
			sink(k,N);
		}
		int copySize=N;
		//��Ҫ��д ������չ sink ������Ҫ�� sink �Ǹ��� size��С�����³�
		//����ݼ���Ҫ�� copySize������ΪҪѭ��N �Σ����ֱ����N--�Ļ��� kÿ����һ�� ��N�ͼ���1�Σ�ֻ������һ�������������
		for(int k=1;k<N;k++){
			exch(1,copySize);
			sink(1,--copySize);
		}
	}
}

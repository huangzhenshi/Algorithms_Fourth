package unionFind;

public class UF {
	//����ID���Դ�����Ϊ����)
	private int[] id;
	//��������
	private int count;
	
	
	public UF(int N){
		count=N;
		id=new int[N];
		for(int i=0;i<N;i++){
			id[i]=i;
		}
	}
	
	public int count(){
		return count;
	}
	public boolean connected(int p,int q){
		return find(p)==find(q);
	}
	
	public int find(int p){
		return id[p];
	}
	
	//�� p q ֮�䴴��һ������
	public void union(int p,int q){
		
	}
	
	
}

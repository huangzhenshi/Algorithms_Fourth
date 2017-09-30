package unionFind;

public class UF {
	//分量ID（以触点作为索引)
	private int[] id;
	//分量数量
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
	
	//在 p q 之间创建一个链接
	public void union(int p,int q){
		
	}
	
	
}

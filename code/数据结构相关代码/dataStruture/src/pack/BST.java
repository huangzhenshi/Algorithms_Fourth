package pack;

public class BST {
	private Node root;

	class Node{
		private char key;
		private int value;
		private Node left,right;
		//N ��ʾ�ýڵ��size�����������������е��±�λ��
		private int N;
		public Node(char key,int value,int N){
			this.key=key;
			this.value=value;
			this.N=N;
		}
	}
	
	public int size(){
		return size(root);
	}
	
	public int size(Node node){
		if(node==null) return 0;
		return node.N;
	}
	
	public int get(char key){
		return 0;
	}
	
	public Integer get(Node x,char key){
		if(x==null) return null;
		if(key<x.key){
			return get(x.left,key);
		}else if(key>x.key){
			return get(x.right,key);
		}
		return x.value;
	}
	public void put(char key,int value){
		root=put(root,key,value);
	}
	
	//ÿ��put����������ĩ�ҽڵ�������һ���ڵ�
	//��ס �ݹ����returnʱ������������򣬸��������� size+1������
	public Node put(Node x,char key,int value){
		//�����ڵ�Ϊnullʱ����� �÷�������ʼ�����ڵ�
		//��put����ĩ�˵�ʱ��Ҳ����ø÷�����ʹ���������
		if(x==null) return new Node(key,value,1);
		if(key>x.key){
			x.right=put(x.right,key,value);
		}else if(key<x.key){
			x.left=put(x.left,key,value);
		}else{
			x.value=value;
		}
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
	
	//Page 261
	
	public void deleteMin(){
		root=deleteMin(root);
	}
	
	//return ��Ԫ�����µ�rootԪ�ذ��������Ƿ���Ҫɾ����Ԫ��
	public Node deleteMin(Node x){
		//��xΪrootԪ�أ��������Ϊ�յ�ʱ��Ż��������ķ���
		//���ߵ��ݹ鵽leftΪ�յ�ʱ�򣬰������������
			//һ�����Լ����Ǿ�ͷ�ˣ��ͻ᷵��null �������left������0 x=null��������������-1��ͬʱɾ���˸�ĩλ�ڵ�
			//һ������ڵ�Ϊ�գ��ҽڵ㲻Ϊ�գ��ұ�����ȡ�� x= x.right�����������ݹ��Ե�-1
		if(x.left==null) return x.right;
		x.left=deleteMin(x.left);
		//����Ĵ����� x.left ������Ϊ�ӳ��� return ������������ĵݹ��Ե� resize
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
	
	
	
	
}

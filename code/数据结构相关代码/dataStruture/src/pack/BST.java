package pack;

public class BST {
	private Node root;

	class Node{
		private char key;
		private int value;
		private Node left,right;
		//N 表示该节点的size，不是在有序数组中的下标位置
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
	
	//每次put都是在树的末梢节点上新增一个节点
	//记住 递归调用return时不会结束父程序，父程序会进行 size+1操作的
	public Node put(Node x,char key,int value){
		//当根节点为null时会调用 该方法，初始化根节点
		//当put到树末端的时候也会调用该方法，使其挂在树上
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
	
	//return 的元素是新的root元素啊，并不是返回要删除的元素
	public Node deleteMin(Node x){
		//当x为root元素，而且左边为空的时候才会调用下面的方法
		//或者当递归到left为空的时候，包括两种情况：
			//一种是自己就是尽头了，就会返回null 到上面的left，就是0 x=null，会让树的数量-1，同时删除了该末位节点
			//一种是左节点为空，右节点不为空，且被返回取代 x= x.right，会让数量递归性的-1
		if(x.left==null) return x.right;
		x.left=deleteMin(x.left);
		//上面的代码是 x.left 不会因为子程序 return 而不进行下面的递归性的 resize
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
	
	
	
	
}

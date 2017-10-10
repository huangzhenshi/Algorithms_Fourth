package orde;

public class MaxMQ extends Example{
	// 第一个元素为null  方便数字计算
	MaxMQ(){
		list.add(null);
	}
	public void swim(int index){
		while(index>1&&less(list.get(index/2),list.get(index))){
				exch(index/2,index);
			index=index/2;
		}
	}
	
	//递归的三个条件
	//1)如果有子节点的话，就继续比较，可以是1个子节点，也可以是2个子节点
	//2)如果有2个子节点且第二个子节点更大的话，最大子节点的下标就要++ ，也就是取第二个节点
	//3)判断 父节点 和最大的子节点的大小
	public void sink(int index){
		//如果有子节点的话，就继续比较，可以是1个子节点，也可以是2个子节点
		while(2*index<=size()){
			int childmax=2*index;
			//如果有2个子节点且第二个子节点更大的话，最大子节点的下标就要++ ，也就是取第二个节点
			if(childmax+1<=size()&&less(list.get(childmax),list.get(childmax+1))){
				childmax++;
			}
			
			if(less(list.get(childmax),list.get(index))) break;
			exch(childmax,index);
			index=childmax;
		}
	}
	
	//size 指的是N 
	public void sink(int index,int size){
		//如果有子节点的话，就继续比较，可以是1个子节点，也可以是2个子节点
		while(2*index<=size){
			int childmax=2*index;
			//如果有2个子节点且第二个子节点更大的话，最大子节点的下标就要++ ，也就是取第二个节点
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
	//获取最大元素并返回，末尾元素上位后sink
	public int delMax(){
		int result=list.get(1);
		//末尾元素上位后sink
		list.set(1, list.get(size()));
		sink(1);
		//list变小
		list.remove(size());
		
		return result;
	}
	
}

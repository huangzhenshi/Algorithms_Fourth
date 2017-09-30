package capter1DataStruture;

import java.util.Iterator;

// 超级背包实现，add的时候根据栈原理，链表头部追加
// 新增的时候添加了一个备份处理，循环结束的时候，链表重新指向 备份的初始链表，可以多次循环
public class Bag<E> {
	private  Node core=new Node();
	private  Node nodeBackup;
	private int number;
	
	public int size(){
		return number;
	}	
	//每次都往 链条的头部追加，老的链条自动到 next里面，适用于 栈模型
	public void add(E e){
		if(core.target==null){
			core.target=e;
		}else{
			Node oldLink=core;
			//开辟一个新的内存地址，老的内存地址 仍然有效，被oldLink维护
			core=new Node();
			core.target=e;
			core.next=oldLink;
		}
		nodeBackup=core;
		number++;
	}
	
	public Boolean isEmpty(){
		if(number==0)
			return true;
		return false;
	}
	
	public Iterator<E> iterator(){
		return new LinkIterator<E>();
	}
	private class LinkIterator<E> implements Iterator<E>{
		@Override
		public boolean hasNext() {
			if(core!=null){
				return true;
			}else{
				core=nodeBackup;
				return false;
			}
				
			
		}
		@Override
		public E next() {
			Node oldLink=core;
			core=new Node();
			core=oldLink.next;
			return (E) oldLink.target;
		}
		@Override
		public void remove() {
			
		}
	}
	
	
}

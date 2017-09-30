package capter1DataStruture;

import java.util.Iterator;


public class Queue<E>{
		private  Node<E> core=new Node<E>();
		private  Node nodeBackup;
		private int number=0;
		
		public int size(){
			return number;
		}	
		//每次都往 链条的头部追加，老的链条自动到 next里面
		public void push(E e){
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
		
		//pop的时候必须从，末位开始取，才符合 先进先出的原则，需要的操作，找到该元素，并新建一个节点，该节点 获取到末位元素的target，
		//然后设置这个链表的该节点为null
		public E pop(){
			if(core.target!=null){
				Node<E> nextNode=core.next;
				Node<E> parentNode=core;
				while(nextNode.next!=null){
					parentNode=nextNode;
					nextNode=nextNode.next;
				}
				E element=(E) nextNode.target;
				parentNode.next=null;
				number--;
				nodeBackup=core;
				return element;
			}
			return null;
			
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
				
				Node<E> nextNode=core.next;
				Node<E> parentNode=(Node<E>) core;
				
				if(nextNode==null){
					E element=parentNode.target;
					core=null;
					return element;
				}else{
					while(nextNode.next!=null){
						parentNode=nextNode;
						nextNode=nextNode.next;
					}
					parentNode.next=null;
				}
				return (E) nextNode.target;
			}
			@Override
			public void remove() {
				
			}
		}
	}
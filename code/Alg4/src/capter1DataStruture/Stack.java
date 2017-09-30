package capter1DataStruture;

import java.util.Iterator;


public class Stack<E> {
	private  Node<E> core=new Node<E>();
	private  Node nodeBackup;
	private int number=0;
	
	public int size(){
		return number;
	}	
	//ÿ�ζ��� ������ͷ��׷�ӣ��ϵ������Զ��� next���棬������ ջģ��
	public void push(E e){
		if(core.target==null){
			core.target=e;
		}else{
			Node oldLink=core;
			//����һ���µ��ڴ��ַ���ϵ��ڴ��ַ ��Ȼ��Ч����oldLinkά��
			core=new Node();
			core.target=e;
			core.next=oldLink;
		}
		nodeBackup=core;
		number++;
	}
	
	public E pop(){
		if(core.target!=null){
			E element=(E) core.target;
			Node oldLink=core;
			core=new Node();
			
			core=oldLink.next;
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

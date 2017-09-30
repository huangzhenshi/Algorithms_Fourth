package capter1DataStruture;

import java.util.Iterator;


public class Queue<E>{
		private  Node<E> core=new Node<E>();
		private  Node nodeBackup;
		private int number=0;
		
		public int size(){
			return number;
		}	
		//ÿ�ζ��� ������ͷ��׷�ӣ��ϵ������Զ��� next����
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
		
		//pop��ʱ�����ӣ�ĩλ��ʼȡ���ŷ��� �Ƚ��ȳ���ԭ����Ҫ�Ĳ������ҵ���Ԫ�أ����½�һ���ڵ㣬�ýڵ� ��ȡ��ĩλԪ�ص�target��
		//Ȼ�������������ĸýڵ�Ϊnull
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
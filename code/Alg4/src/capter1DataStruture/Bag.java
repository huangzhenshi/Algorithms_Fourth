package capter1DataStruture;

import java.util.Iterator;

// ��������ʵ�֣�add��ʱ�����ջԭ������ͷ��׷��
// ������ʱ�������һ�����ݴ���ѭ��������ʱ����������ָ�� ���ݵĳ�ʼ�������Զ��ѭ��
public class Bag<E> {
	private  Node core=new Node();
	private  Node nodeBackup;
	private int number;
	
	public int size(){
		return number;
	}	
	//ÿ�ζ��� ������ͷ��׷�ӣ��ϵ������Զ��� next���棬������ ջģ��
	public void add(E e){
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

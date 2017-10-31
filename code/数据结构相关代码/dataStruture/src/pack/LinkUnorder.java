package pack;

public class LinkUnorder {
	public int compare=0;
	public  Node first;
	public int size=0;
	public  void insert(Node node){
		for(Node x=first;x!=null;x=x.next){
			if(node.key==x.key){
				x.value=node.value;
				return;
			}
		}
		Node old=first;
		first=node;
		first.next=old;
		size++;
	}
	
	
	
}


public class HardJoe {

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
	
	System.out.println(linkedmethod(n));
	
  }
	
	public static int linkedmethod(int n){
		switch(n){
			case 1: return 1;
			case 2: return 1;
			case 3: return 3;
		}
		//case even: go 1-2-skip
		//case odd: go 2-skip-1-2
		boolean a = false, b = false;
		if(n%2 == 1){
			a = true;
		}
		LinkedList soldiers = new LinkedList(n);
		while(soldiers.size() != 1){
			if(!a && !b){ //case 0
				soldiers.removeNext();
				a = !a;
			}else if(a && !b){ //case 1
				soldiers.removeNext();
				b = !b;
			}else{ //case 2
				soldiers.skip();
				a = false;
				b = false;
			}
		}
		return soldiers.getCurrent().getValue();
	}
	

}

//circularly linked list
class LinkedList{
	private Node current;
	private int size;
	
	
	//precondition: n>=1
	public LinkedList(int n){
		Node head = new Node(1);
		Node prev = new Node(n, head);
		for(int i=n-1; i>1; i--){
			current = new Node(i, prev);
			prev = current;
		}
		head.setNext(current);
		size = n;
		initCurrent();
	}
	
	public Node getCurrent(){
		return current;
	}
	
	public int size(){
		return size;
	}
	
	public void initCurrent(){
		for(int x = size/2 - 2;x>0; x--){
			current = current.getNext();
		}
	}
	
	//METHODS
	
	//removes next in line
	public void removeNext(){
		current.setNext(current.getNext().getNext());
		size--;
	}
	
	//increments current position
	public void skip(){
		current = current.getNext();	
	}
	
	
}
/*
class LinkedList{
	private Node head;
	//private Node tail;
	//don't need a tail; just size
	private Node current;
	private int size;
	
	
	//precondition: n>=1
	public LinkedList(int n){
		Node prev = new Node(n);
		for(int i=n-1; i>0; i--){
			current = new Node(i, prev);
		}
		head = current;
		size = n;
		initCurrent();
	}
	
	public Node getHead(){
		return head;
	}
	
	public Node getCurrent(){
		return current;
	}
	
	public int size(){
		return size;
	}
	
	public void initCurrent(){
		for(int x = size/2 - 1;x>0; x--){
			current = current.getNext();
		}
	}
	
	//METHODS
	
	//removes next in line
	public void removeNext(){
		System.out.println(current.getValue());
		if(current.getNext() == null){
			head = head.getNext();
		}else{
			current.setNext(current.getNext().getNext());
		}
		size--;
	}
	
	//increments current position
	public void skip(){
		if(current.getNext() == null){
			current = head;
		}else{
			current = current.getNext();
		}
	}
	
	
}*/

class Node{
	
	private int value;
	private Node next;
	
	public Node(int v){
		value = v;
		next = null;
	}
	
	public Node(int v, Node n){
		value = v;
		next = n;
	}
	
	public int getValue(){
		return value;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setNext(Node n){
		next = n;
	}
}



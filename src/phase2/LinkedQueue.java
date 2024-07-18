package phase2;



public class LinkedQueue <T extends Comparable<T>> {

	private SLinkedList<T> list;

	public LinkedQueue() {

		list=new SLinkedList<>();
	}
	public boolean isEmpty(){

		return (list.getHead()==null) && (list.getTail()==null);
	}

	public void clear(){

		list.setHead(null);
		list.setTail(null);
	}

	public void enqueue(T data){

		SNode<T> newNode = new SNode<T>(data);

		if(isEmpty())

			list.setHead(newNode);

		else

			list.getTail().setNext(newNode);


		list.setTail(newNode);
	}

	public T getFront(){

		if(!isEmpty())

			return list.getHead().getData();

		return null;
	}

	public T dequeue(){

		T front = getFront();

		if(!isEmpty())

			list.setHead(list.getHead().getNext());

		if(list.getHead()==null)

			list.setTail(null);

		return front;
	}

	public void traverse() {

		SNode<T> curr=list.getHead();
		System.out.print("Head --> ");
		while(curr!=null) {

			System.out.print(curr.getData()+" --> ");
			curr=curr.getNext();
		}
		System.out.print(" Tail\n");
	}

}

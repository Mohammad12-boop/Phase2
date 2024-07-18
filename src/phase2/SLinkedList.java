package phase2;

public class SLinkedList<T extends Comparable<T>> {

	private SNode<T> head;
	private SNode<T> tail;

	public SLinkedList() {

		this.head=null;
		this.tail=null;
	}

	public SNode<T> getHead() {
		return head;
	}

	public void setHead(SNode<T> head) {
		this.head = head;
	}

	public SNode<T> getTail() {
		return tail;
	}

	public void setTail(SNode<T> tail) {
		this.tail = tail;
	}

	public void insert(T data) {

		SNode<T> newNode=new SNode<>(data);

		if (head==null) {  // case 0

			head=newNode;
			tail=newNode;
		}else {

			if (find(data)==null) {

				SNode<T> prev=null;
				SNode<T>  curr=head;
				for( ; curr!=null && curr.getData().compareTo(data)<0 ;
						prev=curr, curr=curr.getNext());

				if (prev==null) {  // case 1 : insert first

					newNode.setNext(head);
					head=newNode;
				}else if (curr==null) {  // case 3 : insert last

					prev.setNext(newNode);
					tail=newNode;
				}else {  // case 2 : insert between

					newNode.setNext(curr);
					prev.setNext(newNode);
				}

				}else {

					System.out.println("this node is already added !\n");
				}
		}
	}

	public SNode<T> find(T data) {

		if (head!=null) {

			SNode<T> curr=head;
			while(curr!=null && curr.getData().compareTo(data)<=0) {

				if (curr.getData().equals(data)==true) {

					return curr;
				}
				curr=curr.getNext();
			}
		}
		return null;
	}

	public SNode<T> delete(T data){

		if (find(data)!=null) {

			if (head!=null) {

				SNode<T> prev=null;
				SNode<T>curr=head;
				for ( ; curr!=null && curr.getData().compareTo(data)<0 ;
						prev=curr, curr=curr.getNext());

				if (curr!=null && curr.getData().compareTo(data)==0) {

					if (prev==null) {  // case 1 : delete first item

						head=curr.getNext();
					}else if(curr.getNext()==null) { // case 3 : delete last item

						prev.setNext(null);
						tail=prev;
					}else { // case 2 : delete between

						prev.setNext(curr.getNext());
					}
					return curr;
				}
			}

		}else {

			System.out.println("this node not found to delete !\n");
		}

		return null;
	}

	public void traverse() {

		SNode<T> curr=head;
		System.out.print("Head --> ");
		while(curr!=null) {

			System.out.print(curr.getData()+" --> ");
			curr=curr.getNext();
		}
		System.out.print(" Tail\n");
	}

	public int length() {

		return length(head);
	}

	private int length(SNode<T> node) {

		if (node == null) {

			return 0;
		}

		return 1 + length(node.getNext());
	}

	public String toString() {

		String res = "Head--> ";
		SNode<T> curr = head;
		while (curr != null) {
			res += curr+"--> ";
			curr = curr.getNext();
		}
		return res + "Tail";
	}

//	public void reverseI() {
//
//		SNode <T> curr=head;
//		SNode<T> prev=null;
//		SNode<T> nextNode=curr.getNext();
//		while (nextNode!=null ) { //Or curr!=null
//
//			nextNode=curr.getNext();
//			curr.setNext(prev);
//			prev=curr;
//			curr=nextNode;
//		}
//		head=prev;
//	}
//
//	public void reverseR() {
//
//		head=reverseR(head);
//	}
//
//	private SNode<T> reverseR(SNode<T> nextNode) {
//
//		if (nextNode ==null || nextNode.getNext()==null) {
//
//			return nextNode;
//		}
//
//		SNode<T> reversedList=reverseR(nextNode.getNext());
//		nextNode.getNext().setNext(nextNode);
//		nextNode.setNext(null);
//		return reversedList;
//
//	}
}

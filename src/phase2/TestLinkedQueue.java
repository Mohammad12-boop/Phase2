package phase2;

public class TestLinkedQueue {

	public static void main(String[] args) {

		LinkedQueue <Integer> lQueue=new LinkedQueue<>();

		lQueue.enqueue(55);
		lQueue.enqueue(65);
		lQueue.enqueue(45);
		lQueue.enqueue(75);
		lQueue.enqueue(99);

		lQueue.traverse();

		System.out.println("\n");

		lQueue.dequeue();
		lQueue.traverse();

		System.out.println("\n");
		System.out.println(lQueue.getFront());

		System.out.println("\n");

		lQueue.clear();
		lQueue.traverse();
	}

}

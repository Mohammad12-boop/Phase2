package phase2;




public class StackQueue <T extends Comparable<T>> {

	private LinkedQueue<T> q1;
	private LinkedQueue<T> q2;

	public StackQueue() {

		q1=new LinkedQueue<>();
		q2=new LinkedQueue<>();
	}

	public void push(T date) {

		q2.enqueue(date);

		while (!q1.isEmpty()) {

			q2.enqueue(q1.getFront());
			q1.dequeue();
		}

		while (!q2.isEmpty()) {

			q1.enqueue(q2.getFront());
			q2.dequeue();
		}

	}

	public T peek(){

		return q1.getFront();
	}

	public T pop() {

		return q1.dequeue();
	}

	public boolean isEmpty() {

		return q1.isEmpty();
	}

	public void clear() {

		q1.clear();
	}

	public void print() {

		while (!q1.isEmpty()) {

			System.out.print("["+q1.getFront()+"]"+"  ");
			q2.enqueue(q1.getFront());
			q1.dequeue();
		}

		while (!q2.isEmpty()) {

			q1.enqueue(q2.getFront());
			q2.dequeue();
		}

	}
}

package phase2;



public class BSTree<T extends Comparable<T>> {

	private TNode<T>root;

	public TNode<T> getRoot() {
		return root;
	}

	public void setRoot(TNode<T> root) {
		this.root = root;
	}

	public void insert(T data) {

		if (find(data)==null) {

			if (isEmpty())

				root = new TNode<>(data);

			else

				insert(data, root);
		}else {

			System.out.println("This node is already exist !\n");
		}
	}

	private void insert(T data, TNode<T> node) {

		if (data.compareTo((T) node.getData()) >= 0) { // insert into right subtree

			if (!node.hasRight())

				node.setRight(new TNode<>(data));

			else

				insert(data, node.getRight());

		} else { // insert into left subtree

			if (!node.hasLeft())

				node.setLeft(new TNode<>(data));

			else

				insert(data, node.getLeft());

		}

	}

	public TNode<T> delete(T data) {

		TNode<T> current = root;
		TNode<T> parent = root;
		boolean isLeftChild = false;

		if (isEmpty())

			return null; // tree is empty

		while (current != null && !current.getData().equals(data)) {

			parent = current;

			if (data.compareTo((T)current.getData()) < 0) {

				current = current.getLeft();

				isLeftChild = true;

			} else {

				current = current.getRight();

				isLeftChild = false;

			}

		}

		if (current == null)

			return null; // case 0: node to be deleted not found

		// case 1: node is a leaf
		if (!current.hasLeft() && !current.hasRight()) {

			if (current == root) // tree has one node

				root = null;

			else {

				if (isLeftChild) parent.setLeft(null);

				else parent.setRight(null);

			}
		 }

		// Case 2 broken down further into 2 separate cases
		else if (current.hasLeft() && !current.hasRight()) { // current has left child only

			if (current == root) {

				root = current.getLeft();

			} else if (isLeftChild) {

				parent.setLeft(current.getLeft());

			} else {

				parent.setRight(current.getLeft());

			}

		} else if (current.hasRight() && !current.hasLeft()) { // current has right child only

			if (current == root) {

				root = current.getRight();

			} else if (isLeftChild) {

				parent.setLeft(current.getRight());

			} else {

				parent.setRight(current.getRight());

			}

		}

		// case 3: node to be deleted has 2 children
		else {

			TNode<T> successor = getSuccessor(current);
			System.out.println(current);

			if (current == root)

				root = successor;

			else if (isLeftChild) {

				parent.setLeft(successor);

			} else {

				parent.setRight(successor);

			}

			successor.setLeft(current.getLeft());

		}

		return current;

	}

	private TNode<T> getSuccessor(TNode<T> node) {

		TNode<T> parentOfSuccessor = node;
		TNode<T> successor = node;
		TNode<T> current = node.getRight();

		while (current != null) {

			parentOfSuccessor = successor;
			successor = current;
			current = current.getLeft();

		}

		if (successor != node.getRight()) { // fix successor connections

			parentOfSuccessor.setLeft(successor.getRight());
			successor.setRight(node.getRight());

		}

		return successor;

	}

	public int size() {

		return size(root);
	}

	private int size(TNode<T> node) {

		if (node==null) {

			return 0;
		}

		return 1 + size(node.getLeft()) + size(node.getRight());

//		if (node.isLeaf()) {
//
//			return 1;
//		}




//		if (node.hasLeft()) {
//
//			return 1+ size(node.getLeft());
//		}
//
//		if (node.hasRight()) {
//
//			return 1+ size(node.getRight());
//		}
//
//		return 0;

	}

	public int height() {

		return height(root);

	}

	private int height(TNode<T> node) {

		if (node == null)

			return 0;

		if (node.isLeaf())

			return 1;

		int left = 0;
		int right = 0;

		if (node.hasLeft())

			left = height(node.getLeft());

		if (node.hasRight())

			right = height(node.getRight());

		return (left > right) ? (left + 1) : (right + 1);
	}


	public TNode<T> largest() {

		return largest(root);

	}

	private TNode<T> largest(TNode<T> node) {

		if(node!= null){

			if(!node.hasRight())

				return (node);

			return largest(node.getRight());

		}

		return null;
	}

	public TNode<T> smallest() {

		return smallest(root);

	}

	private TNode<T> smallest(TNode<T> node) {

		if(node!= null){

			if(!node.hasLeft())

				return (node);

			return smallest(node.getLeft());

		}

		return null;
	}

	public TNode<T> find(T data) {

		return find(root, data);

	}

	private TNode<T> find(TNode<T> node, T data) {

		if (node!= null) {

			int comp = node.getData().compareTo(data);

			if (comp == 0)

				return node;

			else if (comp > 0 && node.hasLeft())

				return find(node.getLeft(), data);

			else /*if (comp < 0 && node.hasRight()) */

				return find(node.getRight(), data);

		}

		return null;
	}

	public boolean isEmpty() {

		return root==null;
	}
	public void traverseInOrder() {

		traverseInOrder(root);

	}

	private void traverseInOrder(TNode<T> node) {

		if (node != null) {

			if (node.getLeft() != null)

				traverseInOrder(node.getLeft());

			System.out.print(node + " ");

			if (node.getRight() != null)

				traverseInOrder(node.getRight());

		}
	}

	public void traversePreOrder() {

		traversePreOrder(root);
	}

	private void traversePreOrder(TNode<T> curr) {

		if (curr == null) return;
		System.out.print(curr + " ");
		traversePreOrder(curr.getLeft());
		traversePreOrder(curr.getRight());
	}

	public void traversePostOrder() {

		traversePostOrder(root);
	}

	private void traversePostOrder(TNode<T> curr) {

		if (curr == null) return;
		traversePreOrder(curr.getLeft());
		traversePreOrder(curr.getRight());
		System.out.print(curr + " ");
	}

	public void traverseLevelOrder() {

		if (root == null) return;

		LinkedQueue<TNode<T>> queue = new LinkedQueue<>();

		queue.enqueue(root);

		while (!queue.isEmpty()) {

			TNode<T> curr = queue.dequeue();
			System.out.print(curr + " ");
			if (curr.hasLeft()) queue.enqueue(curr.getLeft());
			if (curr.hasRight()) queue.enqueue(curr.getRight());
		}
	}

}

class BSTNode<T> {
	public String key;
	public T data;
	public BSTNode<T> left, right;

	public BSTNode(String key, T data) {
		this.key = key;
		this.data = data;
		left = right = null;
	}

	// for debugging
	@Override
	public String toString() {
		return toString("");
	}

	private String toString(String ident) {
		return ident + key + " = " + data.toString() + ((left == null) ? "" : "\n" + left.toString(ident + '\t'))
				+ ((right == null) ? "" : "\n" + right.toString(ident + '\t'));
	}

}

public class BST<T> {

	private BSTNode<T> root, current;

	public BST() {
		current = root = null;
	}

	public void clear() {
		current = root = null;
	}

	public boolean empty() {
		return root == null;
	}

	public boolean full() {
		return false;
	}

	public T retrieve() {
		return current.data;
	}

	public boolean findKey(String k) {

		BSTNode<T> p = root;
		while (p != null) {
			current = p;
			if (k.equals(p.key)) {
				return true;
			} else if (k.compareTo(p.key) < 0) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		return false;
	}
	
	public int NBComp(String k) {

		int counter=0;
		BSTNode<T> p = root;
		while (p != null) {
			current = p;
			if (k.equals(p.key)) {
				counter++;
				return counter;
			} else if (k.compareTo(p.key) < 0) {
				counter++;
			} else {
				counter++;
			}
		}
		return -1;
	}

	public boolean insert(String k, T val) {
		if (root == null) {
			current = root = new BSTNode<T>(k, val);
			return true;
		}

		BSTNode<T> p = current;
		if (findKey(k)) {
			current = p;
			return false;
		}

		BSTNode<T> tmp = new BSTNode<T>(k, val);
		if (k.compareTo(current.key) < 0) {
			current.left = tmp;
		} else {
			current.right = tmp;
		}
		current = tmp;
		return true;
	}

	public boolean removeKey(String k) {

		// Search for k
		String k1 = k;
		BSTNode<T> p = root;
		BSTNode<T> q = null; // Parent of p
		while (p != null) {

			if (k1.compareTo(p.key) < 0) {
				q = p;
				p = p.left;
			} else if (k1.compareTo(p.key) > 0) {
				q = p;
				p = p.right;
			} else { // Found the key

				// Check the three cases
				if ((p.left != null) && (p.right != null)) { // Case 3: two
																// children

					// Search for the min in the right subtree
					BSTNode<T> min = p.right;
					q = p;
					while (min.left != null) {
						q = min;
						min = min.left;
					}
					p.key = min.key;
					p.data = min.data;
					k1 = min.key;
					p = min;
					// Now fall back to either case 1 or 2
				}

				// The subtree rooted at p will change here
				if (p.left != null) { // One child
					p = p.left;
				} else { // One or no children
					p = p.right;
				}

				if (q == null) { // No parent for p, root must change
					root = p;
				} else {
					if (k1.compareTo(q.key) < 0) {
						q.left = p;
					} else {
						q.right = p;
					}
				}
				current = root;
				return true;

			}
		}

		return false; // Not found
	}

	
	public LinkedList<T> getVals() {
		LinkedList<T> temp = new LinkedList<>();
		BSTNode<T> trav = root;
		getVals(temp,trav);
		return temp;
	}

	private void getVals(LinkedList<T> temp,BSTNode<T> trav) {
		if(trav==null)
			return;
		temp.insert(trav.data);
		getVals(temp,trav.left);
		getVals(temp,trav.right);
		
	}
	
	public LinkedList<String> getKeys() {
		LinkedList<String> temp = new LinkedList<>();
		BSTNode<T> trav = root;
		getKeys(temp,trav);
		return temp;
	}

	private void getKeys(LinkedList<String> temp,BSTNode<T> trav) {
		if(trav==null)
			return;
		temp.insert(trav.key);
		getKeys(temp,trav.left);
		getKeys(temp,trav.right);
		}
	
	
	
}
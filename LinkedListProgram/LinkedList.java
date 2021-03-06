package LinkedListProgram;

public class LinkedList<E extends Comparable <E>> {
	
	private ListNode<E> front;
	private int size;

	/**
	 * Creates a linked list of size 0
	 */
	public LinkedList() {
		this.front = null;
		this.size = 0;
	}

	/**
	 * Inserts a node after prior
	 * @param prior
	 * @param newNode
	 * @return prior
	 */
	private ListNode<E> insertNode(ListNode<E> prior, ListNode<E> newNode) {
		
		if (prior == null) {
			prior = newNode;
			return prior;
		}

		if (prior.getNext() == null) {
			prior.setNext(newNode);
			return prior;
		}

		newNode.setNext(prior.getNext());
		prior.setNext(newNode);
		return prior;

	}

	/**
	 * Removes a node after prior
	 * @param prior
	 * @param nextNode
	 * @return prior
	 */
	private ListNode<E> removeNode(ListNode<E> prior, ListNode<E> nextNode) {
		
		prior.setNext(nextNode);
		
		return prior;
	}

	/**
	 * Adds a node from the given data in the correct location
	 * @param data
	 * @return Information about adding the node
	 */
	public String add(E data) {
		return this.add(new ListNode<E>(data, null));
	}

	/**
	 * Adds a node in the correct location
	 * @param newNode
	 * @return Information about adding the node
	 */
	public String add(ListNode<E> newNode) {

		if (this.front == null) {
			this.front = this.insertNode(this.front, newNode);
			return "";
		}

		ListNode<E> prior = this.front;
		ListNode<E> current = this.front;

		if (newNode.compareTo(prior) < 0) {
			this.front = this.insertNode(newNode, front);
			return "";
		}
		else if (prior.getNext() != null && newNode.compareTo(prior) != 0) {
			current = this.front.getNext();
	
			while(current.getNext() != null && newNode.compareTo(current) > 0) {
				current = current.getNext();
				prior = prior.getNext();
			}

			if (current.getNext() == null && newNode.compareTo(current) > 0) {
				prior = prior.getNext();
			}

		}
		else {
			current = prior;
		}

		if (newNode.compareTo(current) == 0) {
			return "Already on List";
		}

		prior = this.insertNode(prior, newNode);
		return "";

	}

	/**
	 * Removes a given node from some data
	 * @param data
	 * @return Information about removing the node
	 */
	public String remove(E data) {
		return this.remove(new ListNode<E>(data, null));
	}
	
	/**
	 * Removes a given node
	 * @param removeNode
	 * @return Information about removing the node
	 */
	public String remove(ListNode<E> removeNode) {

		if (this.front == null) {
			return "Not in list";
		}

		if (this.front.compareTo(removeNode) == 0) {
			this.front = front.getNext();
			return "";
		}
		
		ListNode<E> current = this.front;
		ListNode<E> prior = this.front;

		while (current != null && current.compareTo(removeNode) != 0) {
			prior = current;
			current = prior.getNext();
		}

		if (current == null) {
			return "Not on list";
		}
		else if (current.compareTo(removeNode) == 0) {

			if (current.getNext() == null) {
				prior = removeNode(prior, null);
			}
			else {
				prior = removeNode(prior, prior.getNext().getNext());
			}
			return "";
		}
		else {
			throw new Error("Not found");
		}
	}

	/**
	 * Resets entire list
	 */
	public void reset() {
		this.front = null;
	}


	/**
	 * Reverses the list
	 */
	public void reverseList() {
		reverse(null, front);
	}

	/**
	 * Check the next element in the list then reverse order.
	 * @param prior current element
	 * @param current next element
	 */
	private void reverse(ListNode<E> prior, ListNode<E> current) {

		if (current.getNext() != null) {
			reverse(current, current.getNext());
		}
		else {
			this.front = current;
		}

		current.setNext(prior);

	}


	/**
	 * Returns the formatted list
	 * @return formatted list
	 */
	@Override
  public String toString() {

		if (front == null) {
			return "List is empty";
		}

		String out = "[ ";
		ListNode current = front;
		while (current.getNext() != null) {
			out += current.getData() + ", ";
			current = current.getNext();
		}
		out += current.getData() + " ]";
		return out;
	}

	/**
	 * Returns the first 5 elements in the list formatted
	 * @return First 5 elements formatted
	 */
	public String uiOutput() {

		if (front == null) {
			return "List is empty";
		}

		String out = "[ ";
		ListNode current = front;
		int i = 0;
		while (current.getNext() != null && i < 5) {
			out += current.getData() + ", ";
			current = current.getNext();
			i++;
		}
		if (i >= 5) {
			out += "... ]";
		}
		else {
			out += current.getData() + " ]";
		}
		return out;
	}

}
/*
###################################
##                               ##
##      Linked List Program      ##
##        By William Rice        ##
##                               ##
## ----------------------------- ##
##                               ##
##  Functions -                  ##
##                               ##
##  1.) Output List (out)        ##
##      - Prints list            ##
##                               ##
##  2.) Add to List (add)        ##
##      - Adds Integer to        ##
##        list                   ##
##                               ##
##  3.) Remove From List (rem)   ##
##      - Removes Integer        ##
##        from the list          ##
##                               ##
##  4.) Reset List (reset)       ##
##                               ##
##  5.) Reverse List (reverse)   ##
##                               ##
##  6.) Stop Program (done)      ##
##                               ##
###################################

List is empty
>>> add 10

[ 10 ]
>>> add 20

[ 10, 20 ]
>>> add 1

[ 1, 10, 20 ]
>>> add 5

[ 1, 5, 10, 20 ]
>>> add 15

[ 1, 5, 10, 15, 20 ]
>>> reverse

[ 20, 15, 10, 5, 1 ]
>>> reverse

[ 1, 5, 10, 15, 20 ]
>>> add 100

[ 1, 5, 10, 15, 20, ... ]
>>> add 200

[ 1, 5, 10, 15, 20, ... ]
>>> add -1

[ -1, 1, 5, 10, 15, ... ]
>>> add -4

[ -4, -1, 1, 5, 10, ... ]
>>> out
[ -4, -1, 1, 5, 10, 15, 20, 100, 200 ]

[ -4, -1, 1, 5, 10, ... ]
>>> reverse

[ 200, 100, 20, 15, 10, ... ]
>>> out
[ 200, 100, 20, 15, 10, 5, 1, -1, -4 ]

[ 200, 100, 20, 15, 10, ... ]
>>> done
*/
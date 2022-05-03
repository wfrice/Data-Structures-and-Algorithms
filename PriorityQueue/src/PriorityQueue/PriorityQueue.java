package PriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PriorityQueue<E extends Priority & Order> implements Queue<E> {

	private List<E> list;
	private int highestPriority = 10;
	private int order = 1;

	public PriorityQueue() {
		list = new ArrayList<>();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void enqueue(E element) {
		element.setOrder(order++);
		list.add(element);
		if (element.getPriority() < highestPriority) {
			highestPriority = element.getPriority();
		}
	}

	public E dequeue() throws NoSuchElementException {
		int numPriority = 0;
		int nextPriority = 10;
		E remElement = null;


		for (E element : list) {
			if (element.getPriority() == highestPriority) {
				numPriority ++;
				if (remElement == null) {
					remElement = element;
				}
			}
			if (element.getPriority() > highestPriority && element.getPriority() < nextPriority) {
				nextPriority = element.getPriority();
			}

		}

		if (!(numPriority > 1)) {
			highestPriority = nextPriority;
		}
		
		list.remove(remElement);

		return remElement;
	}

	public E front() throws NoSuchElementException {
		return list.get(0);
	}

}

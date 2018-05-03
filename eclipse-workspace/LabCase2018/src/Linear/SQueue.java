package Linear;


public class SQueue implements IQueue {
	
	private SNode first;
	private SNode last;
	int size;

	public boolean isEmpty() {
		return first == null;
	}
	
	public void enqueue(Integer vertex) {
		SNode node = new SNode(vertex);
		if (isEmpty()) {
			first = node;
		} else {
			last.next = node;
		}
		last = node;
		size++;
	}

	public Integer dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		} 
		
		Integer firstvertex = first.vertex;
		first = first.next;
		if (first == null) {
			last = null;
		}
		size--;
		return firstvertex;
		
	}

	public Integer front() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
			return null;
		}
		return first.vertex;
	}

	@Override
	public String toString() {
		String result = null;
		for (SNode nodeIt = first; nodeIt != null; nodeIt = nodeIt.next) {
			if (result == null) {
				result = "[" + nodeIt.vertex + "]";
			} else {
				result += "," + nodeIt.vertex;
			}
		}
		return result == null ? "empty" : result;
	}

	


	@Override
	public int getSize() {
		return size;
	}
}

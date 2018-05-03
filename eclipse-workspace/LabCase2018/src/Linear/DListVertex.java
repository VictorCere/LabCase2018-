package Linear;


/**
 * A double-linked list class with sentinel nodes
 */

public class DListVertex implements IList {

	DNodeVertex header;
	DNodeVertex trailer;
	String Ciudad;
	int size=0;

	public DListVertex(String Ciudad) {
		header = new DNodeVertex(null,null);
		trailer = new DNodeVertex(null,null);
		header.next = trailer;
		trailer.prev= header;
		this.Ciudad=Ciudad;
	}
	

	
	public void addFirst(int v, float w) {
		DNodeVertex newNode = new DNodeVertex(v,w);
		newNode.next = header.next;
		newNode.prev= header;
		header.next.prev= newNode;
		header.next = newNode;
		size++;
	}

	
	public void addLast(int v, float w) {
		DNodeVertex newNode = new DNodeVertex(v,w);
		newNode.next = trailer;
		newNode.prev= trailer.prev;
		trailer.prev.next = newNode;
		trailer.prev= newNode;
		size++;
	}

	
	public void insertAt(int index, int v, float w) {
		DNodeVertex newNode = new DNodeVertex(v,w);
		int i = 0;
		boolean inserted=false;
		for (DNodeVertex nodeIt = header; nodeIt != trailer && inserted==false; nodeIt = nodeIt.next) {
			if (i == index) {
				newNode.next = nodeIt.next;
				newNode.prev= nodeIt;
				nodeIt.next.prev= newNode;
				nodeIt.next = newNode;
				inserted=true;
				size++;
			}
			++i;
		}
		if (!inserted) System.out.println("DList: Insertion out of bounds");
	}

	

	
	public boolean isEmpty() {
		return (header.next == trailer);
	}

	
	public boolean contains(int vertex) {
		boolean found=false;
		for (DNodeVertex nodeIt = header.next; nodeIt != trailer && found==false; nodeIt = nodeIt.next) {
			if (nodeIt.vertex.equals(vertex)) {
				found=true;
			}
		}
		return found;
	}

	
	public int getIndexOf(int vertex) {
		int index = -1;
		int pos=0;
		for (DNodeVertex nodeIt = header.next; nodeIt != trailer && index==-1; nodeIt = nodeIt.next) {
			if (nodeIt.vertex.equals(vertex)) {
				index=pos;
			} 
			++pos;
			
		}
		return index;
	}

	
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		header.next = header.next.next;
		header.next.prev= header;
		size--;
	}

	
	public void removeLast() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		trailer.prev= trailer.prev.prev;
		trailer.prev.next = trailer;
		size--;

	}

	
	public void removeAll(int vertex) {
		for (DNodeVertex nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			if (nodeIt.vertex.equals(vertex)) {
				nodeIt.prev.next = nodeIt.next;
				nodeIt.next.prev= nodeIt.prev;
				size--;

			}
		}
	}

	
	
	public void removeAt(int index) {
		int i = 0;
		boolean removed=false;
		for (DNodeVertex nodeIt = header.next; nodeIt != trailer && removed==false; nodeIt = nodeIt.next) {
			if (i == index) {
				nodeIt.prev.next = nodeIt.next;
				nodeIt.next.prev= nodeIt.prev;
				removed=true;
				size--;

			}
			++i;
		}
		if (!removed) System.out.println("DList: Deletion out of bounds");
	}

	
	public int getSize() {
		
		return size;
	}

	
	public Integer getFirst() {
		Integer result=null;
		if (isEmpty()) {
			System.out.println("DList: List is empty");
		} else result=header.next.vertex;
		return result;
	}

	public Integer getLast() {
		Integer result=null;

		if (isEmpty()) {
			System.out.println("DList: List is empty");
		} else result=trailer.prev.vertex;
		
		return result;
	}

	
	public DNodeVertex getAt(int index) {
		int i = 0;
		for (DNodeVertex nodeIt = header.next; nodeIt != trailer ; nodeIt = nodeIt.next) {
			if (i == index) {
				return nodeIt;
			}
			++i;
		}
		System.out.println("DList: Get out of bounds");
		return null;
	}

	
	
	public String toString() {
		String result = null;
		for (DNodeVertex nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			if (result == null) {
				result = String.valueOf(nodeIt.vertex)+":"+String.valueOf(nodeIt.weight);
			} else {
				result += "," + String.valueOf(nodeIt.vertex)+":"+String.valueOf(nodeIt.weight);
			}
		}
		return result == null ? "empty" : result;
	}

	

	public static void main(String[] args) {
		// incomplete test
		
	}
}

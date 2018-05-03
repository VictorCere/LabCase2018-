package fase2;

public class DList implements IList {

	DNode header;
	DNode trailer;
	int size=0;

	public DList() {
		header = new DNode(null);
		trailer = new DNode(null);
		header.next = trailer;
		trailer.prev= header;
	}
	

	
	public void addFirst(String elem) {
		DNode newNode = new DNode(elem);
		newNode.next = header.next;
		newNode.prev= header;
		header.next.prev= newNode;
		header.next = newNode;
		size++;
	}

	
	public void addLast(String elem) {
		DNode newNode = new DNode(elem);
		newNode.next = trailer;
		newNode.prev= trailer.prev;
		trailer.prev.next = newNode;
		trailer.prev= newNode;
		size++;
	}

	
	public void insertAt(int index, String elem) {
		DNode newNode = new DNode(elem);
		int i = 0;
		boolean inserted=false;
		for (DNode nodeIt = header; nodeIt != trailer && inserted==false; nodeIt = nodeIt.next) {
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

	
	public boolean contains(String elem) {
		boolean found=false;
		for (DNode nodeIt = header.next; nodeIt != trailer && found==false; nodeIt = nodeIt.next) {
			if (nodeIt.elem.equals(elem)) {
				found=true;
			}
		}
		return found;
	}

	
	public int getIndexOf(String elem) {
		int index = -1;
		int pos=0;
		for (DNode nodeIt = header.next; nodeIt != trailer && index==-1; nodeIt = nodeIt.next) {
			if (nodeIt.elem.equals(elem)) {
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

	
	public void removeAll(String elem) {
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			if (nodeIt.elem.equals(elem)) {
				nodeIt.prev.next = nodeIt.next;
				nodeIt.next.prev= nodeIt.prev;
				size--;

			}
		}
	}

	
	
	public void removeAt(int index) {
		int i = 0;
		boolean removed=false;
		for (DNode nodeIt = header.next; nodeIt != trailer && removed==false; nodeIt = nodeIt.next) {
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

	
	public String getFirst() {
		String result=null;
		if (isEmpty()) {
			System.out.println("DList: List is empty");
		} else result=header.next.elem;
		return result;
	}
	public String getLast() {
		String result=null;
		if (isEmpty()) {
			System.out.println("DList: List is empty");
		} else result=trailer.prev.elem;
		
		return result;
	}

	
	public String getAt(int index) {
		int i = 0;
		String result=null;
		for (DNode nodeIt = header.next; nodeIt != trailer && result==null; nodeIt = nodeIt.next) {
			if (i == index) {
				result=nodeIt.elem;
			}
			++i;
		}
		if (result==null) System.out.println("DList: Get out of bounds");
		return result;
	}

	public String toString() {
		String result = null;
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			if (result == null) {
				result = String.valueOf(nodeIt.elem);
			} else {
				result += "," + String.valueOf(nodeIt.elem);
			}
		}
		return result == null ? "empty" : result;
	}

	public boolean palindromic() {
		if (isEmpty()) {
			System.out.println("List is empty!");
			return true;
		}
		DNode left=header.next;
		DNode right=trailer.prev;
		int i=0;
		int middle = getSize()/2;
		while (left!=right & i<middle) {
			if (!left.elem.equals(right.elem)) return false;
			left=left.next;
			right=right.prev;
			i++;
		}
		return true;
	}

	

}

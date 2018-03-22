
import java.util.Random;


/**
 * A double-linked list class with sentinel nodes
 */
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
	

	
	public void addFirst(Integer elem) {
		long starTime=System.currentTimeMillis();
		DNode newNode = new DNode(elem);
		newNode.next = header.next;
		newNode.prev= header;
		header.next.prev= newNode;
		header.next = newNode;
		size++;
		long endTime=System.currentTimeMillis();
		long total=endTime-starTime;
		System.out.print(total+"\t");
	}

	
	public void addLast(Integer elem) {
		long starTime=System.currentTimeMillis();
		DNode newNode = new DNode(elem);
		newNode.next = trailer;
		newNode.prev= trailer.prev;
		trailer.prev.next = newNode;
		trailer.prev= newNode;
		size++;
		long endTime=System.currentTimeMillis();
		long total=endTime-starTime;
		System.out.print(total+"\t");
	}

	
	public void insertAt(int index, Integer elem) {
		long starTime=System.currentTimeMillis();
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
		long endTime=System.currentTimeMillis();
		long total=endTime-starTime;
		System.out.print(total+"\t");
	}

	

	
	public boolean isEmpty() {
		long starTime=System.currentTimeMillis();
		long endTime=System.currentTimeMillis();
		long total=endTime-starTime;
		System.out.print(total+"\t");
		return (header.next == trailer);
	}

	
	public boolean contains(Integer elem) {
		long starTime=System.currentTimeMillis();
		boolean found=false;
		for (DNode nodeIt = header.next; nodeIt != trailer && found==false; nodeIt = nodeIt.next) {
			if (nodeIt.elem.equals(elem)) {
				found=true;
			}
		}
		long endTime=System.currentTimeMillis();
		long total=endTime-starTime;
		System.out.print(total+"\t");
		return found;
	}

	
	public int getIndexOf(Integer elem) {
		long starTime=System.currentTimeMillis();
		int index = -1;
		int pos=0;
		for (DNode nodeIt = header.next; nodeIt != trailer && index==-1; nodeIt = nodeIt.next) {
			if (nodeIt.elem.equals(elem)) {
				index=pos;
			} 
			++pos;
			
		}
		long endTime=System.currentTimeMillis();
		long total=endTime-starTime;
		System.out.print(total+"\t");
		return index;
	}

	
	public void removeFirst() {
		long starTime=System.currentTimeMillis();
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		header.next = header.next.next;
		header.next.prev= header;
		size--;
		long endTime=System.currentTimeMillis();
		long total=endTime-starTime;
		System.out.print(total+"\t");
	}

	
	public void removeLast() {
		long starTime=System.currentTimeMillis();
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		trailer.prev= trailer.prev.prev;
		trailer.prev.next = trailer;
		size--;
		long endTime=System.currentTimeMillis();
		long total=endTime-starTime;
		System.out.print(total+"\t");
	}

	
	public void removeAll(Integer elem) {
		long starTime=System.currentTimeMillis();
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			if (nodeIt.elem.equals(elem)) {
				nodeIt.prev.next = nodeIt.next;
				nodeIt.next.prev= nodeIt.prev;
				size--;

			}
		}
	}

	
	
	public void removeAt(int index) {
		long starTime=System.currentTimeMillis();
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
		long endTime=System.currentTimeMillis();
		long total=endTime-starTime;
		System.out.print(total+"\t");
	}

	
	public int getSize() {
		long starTime=System.currentTimeMillis();
		long endTime=System.currentTimeMillis();
		long total=endTime-starTime;
		System.out.print(total+"\t");
		return size;
	}

	
	public Integer getFirst() {
		long starTime=System.currentTimeMillis();
		Integer result=null;
		if (isEmpty()) {
			System.out.println("DList: List is empty");
		} else result=header.next.elem;
		long endTime=System.currentTimeMillis();
		long total=endTime-starTime;
		System.out.print(total+"\t");
		return result;
	}

	public Integer getLast() {
		long starTime=System.currentTimeMillis();
		Integer result=null;

		if (isEmpty()) {
			System.out.println("DList: List is empty");
		} else result=trailer.prev.elem;
		long endTime=System.currentTimeMillis();
		long total=endTime-starTime;
		System.out.print(total+"\t");
		
		return result;
	}

	
	public Integer getAt(int index) {
		long starTime=System.currentTimeMillis();
		int i = 0;
		Integer result=null;
		for (DNode nodeIt = header.next; nodeIt != trailer && result==null; nodeIt = nodeIt.next) {
			if (i == index) {
				result=nodeIt.elem;
			}
			++i;
		}
		if (result==null) System.out.println("DList: Get out of bounds");
		long endTime=System.currentTimeMillis();
		long total=endTime-starTime;
		System.out.print(total+"\t");
		return result;
	}

	public String toString() {
		long starTime=System.currentTimeMillis();
		String result = null;
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			if (result == null) {
				result = String.valueOf(nodeIt.elem);
			} else {
				result += "," + String.valueOf(nodeIt.elem);
			}
		}
		long endTime=System.currentTimeMillis();
		long total=endTime-starTime;
		System.out.print(total+"\t");
		return result == null ? "empty" : result;
	}

	public boolean palindromic() {
		long starTime=System.currentTimeMillis();
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
		long endTime=System.currentTimeMillis();
		long total=endTime-starTime;
		System.out.print(total+"\t");
		return true;
	}

	
	
	public static void main(String[] args) {
		// incomplete test
		Random rn=new Random();
		DList list = new DList();
		System.out.println(list.toString());
		System.out.println("isEmpty?" + list.isEmpty());
		for (int i=0; i<100; i++) {
			list.insertAt(i, Integer.valueOf(rn.nextInt(100)));
		}
		list.removeLast();
		list.insertAt(2, 30);
		
		System.out.println("First: " + list.getFirst());
		System.out.println("Last: " + list.getLast());
		list.removeAt(5);
		System.out.println("removed element at position 5"+list.toString());
		
		list=new DList();
		
		

		
	}
}

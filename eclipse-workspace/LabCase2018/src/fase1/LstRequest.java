package fase1;

public class LstRequest implements IList{
		Request header;
		Request trailer;
		int size=0;
	
	public LstRequest() {
		header = new Request(null,null,null);
		trailer = new Request(null,null,null);
		header.next = trailer;
		trailer.prev= header;
	}
	

	public void addFirst(String Origen,String Destino,String idUsuario) {
		Request newRequest = new Request(Origen,Destino,idUsuario);
		newRequest.next = header.next;
		newRequest.prev= header;
		header.next.prev= newRequest;
		header.next = newRequest;
		size++;
	}

	public void addLast(Request request) {
		request.next = trailer;
		request.prev= trailer.prev;
		trailer.prev.next = request;
		trailer.prev= request;
		size++;
		
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

	public void insertAt(int index, String Origen,String Destino,String idUsuario) {
		
		Request newRequest = new Request(Origen,Destino,idUsuario);
		int i = 0;
		boolean inserted=false;
		for (Request nodeIt = header; nodeIt != trailer && inserted==false; nodeIt = nodeIt.next) {
			if (i == index) {
				newRequest.next = nodeIt.next;
				newRequest.prev= nodeIt;
				nodeIt.next.prev= newRequest;
				nodeIt.next = newRequest;
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

	@Override
	public boolean contains(String Origen,String Destino,String idUsuario) {
		boolean found=false;
		for (Request nodeIt = header.next; nodeIt != trailer && found==false; nodeIt = nodeIt.next) {
			if (nodeIt.origin==Origen && nodeIt.destination==Destino && nodeIt.username==idUsuario) {
				found=true;
			}
		}
		return found;
	}
	public int getSize() {
		return size;
	}

	@Override
	public int getIndexOf(String Origen,String Destino,String idUsuario) {
		int index = -1;
		int pos=0;
		for (Request nodeIt = header.next; nodeIt != trailer && index==-1; nodeIt = nodeIt.next) {
			if (nodeIt.origin==Origen && nodeIt.destination==Destino && nodeIt.username==idUsuario) {
				index=pos;
			} 
			++pos;
			
		}
		return index;
	}

	public Request getFirst() {
		Request result=null;
		if (isEmpty()) {
			System.out.println("DList: List is empty");
		} 
		else result=header.next;
		return result;
	}

	public Request getLast() {
		Request result=null;
		if (isEmpty()) {
			System.out.println("DList: List is empty");
		} 
		else result=trailer.prev;
		return result;
	}

	public Request getAt(int index) {
		int i = 0;
		Request result=null;
		for (Request nodeIt = header.next; nodeIt != trailer && result==null; nodeIt = nodeIt.next) {
			if (i == index) {
				result=nodeIt;
			}
			++i;
		}
		if (result==null) System.out.println("DList: Get out of bounds");
		return result;
	}
	
	
	public void removeAll(String Origen,String Destino,String idUsuario) {
		for (Request nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			if (nodeIt.origin==Origen && nodeIt.destination==Destino && nodeIt.username==idUsuario) {
				nodeIt.prev.next = nodeIt.next;
				nodeIt.next.prev= nodeIt.prev;
				size--;

			}
		}
		
	}

	@Override
	public void removeAt(int index) {
		int i = 0;
		boolean removed=false;
		for (Request nodeIt = header.next; nodeIt != trailer && removed==false; nodeIt = nodeIt.next) {
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
	public boolean equals(LstRequest list) {
        if (list==this) return true;
        if (list.getSize()!=this.getSize()) return false;
        for (int i=0; i<this.getSize(); i++) {
              Request r1=this.getAt(i);
              Request r2=list.getAt(i);
              if (!r1.equals(r2)) return false;
        }
        return true;
  }


}


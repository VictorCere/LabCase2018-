package fase1;

public class SharingCar {
	public static LstRequest mergeAlternateRequests(LstRequest lista1,LstRequest lista2) {
		LstRequest newList= new LstRequest();
		Request nodeIt1 = lista1.header;
		Request nodeIt2 = lista2.header;
		int index=0;
		while (nodeIt1 !=lista1.trailer ||nodeIt2 !=lista2.trailer ) {
			if (nodeIt1 !=lista1.trailer) {
				newList.insertAt(index, nodeIt1.origin,nodeIt1.destination,nodeIt1.username);
				nodeIt1=nodeIt1.next;
				}
			if (nodeIt2 !=lista2.trailer) {				
				newList.insertAt(index, nodeIt2.origin,nodeIt2.destination,nodeIt2.username);
				nodeIt2=nodeIt2.next;
			}
		}
		return newList;	
	}
	public static LstRequest sharing(LstRequest lista1,LstRequest lista2) {
		int index=0;
		LstRequest newList= new LstRequest();
		for (Request nodeIt1= lista1.header; nodeIt1 != lista1.trailer; nodeIt1 = nodeIt1.next) {
			for (Request nodeIt2 = lista2.header; nodeIt2 != lista2.trailer; nodeIt2 = nodeIt2.next){
				if (nodeIt1.origin==nodeIt2.origin && nodeIt1.destination==nodeIt2.destination) {
					newList.insertAt(index, nodeIt1.origin,nodeIt1.destination,nodeIt1.username);
					index++;
					newList.insertAt(index, nodeIt1.origin,nodeIt1.destination,nodeIt1.username);
					index++;
				}
				
			}
		}
		return newList;
	}

	
	public static LstRequest sort(LstRequest lista1,int parametro) {
		if (parametro==1) {
		LstRequest newList= new LstRequest();
		int contadorInser=0;
		for (Request nodeIt1= lista1.header.next; nodeIt1 != lista1.trailer; nodeIt1 = nodeIt1.next) {
			for	(Request nodeIt2=newList.header.next;nodeIt2!=newList.trailer;nodeIt2=nodeIt2.next) {
				if (nodeIt1.origin.compareTo(nodeIt2.origin)<0) {
					newList.insertAt(contadorInser, nodeIt1.origin, nodeIt1.destination, nodeIt1.username);
					contadorInser=0;
				}
				contadorInser++;
			}
			
		}
		return newList;
		}
		if (parametro==2) {		
			LstRequest newList= new LstRequest();
			int contadorInser=0;
			for (Request nodeIt1= lista1.header.next; nodeIt1 != lista1.trailer; nodeIt1 = nodeIt1.next) {
				for	(Request nodeIt2=newList.header.next;nodeIt2!=newList.trailer;nodeIt2=nodeIt2.next) {
					if (nodeIt1.destination.compareTo(nodeIt2.destination)<0) {
						newList.insertAt(contadorInser, nodeIt1.origin, nodeIt1.destination, nodeIt1.username);
						contadorInser=0;
					}
					contadorInser++;
				}	
			}
			return newList;
		}
		else {return null;}
	}
	public static LstRequest removeDuplicates(LstRequest lista1) {
		int index=0;
		LstRequest newList= new LstRequest();
		for (Request nodeIt1= lista1.header; nodeIt1 != lista1.trailer; nodeIt1 = nodeIt1.next) {
			for (Request nodeIt2 = lista1.header; nodeIt2 != lista1.trailer; nodeIt2 = nodeIt2.next){
				if (nodeIt1.origin!=nodeIt2.origin && nodeIt1.destination!=nodeIt2.destination && nodeIt1.username!=nodeIt2.username) {
					newList.insertAt(index, nodeIt1.origin,nodeIt1.destination,nodeIt1.username);
					index++;
				}
			}
		}
		
		return newList;
	}
	
	public static LstRequest searchSource(LstRequest lista1,String Ciudad) {
		LstRequest newList= new LstRequest();
		int index=0;
		for (Request nodeIt1= lista1.header; nodeIt1 != lista1.trailer; nodeIt1 = nodeIt1.next) {
			if(nodeIt1.origin==Ciudad) {
				newList.insertAt(index, nodeIt1.origin,nodeIt1.destination,nodeIt1.username);
				index++;
			}
		}
		return newList;
	}
	
	
	public static LstRequest searchTarget(LstRequest lista1,String Ciudad) {
		LstRequest newList= new LstRequest();
		int index=0;
		for (Request nodeIt1= lista1.header; nodeIt1 != lista1.trailer; nodeIt1 = nodeIt1.next) {
			if(nodeIt1.destination==Ciudad) {
				newList.insertAt(index, nodeIt1.origin,nodeIt1.destination,nodeIt1.username);
				index++;
			}
		}
		return newList;
	}
	
	
	
	
	
}
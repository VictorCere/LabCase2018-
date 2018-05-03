package fase1;

public class SharingCar {
	public LstRequest mergeAlternateRequest(LstRequest lista1,LstRequest lista2) {
		LstRequest newList= new LstRequest();
		Request nodeIt1 = lista1.header;
		Request nodeIt2 = lista2.header;
		int index=0;
		while (nodeIt1 !=lista1.trailer ||nodeIt2 !=lista2.trailer ) {
			if (nodeIt1 !=lista1.trailer) {
				newList.insertAt(index, nodeIt1.Origen,nodeIt1.Destino,nodeIt1.idUsuario);
				nodeIt1=nodeIt1.next;
				}
			if (nodeIt2 !=lista2.trailer) {				
				newList.insertAt(index, nodeIt2.Origen,nodeIt2.Destino,nodeIt2.idUsuario);
				nodeIt2=nodeIt2.next;
			}
		}
		return newList;	
	}
	public LstRequest sharing(LstRequest lista1,LstRequest lista2) {
		int index=0;
		LstRequest newList= new LstRequest();
		for (Request nodeIt1= lista1.header; nodeIt1 != lista1.trailer; nodeIt1 = nodeIt1.next) {
			for (Request nodeIt2 = lista2.header; nodeIt2 != lista2.trailer; nodeIt2 = nodeIt2.next){
				if (nodeIt1.Origen==nodeIt2.Origen && nodeIt1.Destino==nodeIt2.Destino) {
					newList.insertAt(index, nodeIt1.Origen,nodeIt1.Destino,nodeIt1.idUsuario);
					index++;
					newList.insertAt(index, nodeIt1.Origen,nodeIt1.Destino,nodeIt1.idUsuario);
					index++;
				}
				
			}
		}
		return newList;
	}

	
	public LstRequest sort(LstRequest lista1,int parametro) {
		if (parametro==1) {
		LstRequest newList= new LstRequest();
		int contadorInser=0;
		for (Request nodeIt1= lista1.header.next; nodeIt1 != lista1.trailer; nodeIt1 = nodeIt1.next) {
			for	(Request nodeIt2=newList.header.next;nodeIt2!=newList.trailer;nodeIt2=nodeIt2.next) {
				if (nodeIt1.Origen.compareTo(nodeIt2.Origen)<0) {
					newList.insertAt(contadorInser, nodeIt1.Origen, nodeIt1.Destino, nodeIt1.idUsuario);
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
					if (nodeIt1.Destino.compareTo(nodeIt2.Destino)<0) {
						newList.insertAt(contadorInser, nodeIt1.Origen, nodeIt1.Destino, nodeIt1.idUsuario);
						contadorInser=0;
					}
					contadorInser++;
				}	
			}
			return newList;
		}
		else {return null;}
	}
	public LstRequest removeDuplicates(LstRequest lista1) {
		int index=0;
		LstRequest newList= new LstRequest();
		for (Request nodeIt1= lista1.header; nodeIt1 != lista1.trailer; nodeIt1 = nodeIt1.next) {
			for (Request nodeIt2 = lista1.header; nodeIt2 != lista1.trailer; nodeIt2 = nodeIt2.next){
				if (nodeIt1.Origen!=nodeIt2.Origen && nodeIt1.Destino!=nodeIt2.Destino && nodeIt1.idUsuario!=nodeIt2.idUsuario) {
					newList.insertAt(index, nodeIt1.Origen,nodeIt1.Destino,nodeIt1.idUsuario);
					index++;
				}
			}
		}
		
		return newList;
	}
	
	public LstRequest searchSource(LstRequest lista1,String Ciudad) {
		LstRequest newList= new LstRequest();
		int index=0;
		for (Request nodeIt1= lista1.header; nodeIt1 != lista1.trailer; nodeIt1 = nodeIt1.next) {
			if(nodeIt1.Origen==Ciudad) {
				newList.insertAt(index, nodeIt1.Origen,nodeIt1.Destino,nodeIt1.idUsuario);
				index++;
			}
		}
		return newList;
	}
	
	
	public LstRequest searchTarget(LstRequest lista1,String Ciudad) {
		LstRequest newList= new LstRequest();
		int index=0;
		for (Request nodeIt1= lista1.header; nodeIt1 != lista1.trailer; nodeIt1 = nodeIt1.next) {
			if(nodeIt1.Destino==Ciudad) {
				newList.insertAt(index, nodeIt1.Origen,nodeIt1.Destino,nodeIt1.idUsuario);
				index++;
			}
		}
		return newList;
	}
	
	
	
	
	
}
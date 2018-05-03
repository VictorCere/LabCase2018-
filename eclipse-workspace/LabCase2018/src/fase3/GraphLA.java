package fase3;


import Linear.SQueue;
import Linear.DNodeVertex;
import Linear.DListVertex;
import fase1.LstRequest;

public class GraphLA implements IGraph {
	
	int numVertices;
	int maxVertices;
	
	DListVertex[] vertices;
	boolean directed;
	
	
	
	public GraphLA(String a[]) {
		int n=a.length;
		int max=n;
		if (max<=0) 
			throw new IllegalArgumentException("Negative maximum number of vertices!!!");
		if (n<=0) 
			throw new IllegalArgumentException("Negative number of vertices!!!.");
		if (n>max) 
			throw new IllegalArgumentException("number of vertices can never "
					+ "be greater than the maximum.");
		
		maxVertices=max;
		vertices=new DListVertex[maxVertices];
		numVertices=n;
		//creates each list
		for (int i=0; i<numVertices;i++) {
			vertices[i]=new DListVertex(a[i]);
		}
		directed=true;
	}
	
	
	public void setTravels(LstRequest offers){
		
		
	}
	
	
	public void addVertex() {
		if (numVertices==maxVertices) {
			System.out.println("Cannot add new vertices!!!");
			return;
		}
		numVertices++;
		vertices[numVertices-1]=new DListVertex(); 
	}
		
	@Override
	public int sizeVertices() {
		return numVertices;
	}

	@Override
	public int sizeEdges() {
		int numEdges=0;
		for (int i=0;i<numVertices;i++) {
			if (vertices[i]!=null) numEdges=+vertices[i].getSize();
		}
		if (!directed) numEdges=numEdges/2;
		return numEdges;
	}

	
	public int getOutDegree(int i) {
		if (!checkVertex(i)) 
			throw new IllegalArgumentException("Nonexistent vertex  " + i);
		
		int outdegree=0;
		outdegree=vertices[i].getSize();
		return outdegree;
	}
	
	public int getInDegree(int i) {
		if (!checkVertex(i)) 
			throw new IllegalArgumentException("Nonexistent vertex  " + i);
		int indegree=0;
		for (int j=0; j<numVertices;j++) {
			if (vertices[j].contains(i)) indegree++;
		}
		return indegree;
	}

	
	
	
	
	@Override
	public int getDegree(int i) {
		int degree=0;
		if (directed) {
			degree=getOutDegree(i)+getInDegree(i);
		} else degree=vertices[i].getSize();
		return degree;
	}
	
	@Override
	public void addEdge(int i, int j) {
		//by default, we add an edge with value 0;
		addEdge(i,j,0);
	}
	//check if i is a right vertex
	private boolean checkVertex(int i) {
		if (i>=0 && i<numVertices) return true;
		else return false;
	}
		
	public void addEdge(int i, int j, float w) {
		if (!checkVertex(i)) 
			throw new IllegalArgumentException("Nonexistent vertex  " + i);
		if (!checkVertex(j)) 
			throw new IllegalArgumentException("Nonexistent vertex  " + j);
		if (vertices[i].contains(j)) {
			
			int index=vertices[i].getIndexOf(j);
			DNodeVertex node=vertices[i].getAt(index);
			node.weight=w;
			
			if (!directed) {
				index=vertices[j].getIndexOf(i);
				node=vertices[j].getAt(index);
				node.weight=w;
			}
		} else {
			vertices[i].addLast(j,w);
			//if it is a non-directed graph
			if (!directed) vertices[j].addLast(i,w);
		}
	}

	
	
	public void removeEdge(int i, int j) {
		if (!checkVertex(i)) 
			throw new IllegalArgumentException("Nonexistent vertex  " + i);
		if (!checkVertex(j)) 
			throw new IllegalArgumentException("Nonexistent vertex  " + j);
		
		int index=vertices[i].getIndexOf(j);
		vertices[i].removeAt(index);
		
		if (!directed) {
				index=vertices[j].getIndexOf(i);
				vertices[j].removeAt(index);
		}
	}

	@Override
	public boolean isEdge(int i, int j) {
		if (!checkVertex(i)) 
			throw new IllegalArgumentException("Nonexistent vertex  " + i);
		if (!checkVertex(j)) 
			throw new IllegalArgumentException("Nonexistent vertex  " + j);
		
		boolean result=vertices[i].contains(j);
		return result;
	}

	@Override
	public Float getWeightEdge(int i, int j) {
		if (!checkVertex(i)) throw new IllegalArgumentException("Nonexistent vertex  " + i);
		if (!checkVertex(j)) throw new IllegalArgumentException("Nonexistent vertex  " + j);
		Float result=null;
		int index=vertices[i].getIndexOf(i);
		if (index!=-1) {
			result=vertices[i].getAt(index).weight;
		}
		return result;
	}

	@Override
	public void show() {

		for (int i=0; i<numVertices; i++) {
			if (vertices[i]!=null) {
				System.out.println("adjacentes vertices for vertex  " + i + ": " + vertices[i].toString() );
			}
		}
		
	}

	public int[] getAdjacents(int i) {
		if (!checkVertex(i)) 
			throw new IllegalArgumentException("Nonexistent vertex  " + i);
		//gets the number of adjacent vertices
		int numAdj=vertices[i].getSize();
		//creates the array
		int[] adjVertices=new int[numAdj];
		//saves the adjacent vertices into the array
		for (int j=0; j<numAdj; j++) {
			adjVertices[j]=vertices[i].getAt(j).vertex;
		}
		//return the array with the adjacent vertices of i
		return adjVertices;
	}
	
	public void breadth() {
		System.out.println("breadth traverse of the graph:");
		
		//to mark when a vertex has already been shown
		boolean visited[]=new boolean[numVertices];

		//we have to traverse all vertices
		for (int i=0;i<numVertices;i++) {
			if (!visited[i]) { //we only process the non-visited vertex
				breadth(i,visited);
			}
		}
		System.out.println();

	}
	
	

	//breadth order for the vertex i 
	protected void breadth(int i, boolean[] visited) {
		//this array helps to mark what vertices have been stored into the queue
		boolean stored[]=new boolean[numVertices];
		//System.out.println("breadth traverse for " + i);
		//we use a queue to save the adjacent vertices that we visit
		SQueue q=new SQueue();
		//enqueue the first
		q.enqueue(i);
		//while the queue is not empty
		while (!q.isEmpty()) {
			//gets the first
			int vertex=q.dequeue();
			//shows the vertex and marks it as visited
			System.out.print(vertex+"\t");
			visited[vertex]=true;
			//gets its adjacent vertices
			int[] adjacents=getAdjacents(vertex);
			for(int adjVertex:adjacents) {
					//enqueue only those that have not been visited or stored yet 
					if (!visited[adjVertex] && !stored[adjVertex]) {
						q.enqueue(adjVertex);
						stored[adjVertex]=true;
					}
			}
		}
	}
	
	public void depth() {
		System.out.println("depth traverse of the graph:");
		//to mark when a vertex has already been shown
		boolean visited[]=new boolean[numVertices];
		//we have to traverse all vertices
		for (int i=0;i<numVertices;i++) {
			if (!visited[i]) {
				depth(i,visited);
			}
		}
		System.out.println();

	}
	
	

	protected void depth(int i,boolean[] visited) {
		//prints the vertex and marks as visited
		System.out.print(i+"\t");
		visited[i]=true;
		//gets its adjacent vertices
		int[] adjacents=getAdjacents(i);
		for (int adjV:adjacents) {
			if (!visited[adjV]) {
				//only depth traverses those adjacent vertices 
				//that have not been visited yet
				depth(adjV,visited);
				
			}
		}
	}
	
	
	
	
	public static void main(String args[]) {
		GraphLA graph=new GraphLA(8,8,true);
		//graph.show();
//code for creating a graph with random weights
//		Random rn=new Random();
//		//initializes a directed graph with random numbers 
//		for (int i=0; i<graph.numVertices;i++) {
//			for (int j=0; j<graph.numVertices;j++) {
//				//add an edge with a random weight
//	 			graph.addEdge(i, j,rn.nextInt(5));
//	 			//graph.addEdge(i, j,1);
//	 		}
//		}
		
		
////			0	1	2	3	4	5	6	7
//		0	-	1	1	-	-	-	-	-
//		1	-	-	1	1	-	-	-	-
//		2	-	-	-	1	-	1	-	-
//		3	-	-	-	-	1	-	-	-
//		4	-	-	-	-	-	-	-	-
//		5	-	-	-	-	-	-	-	-
//		6	-	-	-	-	-	-	-	-
//		7	-	-	-	-	-	-	1	-


		//row 0
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 2);
		
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 1);

		graph.addEdge(2, 3, 1);
		graph.addEdge(2, 5, 1);

		graph.addEdge(7,6, 1);
		
		graph.show();
		
//		System.out.println("Vertices:" + graph.sizeVertices());
//		System.out.println("total edges:" + graph.sizeEdges());
//
//		for (int i=0;i<graph.numVertices;i++) {
//			System.out.print("Indeg("+i+")="+graph.getInDegree(i));
//			System.out.print("\tOutdeg("+i+")="+graph.getOutDegree(i));
//			System.out.print("\tDeg("+i+")="+graph.getDegree(i));
//			System.out.println();
//			
//		}
		
		System.out.println();
		graph.breadth();
		graph.depth();
	}
	 
	
}

package fase3;
import Linear.SQueue;

//This implementation should used an adjacency matrix.
public class GraphMA implements IGraph {

	//number of vertices in the graph
	int numVertices;
	//maximum number of graph
	int maxVertices;
	//matrix cannot be float, because float does not allow to store null
	Float[][] matrix;
	//directed or not
	boolean directed;
	
	
	public GraphMA(int n, int max, boolean d) {
		//We checks if the values are right for the graph
		if (max<=0) 
			throw new IllegalArgumentException("Negative maximum number of vertices!!!");
		if (n<=0) 
			throw new IllegalArgumentException("Negative number of vertices!!!.");
		if (n>max) 
			throw new IllegalArgumentException("number of vertices can never be greater than the maximum.");
		
		
		maxVertices=max;
		numVertices=n;
		matrix=new Float[maxVertices][maxVertices];
		directed=d;
	}
	
	
	//check if i is a right vertex
	private boolean checkVertex(int i) {
		//i has to be positive and lower than numVertices
		if (i>=0 && i<numVertices) return true;
		else return false;
	}
	
	
	
	public void addVertex() {
		if (numVertices==maxVertices) {
			System.out.println("Cannot add a new vertex!!!");
			return;
		}
		//increases the number of vertices
		numVertices++;
	}
	
	
	public int sizeVertices() {
		//returns the number of vertices
		return numVertices;
	}

	//return the number of edges
	public int sizeEdges() {
		int numEdges=0;
		if (directed) {
			for (int i=0;i<numVertices;i++) {
				for (int j=0;j<numVertices;j++) {
					if (matrix[i][j]!=null) numEdges++;
				}	
			}
		} else {
			//we only have to visit the half of the matrix (because it is symmetric)
			for (int i=0;i<numVertices;i++) {
				for (int j=i;j<numVertices;j++) {
					if (matrix[i][j]!=null) numEdges++;
				}	
			}
		}
		return numEdges;
	}

	@Override
	public int getDegree(int i) {
		if (!checkVertex(i)) 
			throw new IllegalArgumentException("Nonexistent vertex  " + i);
		int degree=0;
		
		if (directed) degree=getInDegree(i)+getOutDegree(i); 
		else {
			//we could count the number of rows or columns that have an edge with i
			//in this implementation, we count the number of rows
			for (int row=0;row<numVertices;row++) {
				if (matrix[row][i]!=null) degree++;
			}
		}
		return degree;
	}

	@Override
	public int getInDegree(int i) {
		//a non directed graph do not have getInDegree
		if (!directed) {
			System.out.println("Graph non directed!!!");
			return 0;
		}
		//checks if i is a right vertex
		if (!checkVertex(i)) 
			throw new IllegalArgumentException("Nonexistent vertex  " + i);
		
		//count the number of rows that have an edge with i
		int indeg=0;
		for (int row=0;row<numVertices;row++) {
			if (matrix[row][i]!=null) indeg++;
		}
		
		return indeg;
	}

	public int getOutDegree(int i) {
		//a non directed graph do not have getOutDegree
		if (!directed) {
			System.out.println("Graph non directed!!!");
			return 0;
		}
		//checks if the vertex is right
		if (!checkVertex(i)) 
			throw new IllegalArgumentException("Nonexistent vertex  " + i);
		
		int outdeg=0;
		//counts the columns that have an edge with i
		for (int col=0;col<numVertices;col++) {
			if (matrix[i][col]!=null) outdeg++;
		}
		return outdeg;
	}

	public void addEdge(int i, int j) {
		//by default, the edge is added with weight equals to 0
		addEdge(i,j,0);
	}
	
	

	@Override
	public void addEdge(int i, int j, float w) {
		//checks if the vertices are right
		if (!checkVertex(i)) throw new IllegalArgumentException("Nonexistent vertex  " + i);
		if (!checkVertex(j)) throw new IllegalArgumentException("Nonexistent vertex  " + j);
		//saves the weight 
		matrix[i][j]=w;
		//if is non directed, we also have to save the symmetric edge
		if (!directed) matrix[j][i]=w;
	}

	@Override
	public void removeEdge(int i, int j) {
		//checks if the indexes are right
		if (!checkVertex(i)) 
			throw new IllegalArgumentException("Nonexistent vertex  " + i);
		if (!checkVertex(j)) 
			throw new IllegalArgumentException("Nonexistent vertex  " + j);
		//updates the value to null
		matrix[i][j]=null;
		//if is non directed, we also have to remove the symmetric edge
		if (!directed) matrix[j][i]=null;
		
	}
	
	

	@Override
	public boolean isEdge(int i, int j) {
		//checks if the indexes are right
		if (!checkVertex(i)) 
			throw new IllegalArgumentException("Nonexistent vertex  " + i);
		if (!checkVertex(j)) 
			throw new IllegalArgumentException("Nonexistent vertex  " + j);
		//checks if there is an edge between i and j
		if (matrix[i][j]==null) return false;
		else return true;
	}

	@Override
	public Float getWeightEdge(int i, int j) {
		//checks if the indexes are right
		if (!checkVertex(i)) throw new IllegalArgumentException("Nonexistent vertex  " + i);
		if (!checkVertex(j)) throw new IllegalArgumentException("Nonexistent vertex  " + j);
		//gets the value saved in matrix[i,j]. This value could be null.
		Float result= matrix[i][j];
		return result;
	}

	public void show() {
		//visits the rows
		for (int i=0; i<numVertices;i++) {
			//for each row, visits all columns
			for (int j=0; j<numVertices;j++) {
				//prints the element in matrix[i,j] and a space
				System.out.print(matrix[i][j]+"\t");
			}
			//new line for the new row
			System.out.println();
		}
		System.out.println();

	}
	
	//returns an array with the adjacent vertices for i
	public int[] getAdjacents(int i) {
		if (!checkVertex(i)) 
				throw new IllegalArgumentException("Nonexistent vertex  " + i);
		
		//obtains the number of adjacent vertices,
		//which will be the size of the array
		int numAdjacents=0;
		if (directed) numAdjacents=getOutDegree(i);
		else numAdjacents=getDegree(i);
		
		int[] adjacents=new int[numAdjacents];
		
		if (numAdjacents>0) {
			int j=0;
			//gets the edges (i,col) and saves col into adjacents
			for (int col=0; col<numVertices;col++) {
				if (matrix[i][col]!=null) {
					adjacents[j]=col;
					j++;
				}
			}
		}
		//return an array with the adjacent vertices of i
		return adjacents;
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
			if (!visited[i]) depth(i,visited);
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
		GraphMA graph=new GraphMA(8,8,true);
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
		graph.breadth();
		graph.depth();
	}
	
	
}

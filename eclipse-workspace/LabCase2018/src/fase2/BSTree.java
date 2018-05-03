package fase2;

public class BSTree implements IBSTree {

	BSTNode root;

	public void getPreorder() {
		if (root != null)
			root.getPreorder();
	}

	public void getInorder() {
		if (root != null)
			root.getInorder();
	}

	public void getPostorder() {
		if (root != null)
			root.getPostorder();
	}

	public void getLevelorder() {
		if (root != null)
			root.getLevelorder();
	}

	public int getSize() {
		if (root == null)
			return 0;
		return root.getSize();
	}

	public int getHeight() {
		if (root == null)
			return 0;
		return root.getHeight();
	}

	public int getDepth() {
		if (root == null)
			return 0;
		return root.getDepth();
	}

	public void insertuser(String Username ,String Full_name,int Age,int Gender,int NComplains) {
		BSTNode newNode = new BSTNode(Username,Full_name,Age,Gender,NComplains);
		if (root == null)
			root = newNode;
		else
			insertuser(newNode, root);
	}

	public void insertuser(BSTNode newNode, BSTNode node) {
		String Username=newNode.Username;
		if (Username.compareToIgnoreCase(node.Username)== 0) {
			System.out.println(Username + " already exists. Duplicates are not allowed!!!.");
			return;
		}
		if (Username.compareToIgnoreCase(node.Username)<0) {
			if (node.left == null) {
				node.left = newNode;
				newNode.parent = node;
			} else
				insertuser(newNode, node.left);
		} else {
			if (node.right == null) {
				node.right = newNode;
				newNode.parent = node;
			} else
				insertuser(newNode, node.right);
		}
	}

	public void removeUser(String Username) {
		if (root == null) {
			System.out.println("Cannot remove: The tree is empty");
			return;
		}
		if (Username.compareToIgnoreCase(root.Username)==0) {
			if (root.left == null && root.right == null) {
				root = null;}
			else if (root.left == null || root.left == null) {
				if (root.left == null)
					root = root.right;
				if (root.right == null)
					root = root.left;
				root.parent = null;
			} else {
				removeUser(Username, root);
			}
		} else
			removeUser(Username, root);
	}

	public boolean removeUser(String Username, BSTNode node) {
		if (node == null) {
			System.out.println("Cannot remove: The key doesn't exist");
			return false;
		}
		if (Username.compareToIgnoreCase(node.Username) < 0)
			return removeUser(Username, node.left);

		if (Username.compareToIgnoreCase(node.Username)> 0)
			return removeUser(Username, node.right);
		//Here, it means that key.compareTo(node.Key)==0
		//That is, we already have found it: node is the node to remove.

		//First case: the node is a leaf.
		if (node.left == null && node.right == null) {
			BSTNode parent = node.parent;
			//we must break the references between the node and its parent. First, we must detect if the
			//node is the left or right child of its parent.
			if (parent.left == node)
				parent.left = null;//node has to be the left child of its parent
			else
				parent.right = null; //node is the rightChild
			node.parent = null; //is is not necessary, because Java has automatic garbage collection
			return true;
		}
		//Second case is one the node only has a child: left or right
		if (node.left == null || node.right == null) {
			//its only child is its right child
			BSTNode grandChild = null;
			if (node.left == null)
				grandChild = node.right;
			else
				grandChild = node.left;

			BSTNode grandParent = node.parent;
			if (grandParent.left == node)
				grandParent.left = grandChild;
			else
				grandParent.right = grandChild;
			//the grand child must point its grand parent.
			grandChild.parent = grandParent;
			return true;
		}

		//Third case: node has two childs.
		//We can replace its value by the maximum value in its left child or
		//by the minimum value in its right child
		BSTNode sucesorNode = findMin(node.right);
		node.User.Full_name = sucesorNode.User.Full_name;
		node.User.Age = sucesorNode.User.Age;
		node.User.Gender = sucesorNode.User.Gender;
		node.User.NComplains = sucesorNode.User.NComplains;
		node.Username = sucesorNode.Username;
		removeUser(sucesorNode.Username, node.right);
		return true;
		//Finally, we must remove the sucesorNode
	}

	public BSTNode findMin(BSTNode node) {
		if (node != null)
			while (node.left != null)
				node = node.left;
		return node;
	}

	public BSTNode findRecMin(BSTNode node) {
		if (node == null)
			return null;
		else if (node.left == null)
			return node;
		return findRecMin(node.left);
	}

	public BSTNode findMax(BSTNode node) {
		if (node != null)
			while (node.right != null)
				node = node.right;
		return node;
	}

	public BSTNode findRecMax(BSTNode node) {
		if (node == null)
			return null;
		else if (node.right == null)
			return node;
		return findRecMax(node.right);
	}

/*	public BSTNode findUser(String Full_name) {
		return findUser(root, Full_name);
	}

	public BSTNode findUser(BSTNode node, String Full_name) {
		if (node == null)return null;
		findUser(node.left,Full_name);
		if (node.Full_name==Full_name) {
			System.out.println(" \"Usuario: node.Username\"+\"Nombre: node.Full_name\"+\"Edad: node.Age\"+\"Genero: node.Gender\"+\"Quejas:   node.User.NComplains\";");
			return node;
		}
		
		findUser(node.right,Full_name);
		return null;
	}	*/

	public BSTNode findUser(String Username) {
		return findUser(root, Username);
	}

	public BSTNode findUser(BSTNode node, String Username) {
		if (node == null)
			return null;
		else if (Username.compareToIgnoreCase(node.Username)< 0)
			return findNode(node.left, Username);
		else if (Username.compareToIgnoreCase(node.Username)> 0)
			return findNode(node.right,Username );
		else
			return node;
	}
	
	public BSTNode findNode(BSTNode node, String Username) {
	if (node == null)
			return null;
		else if (Username.compareToIgnoreCase(node.Username)< 0)
			return findNode(node.left, Username);
		else if (Username.compareToIgnoreCase(node.Username)> 0)
			return findNode(node.right,Username );
		else
			return node;
	}
	
	public void complaint(String Username) {
		BSTNode newNode=findNode(root,Username);
		if(newNode.User.NComplains>3) {
			removeUser(newNode.Username);			
		}
		else {
			newNode.User.NComplains++;
		}
		
	}
	public void show() {
		show(root);
	}
	public void show(BSTNode node) {
		node=root;
		if (node == null)
			return;
		show(node.left);
		System.out.println(node.Username+", ");
		show(node.right);
	}
	

	public void showLevel() {
		
		if (root != null)
			for (int i = 0; i < root.getHeight(root); i++)
				showLevel(root, i);
	}

	public void showLevel(BSTNode node, int level) {
		if (node != null) {
			if (level == 0)
				System.out.println(node.Username+(", "));
			else {
				showLevel(node.left, level - 1);
				showLevel(node.right, level - 1);
			}
		}
	}
	public DList[] extremeUsers() {
		int[] i = new int[1];
		DList[] e=new DList[1];
		int cont=0;
		 i=extremeUsersminmax(root,6,0,i);
		 e=extremeUsers(root,i,e,cont);
		 return e;
		 
		 
	}
	public int[] extremeUsersminmax(BSTNode node,int min,int max,int[] i) {
		if (node == null)return null;
		show(node.left);
		if (node.User.NComplains<min || node.User.NComplains>max) {
			if (node.User.NComplains>max) {
				i[1]=node.User.NComplains;
			}
			if (node.User.NComplains<min){
				i[0]=node.User.NComplains;
			}
		}
		show(node.right);
		
		return i;
	}
	
	
	public DList[] extremeUsers(BSTNode node,int[] i,DList[] e,int cont) {
		if (node == null)return null;
		show(node.left);
			if (node.User.NComplains==i[1]) {
				e[1].insertAt(cont,node.Username);
			}
			if (node.User.NComplains==i[0]){
				e[0].insertAt(cont,node.Username);
			}
		show(node.right);
		
		return e;
	}
	
	
	
	
/*	public int sumAll() {
		return sumAll(root);
	}

	public int sumAll(BSTNode node) {
		if (node == null)
			return 0;
		else
			return node.key + sumAll(node.left) + sumAll(node.right);
	}

	public BSTNode successor(BSTNode node) {
		if (node == null)
			return null;
		return findMin(node.right);
	}

	public BSTNode predecessor(BSTNode node) {
		if (node == null)
			return null;
		return findMax(node.left);
	}

	public int searchMin() {
		if (root == null) {
			System.out.println("The tree is empty");
			return -1;
		}
		return findMin(root).elem;
	}

	public int searchMax() {
		if (root == null) {
			System.out.println("The tree is empty");
			return -1;
		}
		return findMax(root).elem;
	}

	public int balanceFactorSize(BSTNode node) {
		if (node == null)
			return 0;
		return Math.abs(node.right.getSize() - node.left.getSize());
	}

	public int balanceFactorHeight(BSTNode node) {
		if (node == null)
			return 0;
		return Math.abs(node.right.getHeight() - node.left.getHeight());
	}

	public boolean isBalanceSize() {
		return isBalanceSize(root);
	}

	public boolean isBalanceSize(BSTNode node) {
		if (node == null)
			return true;
		return balanceFactorSize(node) <= 1 && isBalanceSize(node.left) && isBalanceSize(node.right);
	}

	public boolean isBalanceHeight() {
		return isBalanceHeight(root);
	}

	public boolean isBalanceHeight(BSTNode node) {
		if (node == null)
			return true;
		return balanceFactorHeight(node) <= 1 && isBalanceHeight(node.left) && isBalanceHeight(node.right);
	}*/

}
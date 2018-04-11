public class BSTNode implements IBSTNode {

	Integer key;
	String Username;
	String Full_name;
	int Age;
	int Gender;
	int NComplains;
	

	BSTNode parent;
	BSTNode left;
	BSTNode right;

	public BSTNode(Integer k, String Username ,String Full_name,int Age,int Gender,int NComplains) {
		key = k;
		this.Username=Username;
		this.Full_name=Full_name;
		this.Age=Age;
		this.Gender=Gender;
		this.NComplains=NComplains;
	}

	public boolean isInternal() {
		return (left != null || right != null);
	}

	public boolean isExternal() {
		return (left == null && right == null);
	}

	public BSTNode getRoot() {
		if (parent == null)
			return this;
		else
			return parent.getRoot();
	}

	public boolean isRoot() {
		return parent == null;
	}

	public int getSize() {
		return getSize(this);
	}

	public int getSize(BSTNode node) {
		if (node == null)
			return 0;
		else
			return 1 + getSize(node.left) + getSize(node.right);
	}

	public int getHeight() {
		return getHeight(this);
	}

	public int getHeight(BSTNode node) {
		if (node == null)
			return 0;
		else
			return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	public int getDepth() {
		return getDepth(this);
	}

	public int getDepth(BSTNode node) {
		if (node == null)
			return -1;
		else
			return 1 + getDepth(node.parent);
	}

	public void getPreorder() {
		getPreorder(this);
	}

	public void getInorder() {
		getInorder(this);
	}

	public void getPostorder() {
		getPostorder(this);
	}

	public void getLevelorder() {
		getLevelorder(this);
	}

	public void getPreorder(BSTNode node) {
		if (node == null)
			return;
		System.out.println("(" + node.key + "," + node.elem + ")");
		getPreorder(node.left);
		getPreorder(node.right);
	}

	public void getInorder(BSTNode node) {
		if (node == null)
			return;
		getInorder(node.left);
		System.out.println("(" + node.key + "," + node.elem + ")");
		getInorder(node.right);
	}

	public void getPostorder(BSTNode node) {
		if (node == null)
			return;
		getPostorder(node.left);
		getPostorder(node.right);
		System.out.println("(" + node.key + "," + node.elem + ")");
	}

	public void getLevelorder(BSTNode node) {
		if (node != null)
			for (int i = 0; i < getHeight(node); i++)
				getLevelorder(node, i);
	}

	public void getLevelorder(BSTNode node, int level) {
		if (node != null) {
			if (level == 0)
				System.out.println("(" + node.key + "," + node.elem + ")");
			else {
				getLevelorder(node.left, level - 1);
				getLevelorder(node.right, level - 1);
			}
		}
	}

}
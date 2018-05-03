package fase2;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
import org.junit.Before;


public class UsersTest {

	//auxiliary methods 
	public static boolean equals(DList list1, DList list2) {
		if (list1==list2) return true;
		
		if (list1.getSize()!=list2.getSize()) return false;
		
		for (int i=0; i<list1.getSize(); i++) {
			String s1=list1.getAt(i);
			String s2=list2.getAt(i);
			try {
				if (s1!=null || s2!=null) {
					if (!s1.equals(s2)) 
						return false;
				}
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}
	
	
	
	//Objects
	Users tree=new Users();
	DList list=new DList();

	DList remove_successor=new DList();
	DList remove_predecessor=new DList();
	
	Random rn=new Random();
	Users empty=new Users();
	
	@Before
	public void setUp() throws Exception {
		//input tree
		//					jj
		//		cc						rr
		//			dd			nn				ss
		
		tree.insertUser(new User("jj","Alberto",30,"H"));
		tree.insertUser(new User("rr","Alberto",35,"H",2));
		tree.insertUser(new User("cc","Alberto",25,"H"));
		tree.insertUser(new User("ss","Javer",32,"H"));
		tree.insertUser(new User("nn","Ana",22,"M"));
		tree.insertUser(new User("dd","Juan",18,"H"));
	
		
		list.addLast("cc");
		list.addLast("dd");
		list.addLast("jj");
		list.addLast("nn");
		list.addLast("rr");
		list.addLast("ss");


		//list after remove root - succesor
		remove_successor.addLast("ss");
		remove_successor.addLast("cc");
		remove_successor.addLast("dd");
	
		//list after remove root - predecessor
		remove_predecessor.addLast("dd");
		remove_predecessor.addLast("cc");
		remove_predecessor.addLast("ss");



	}
	

	@Test
	public void testInsertUser() {
		Users aux=new Users();
		aux.insertUser(new User("dd","Juan",18,"H"));
		
		DList list=new DList();
		list.addLast("dd");
		
		assertEquals("Check insert an user in empty tree.", true, 
				UsersTest.equals(aux.getSortedList(),list) );		
		
		aux.insertUser(new User("ee","Loli",38,"M"));
		list.addLast("ee");

		assertEquals("package phase3;\n" + 
				"\n" + 
				"import static org.junit.Assert.*;\n" + 
				"\n" + 
				"import java.util.Arrays;\n" + 
				"\n" + 
				"import org.junit.Before;\n" + 
				"import org.junit.Test;\n" + 
				"\n" + 
				"import phase1.Request;\n" + 
				"import phase1.LstRequest;\n" + 
				"public class SharingGraphTest {\n" + 
				"	\n" + 
				"	public static boolean equalsArrayOfPairs(Pair[] a1, Pair[]a2) {\n" + 
				"		if (a1==null && a2!=null) return false;\n" + 
				"		if (a1!=null && a2==null) return false;\n" + 
				"		if (a1.length!=a2.length) return false;\n" + 
				"		\n" + 
				"		for (int i=0; i<a1.length;i++) {\n" + 
				"			Pair p1=a1[i];\n" + 
				"			Pair p2=a2[i];\n" + 
				"			if (!p1.equals(p2)) return false;\n" + 
				"		}\n" + 
				"		\n" + 
				"		return true;\n" + 
				"		\n" + 
				"	}\n" + 
				"	\n" + 
				"	\n" + 
				"	public static final String cities[]={\"Madrid\",\n" + 
				"\"Barcelona\", \"Valencia\",\"Sevilla\",\"Bilbao\",\n" + 
				"\"Granada\",\"Toledo\",\"Salamanca\",\"Alicante\",\"Caceres\"};\n" + 
				"	String[] fromCaceres=null;\n" + 
				"	String[] fromMadrid=null;\n" + 
				"	String[] fromBilbao=null;\n" + 
				"	String[] depth1=null;\n" + 
				"	String[] depth2=null;\n" + 
				"	String[] depth3=null;\n" + 
				"\n" + 
				"	\n" + 
				"	String[] toMadrid=null;\n" + 
				"	String[] toBilbao=null;\n" + 
				"	String[] toSalamanca=null;\n" + 
				"\n" + 
				"	SharingGraph graph=new SharingGraph(cities);\n" + 
				"	LstRequest lst=new LstRequest();\n" + 
				"	\n" + 
				"	Pair[] noConnected=null;\n" + 
				"	@Before\n" + 
				"	public void setUp() throws Exception {\n" + 
				"		lst.addLast(new Request(null,\"Madrid\",\"Sevilla\"));\n" + 
				"		lst.addLast(new Request(null,\"Madrid\",\"Barcelona\"));\n" + 
				"		lst.addLast(new Request(null,\"Bilbao\",\"Madrid\"));\n" + 
				"		lst.addLast(new Request(null,\"Valencia\",\"Madrid\"));\n" + 
				"		lst.addLast(new Request(null,\"Valencia\",\"Barcelona\"));\n" + 
				"		lst.addLast(new Request(null,\"Madrid\",\"Barcelona\"));\n" + 
				"		lst.addLast(new Request(null,\"Sevilla\",\"Madrid\"));\n" + 
				"		lst.addLast(new Request(null,\"Madrid\",\"Sevilla\"));\n" + 
				"		lst.addLast(new Request(null,\"Alicante\",\"Barcelona\"));\n" + 
				"		lst.addLast(new Request(null,\"Valencia\",\"Madrid\"));\n" + 
				"		lst.addLast(new Request(null,\"Valencia\",\"Barcelona\"));\n" + 
				"		lst.addLast(new Request(null,\"Madrid\",\"Sevilla\"));\n" + 
				"		lst.addLast(new Request(null,\"Madrid\",\"Toledo\"));\n" + 
				"		lst.addLast(new Request(null,\"Toledo\",\"Salamanca\"));\n" + 
				"		lst.addLast(new Request(null,\"Toledo\",\"Salamanca\"));\n" + 
				"		lst.addLast(new Request(null,\"Salamanca\",\"Barcelona\"));\n" + 
				"		lst.addLast(new Request(null,\"Toledo\",\"Caceres\"));\n" + 
				"		lst.addLast(new Request(null,\"Barcelona\",\"Toledo\"));\n" + 
				"		\n" + 
				"		graph.setTravels(lst);\n" + 
				"		\n" + 
				"		\n" + 
				"		String[] auxBil={\"Madrid\"};\n" + 
				"		fromBilbao=auxBil;\n" + 
				"		\n" + 
				"		String[] auxMad={\"Sevilla\", \"Barcelona\", \"Toledo\"};\n" + 
				"		fromMadrid=auxMad;\n" + 
				"		Arrays.sort(fromMadrid);\n" + 
				"		\n" + 
				"		\n" + 
				"		\n" + 
				"		String[] aux2={\"Bilbao\",\"Sevilla\",\"Valencia\"};\n" + 
				"		toMadrid=aux2;\n" + 
				"		Arrays.sort(toMadrid);\n" + 
				"		\n" + 
				"		String[] aux3={\"Toledo\"};\n" + 
				"		toSalamanca=aux3;\n" + 
				"		\n" + 
				"		\n" + 
				"		\n" + 
				"		String[] depth1={\"Madrid\",\"Sevilla\",\"Barcelona\",\"Toledo\",\n" + 
				"				\"Salamanca\",\"Caceres\",\"Valencia\",\"Bilbao\",\"Granada\",\"Alicante\"};\n" + 
				"\n" + 
				"		String[] depth2={\"Madrid\",\"Barcelona\",\"Toledo\",\n" + 
				"				\"Salamanca\",\"Caceres\",\"Sevilla\",\"Valencia\",\"Bilbao\",\"Granada\",\"Alicante\"};\n" + 
				"\n" + 
				"		String[] depth3={\"Madrid\",\"Toledo\",\n" + 
				"				\"Salamanca\",\"Barcelona\", \"Caceres\",\"Sevilla\",\"Valencia\",\"Bilbao\",\"Granada\",\"Alicante\"};\n" + 
				"		\n" + 
				"		this.depth1=depth1;\n" + 
				"		this.depth2=depth2;\n" + 
				"		this.depth3=depth3;\n" + 
				"\n" + 
				"		\n" + 
				"		Pair[] noConnected={\n" + 
				"				new Pair(\"Madrid\", \"Valencia\"),\n" + 
				"				new Pair(\"Madrid\", \"Bilbao\"),\n" + 
				"				new Pair(\"Madrid\", \"Granada\"),\n" + 
				"				new Pair(\"Madrid\", \"Salamanca\"),\n" + 
				"				new Pair(\"Madrid\", \"Alicante\"),\n" + 
				"				new Pair(\"Madrid\", \"Caceres\"),\n" + 
				"				\n" + 
				"				new Pair(\"Barcelona\", \"Madrid\"),\n" + 
				"				new Pair(\"Barcelona\", \"Valencia\"),\n" + 
				"				new Pair(\"Barcelona\", \"Sevilla\"),\n" + 
				"				new Pair(\"Barcelona\", \"Bilbao\"),\n" + 
				"				new Pair(\"Barcelona\", \"Granada\"),\n" + 
				"				new Pair(\"Barcelona\", \"Salamanca\"),\n" + 
				"				new Pair(\"Barcelona\", \"Alicante\"),\n" + 
				"				new Pair(\"Barcelona\", \"Caceres\"),\n" + 
				"				\n" + 
				"				new Pair(\"Valencia\", \"Sevilla\"),\n" + 
				"				new Pair(\"Valencia\", \"Bilbao\"),\n" + 
				"				new Pair(\"Valencia\", \"Granada\"),\n" + 
				"				new Pair(\"Valencia\", \"Toledo\"),\n" + 
				"				new Pair(\"Valencia\", \"Salamanca\"),\n" + 
				"				new Pair(\"Valencia\", \"Alicante\"),\n" + 
				"				new Pair(\"Valencia\", \"Caceres\"),\n" + 
				"				\n" + 
				"				new Pair(\"Sevilla\", \"Barcelona\"),\n" + 
				"				new Pair(\"Sevilla\", \"Valencia\"),\n" + 
				"				new Pair(\"Sevilla\", \"Bilbao\"),\n" + 
				"				new Pair(\"Sevilla\", \"Granada\"),\n" + 
				"				new Pair(\"Sevilla\", \"Toledo\"),\n" + 
				"				new Pair(\"Sevilla\", \"Salamanca\"),\n" + 
				"				new Pair(\"Sevilla\", \"Alicante\"),\n" + 
				"				new Pair(\"Sevilla\", \"Caceres\"),\n" + 
				"				\n" + 
				"				new Pair(\"Bilbao\", \"Barcelona\"),\n" + 
				"				new Pair(\"Bilbao\", \"Valencia\"),\n" + 
				"				new Pair(\"Bilbao\", \"Sevilla\"),\n" + 
				"				new Pair(\"Bilbao\", \"Granada\"),\n" + 
				"				new Pair(\"Bilbao\", \"Toledo\"),\n" + 
				"				new Pair(\"Bilbao\", \"Salamanca\"),\n" + 
				"				new Pair(\"Bilbao\", \"Alicante\"),\n" + 
				"				new Pair(\"Bilbao\", \"Caceres\"),\n" + 
				"				\n" + 
				"				new Pair(\"Granada\", \"Madrid\"),\n" + 
				"				new Pair(\"Granada\", \"Barcelona\"),\n" + 
				"				new Pair(\"Granada\", \"Valencia\"),\n" + 
				"				new Pair(\"Granada\", \"Sevilla\"),\n" + 
				"				new Pair(\"Granada\", \"Bilbao\"),\n" + 
				"				new Pair(\"Granada\", \"Toledo\"),\n" + 
				"				new Pair(\"Granada\", \"Salamanca\"),\n" + 
				"				new Pair(\"Granada\", \"Alicante\"),\n" + 
				"				new Pair(\"Granada\", \"Caceres\"),\n" + 
				"				\n" + 
				"				new Pair(\"Toledo\", \"Madrid\"),\n" + 
				"				new Pair(\"Toledo\", \"Barcelona\"),\n" + 
				"				new Pair(\"Toledo\", \"Valencia\"),\n" + 
				"				new Pair(\"Toledo\", \"Sevilla\"),\n" + 
				"				new Pair(\"Toledo\", \"Bilbao\"),\n" + 
				"				new Pair(\"Toledo\", \"Granada\"),\n" + 
				"				new Pair(\"Toledo\", \"Alicante\"),\n" + 
				"				\n" + 
				"				new Pair(\"Salamanca\", \"Madrid\"),\n" + 
				"				new Pair(\"Salamanca\", \"Valencia\"),\n" + 
				"				new Pair(\"Salamanca\", \"Sevilla\"),\n" + 
				"				new Pair(\"Salamanca\", \"Bilbao\"),\n" + 
				"				new Pair(\"Salamanca\", \"Granada\"),\n" + 
				"				new Pair(\"Salamanca\", \"Toledo\"),\n" + 
				"				new Pair(\"Salamanca\", \"Alicante\"),\n" + 
				"				new Pair(\"Salamanca\", \"Caceres\"),\n" + 
				"				\n" + 
				"				new Pair(\"Alicante\", \"Madrid\"),\n" + 
				"				new Pair(\"Alicante\", \"Valencia\"),\n" + 
				"				new Pair(\"Alicante\", \"Sevilla\"),\n" + 
				"				new Pair(\"Alicante\", \"Bilbao\"),\n" + 
				"				new Pair(\"Alicante\", \"Granada\"),\n" + 
				"				new Pair(\"Alicante\", \"Toledo\"),\n" + 
				"				new Pair(\"Alicante\", \"Salamanca\"),\n" + 
				"				new Pair(\"Alicante\", \"Caceres\"),\n" + 
				"				\n" + 
				"				new Pair(\"Caceres\", \"Madrid\"),\n" + 
				"				new Pair(\"Caceres\", \"Barcelona\"),\n" + 
				"				new Pair(\"Caceres\", \"Valencia\"),\n" + 
				"				new Pair(\"Caceres\", \"Sevilla\"),\n" + 
				"				new Pair(\"Caceres\", \"Bilbao\"),\n" + 
				"				new Pair(\"Caceres\", \"Granada\"),\n" + 
				"				new Pair(\"Caceres\", \"Toledo\"),\n" + 
				"				new Pair(\"Caceres\", \"Salamanca\"),\n" + 
				"				new Pair(\"Caceres\", \"Alicante\")\n" + 
				"				};\n" + 
				"	\n" + 
				"		this.noConnected=noConnected;\n" + 
				"	}\n" + 
				"\n" + 
				"	\n" + 
				"	@Test\n" + 
				"	public void testGetListDestination() {\n" + 
				"		String[] fromCaceres=graph.getListDestination(\"Caceres\");\n" + 
				"		assertEquals(\"Check testGetListDestination Caceres (null list).\", true, \n" + 
				"				Arrays.equals(fromCaceres,null));\n" + 
				"		\n" + 
				"		String[] fromBilbao=graph.getListDestination(\"Bilbao\");\n" + 
				"		assertEquals(\"Check testGetListDestination Caceres (1 one).\", true, \n" + 
				"				Arrays.equals(fromBilbao,this.fromBilbao));\n" + 
				"		\n" + 
				"		String[] fromMadrid=graph.getListDestination(\"Madrid\");\n" + 
				"		Arrays.sort(fromMadrid);\n" + 
				"		assertEquals(\"Check testGetListDestination Madrid.\", true, \n" + 
				"				Arrays.equals(fromMadrid,this.fromMadrid));\n" + 
				"		\n" + 
				"	\n" + 
				"		\n" + 
				"	}\n" + 
				"\n" + 
				"	@Test\n" + 
				"	public void testGetListOrigin() {\n" + 
				"		String[] aToBilbao=graph.getListOrigin(\"Bilbao\");\n" + 
				"\n" + 
				"		assertEquals(\"Check testgetListOrigin Bilbao (null).\", true, \n" + 
				"				Arrays.equals(aToBilbao,null));\n" + 
				"		\n" + 
				"		String[] toSalamanca=graph.getListOrigin(\"Salamanca\");\n" + 
				"		assertEquals(\"Check testgetListOrigin Salamanca (one).\", true, \n" + 
				"				Arrays.equals(toSalamanca,this.toSalamanca));\n" + 
				"		\n" + 
				"		\n" + 
				"		String[] aToMadrid=graph.getListOrigin(\"Madrid\");\n" + 
				"		Arrays.sort(aToMadrid);\n" + 
				"		\n" + 
				"		assertEquals(\"Check testgetListOrigin Madrid.\", true, \n" + 
				"				Arrays.equals(aToMadrid,this.toMadrid));\n" + 
				"		\n" + 
				"		\n" + 
				"	}\n" + 
				"\n" + 
				"	@Test\n" + 
				"	public void testgetAllCities() {\n" + 
				"		String[] depth=graph.getAllCities();\n" + 
				"		\n" + 
				"		assertEquals(\"Check getAllCities.\", true, \n" + 
				"				Arrays.equals(depth,this.depth1)||Arrays.equals(depth,this.depth2)\n" + 
				"				||Arrays.equals(depth,this.depth3));\n" + 
				"	}\n" + 
				"	\n" + 
				"	@Test\n" + 
				"	public void testnoConnected() {\n" + 
				"		assertEquals(\"Check noConnected.\", false, \n" + 
				"				equalsArrayOfPairs(graph.nonConnectedCities(),null));\n" + 
				"		Pair[] nocon=graph.nonConnectedCities();\n" + 
				"		boolean result=equalsArrayOfPairs(nocon,this.noConnected);\n" + 
				"		assertEquals(\"Check noConnected.\", true, result);\n" + 
				"	}\n" + 
				"}Check insert an user in empty tree.", true, 
				UsersTest.equals(aux.getSortedList(),list) );	

		
	}

	@Test
	public void testFind() {
		
		assertEquals("Check find, empty tree.", true, 
				empty.findUser("ff")==null);
		
		User user=new User("dd","Juan",18,"H");
		
		assertEquals("Check find, tree.", true, 
				tree.findUser("dd").equals(user));
		
		assertEquals("Check find, non empty tree.", true, 
				tree.findUser("a")==null);
	
	}

	

	@Test
	public void testRemove() {
	
		tree.removeUser("nn");
		list.removeAll("nn");
		
		assertEquals("Check remove a leaf node (nn).", true, 
				UsersTest.equals(tree.getSortedList(),list) );

		tree.removeUser("rr");
		list.removeAll("rr");
		
		assertEquals("Check remove a node (rr) with only a child.", true, 
				UsersTest.equals(tree.getSortedList(),list) );

		tree.removeUser("jj");
		list.removeAll("jj");

		assertEquals("Check remove the root (jj) with two children.", true, 
				UsersTest.equals(tree.getSortedList(),list));

	}

	@Test
	public void testComplaint() {
		User u1=tree.findUser("ss");
		int num1=u1.num_complaints;
		tree.complaint("ss");
		User u2=tree.findUser("ss");
		int num2=u2.num_complaints;

		assertEquals("Check complaint < 3.", true, (num1+1)==num2);
		for (int i=1; i<=4; i++) {
			tree.complaint("ss");
		}
	
		list.removeAll("ss");

		assertEquals("Check complaint == 5.", true, 
				UsersTest.equals(tree.getSortedList(),list));
	}

	@Test
	public void testExtremUsers() {
		System.out.println(tree.getSortedList());
		for (int i=1; i<=4; i++) {
			tree.complaint("jj");
			tree.complaint("cc");
		}
		tree.showLevel();
		System.out.println(tree.getSortedList());

		DList[] aList=tree.extremUsers();
		System.out.println(aList[0].toString());
		System.out.println(aList[1].toString());
		
	}

	

}

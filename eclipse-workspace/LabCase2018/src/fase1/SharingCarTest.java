package fase1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SharingCarTest {
	
	//input lists
	LstRequest lst1=new LstRequest();
	LstRequest lst2=new LstRequest();
	
	//expected lists
	LstRequest expectedMerge=new LstRequest();
	LstRequest expectedSharing=new LstRequest();
	LstRequest nodupli2=new LstRequest();

	LstRequest sorted1Origin=new LstRequest();
	LstRequest sorted1Destination=new LstRequest();
	LstRequest sorted1User=new LstRequest();

	LstRequest searchOMadrid=new LstRequest();
	LstRequest searchDBarcelona=new LstRequest();


	
	/**
	 * This methods creates the lists for testing SharingCar's methods.
	 * YOU SHOULD NOT MODIFY THEIR ELEMENTS (except for exceptedSharing, whose expected values
	 * depend on your implementation. 
	 * If your sharing method does not remove any duplicate request, then you do not need to 
	 * modify the list exceptedSharing.
	 * However, of your sharing method ignores repeated requests in the same
	 * lists, you should modify the values of the expectedSharing
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		//input lists. NOT MODIFY THESE VALUES
		lst1.addLast(new Request("user1","Madrid","Barcelona"));
		lst1.addLast(new Request("user2","Alicante","Barcelona"));
		lst1.addLast(new Request("user3","Sevilla","Alicante"));
		lst1.addLast(new Request("user4","Valencia","Sevilla"));
		
		lst2.addLast(new Request("user5","Madrid","Sevilla"));
		lst2.addLast(new Request("user6","Madrid","Barcelona"));
		lst2.addLast(new Request("user7","Bilbao","Madrid"));
		lst2.addLast(new Request("user8","Valencia","Madrid"));
		lst2.addLast(new Request("user9","Valencia","Barcelona"));
		lst2.addLast(new Request("user6","Madrid","Barcelona"));
		lst2.addLast(new Request("user11","Sevilla","Madrid"));
		lst2.addLast(new Request("user12","Alicante","Barcelona"));
		
		
		
		//expected list for sort, opc=1 for list1. NEVER CHANGE ITS CONTENT
		sorted1Origin.addLast(new Request("user2","Alicante","Barcelona"));
		sorted1Origin.addLast(new Request("user1","Madrid","Barcelona"));
		sorted1Origin.addLast(new Request("user3","Sevilla","Alicante"));
		sorted1Origin.addLast(new Request("user4","Valencia","Sevilla"));
		//expected list for sort, opc=2 for list1. NEVER CHANGE ITS CONTENT
		sorted1Destination.addLast(new Request("user3","Sevilla","Alicante"));
		sorted1Destination.addLast(new Request("user1","Madrid","Barcelona"));
		sorted1Destination.addLast(new Request("user2","Alicante","Barcelona"));
		sorted1Destination.addLast(new Request("user4","Valencia","Sevilla"));
		//expected list for sort, opc!=1,2 for list1. NEVER CHANGE ITS CONTENT
		sorted1User.addLast(new Request("user1","Madrid","Barcelona"));
		sorted1User.addLast(new Request("user2","Alicante","Barcelona"));
		sorted1User.addLast(new Request("user3","Sevilla","Alicante"));
		sorted1User.addLast(new Request("user4","Valencia","Sevilla"));

		
		//expected list for searchOrigin("Madrid",list2). NEVER CHANGE ITS CONTENT
		searchOMadrid.addLast(new Request("user5","Madrid","Sevilla"));
		searchOMadrid.addLast(new Request("user6","Madrid","Barcelona"));
		searchOMadrid.addLast(new Request("user6","Madrid","Barcelona"));

		//expected list for searchOrigin("Barcelona",list2). NEVER CHANGE ITS CONTENT
		searchDBarcelona.addLast(new Request("user6","Madrid","Barcelona"));
		searchDBarcelona.addLast(new Request("user9","Valencia","Barcelona"));
		searchDBarcelona.addLast(new Request("user6","Madrid","Barcelona"));
		searchDBarcelona.addLast(new Request("user12","Alicante","Barcelona"));
		
		//expected list for removeDuplicates(list2). NEVER CHANGE ITS CONTENT
		nodupli2.addLast(new Request("user5","Madrid","Sevilla"));
		nodupli2.addLast(new Request("user6","Madrid","Barcelona"));
		nodupli2.addLast(new Request("user7","Bilbao","Madrid"));
		nodupli2.addLast(new Request("user8","Valencia","Madrid"));
		nodupli2.addLast(new Request("user9","Valencia","Barcelona"));
		nodupli2.addLast(new Request("user11","Sevilla","Madrid"));
		nodupli2.addLast(new Request("user12","Alicante","Barcelona"));

		//expected list for mergeAlternateRequests(lst1,lst2). NEVER CHANGE ITS CONTENT
		expectedMerge.addLast(new Request("user1","Madrid","Barcelona"));
		expectedMerge.addLast(new Request("user5","Madrid","Sevilla"));
		expectedMerge.addLast(new Request("user2","Alicante","Barcelona"));
		expectedMerge.addLast(new Request("user6","Madrid","Barcelona"));
		expectedMerge.addLast(new Request("user3","Sevilla","Alicante"));
		expectedMerge.addLast(new Request("user7","Bilbao","Madrid"));
		expectedMerge.addLast(new Request("user4","Valencia","Sevilla"));
		expectedMerge.addLast(new Request("user8","Valencia","Madrid"));
		expectedMerge.addLast(new Request("user9","Valencia","Barcelona"));
		expectedMerge.addLast(new Request("user6","Madrid","Barcelona"));
		expectedMerge.addLast(new Request("user11","Sevilla","Madrid"));
		expectedMerge.addLast(new Request("user12","Alicante","Barcelona"));

		//sharing method. 
		//If your sharing method does not remove any repeated request, please, NO CHANGE ITS CONTENT
		//However, if your sharing method ignores repeated requests in the same list, you should 
		//adapt expectedSharing to your method.
		expectedSharing.addLast(new Request("user1","Madrid","Barcelona"));
		expectedSharing.addLast(new Request("user6","Madrid","Barcelona"));
		expectedSharing.addLast(new Request("user1","Madrid","Barcelona"));
		expectedSharing.addLast(new Request("user6","Madrid","Barcelona"));
		expectedSharing.addLast(new Request("user2","Alicante","Barcelona"));
		expectedSharing.addLast(new Request("user12","Alicante","Barcelona"));
	
	}



	@Test 
	public void testMergeAlternateRequests() {
		assertEquals("Check mergeAlternatedRequests, first list empty.", true, 
				SharingCar.mergeAlternateRequests(new LstRequest(),lst2).equals(lst2));
		assertEquals("Check mergeAlternatedRequests, second list empty.", true, 
				SharingCar.mergeAlternateRequests(lst1, new LstRequest()).equals(lst1));
		assertEquals("Check mergeAlternatedRequests.", true, 
				SharingCar.mergeAlternateRequests(lst1, lst2).equals(expectedMerge));
	}

	@Test
	/**
	 * This test is right only if your implementation of sharing method includes all duplicate requests
	 * without removing any repeated instance.
	 * If your sharing method ignores repeated requests in the same lists, you can ignore this test
	 * or modifies your expectedSharing list
	 */
	public void testSharing() {
		assertEquals("Check charing for emtpy lists", true, 
				SharingCar.sharing(new LstRequest(), new LstRequest()).equals(new LstRequest()));	
		assertEquals("Check charing for emtpy list and a non empty list", true, 
				SharingCar.sharing(new LstRequest(), lst2).equals(new LstRequest()));	
		assertEquals("Check charing for emtpy a non empty list and en emtpy list", true, 
				SharingCar.sharing(lst1, new LstRequest()).equals(new LstRequest()));	
		assertEquals("Check charing for emtpy a non empty list and en emtpy list", true, 
				SharingCar.sharing(lst1, lst2).equals(expectedSharing));	
		
		
	}

	@Test
	public void testSort() {

		assertEquals("Check sort by username.", false, 
				SharingCar.sort(lst2, 1).equals(lst2));

		assertEquals("Check sort by origin.", false, 
				SharingCar.sort(lst1, 1).equals(lst1));

		assertEquals("Check sort by destination.", false, 
				SharingCar.sort(lst1, 2).equals(lst1));

		
		assertEquals("Check sort by user.", true, 
				SharingCar.sort(lst1, 3).equals(sorted1User));

		assertEquals("Check sort by origin.", true, 
				SharingCar.sort(lst1, 1).equals(sorted1Origin));

		assertEquals("Check sort by destination.", true, 
				SharingCar.sort(lst1, 2).equals(sorted1Destination));
	}

	@Test
	public void testRemoveDuplicates() {
		assertEquals("Check removeduplicates.", true, 
				SharingCar.removeDuplicates(new LstRequest()).equals(new LstRequest()));
		
		assertEquals("Check removeduplicates.", true, 
				SharingCar.removeDuplicates(lst2).equals(nodupli2));
		
		assertEquals("Check removeduplicates.", false, 
				SharingCar.removeDuplicates(lst2).equals(lst2));

		assertEquals("Check removeduplicates.", true, 
				SharingCar.removeDuplicates(lst1).equals(lst1));

	}

	@Test
	public void testSearchOrigin() {
		assertEquals("Check searchOrigin Madrid.", true, 
				SharingCar.searchSource(new LstRequest(), "Madrid").equals( new LstRequest()));
		
		
		assertEquals("Check searchOrigin Madrid.", true, 
				SharingCar.searchSource(lst2, "Madrid").equals(searchOMadrid));
		
		assertEquals("Check searchOrigin Madrid.", false, 
				SharingCar.searchSource(lst2, "Madrid").equals(lst2));
		
	}

	@Test
	public void testSearchDestination() {
		
		assertEquals("Check searchDestination Barcelona.", true, 
				SharingCar.searchTarget( new LstRequest(), "Barcelona").equals( new LstRequest()));
		
		
		assertEquals("Check searchDestination Barcelona.", true, 
				SharingCar.searchTarget( lst2, "Barcelona").equals(searchDBarcelona));
		
		assertEquals("Check searchDestination Barcelona.", false, 
				SharingCar.searchTarget(lst2, "Barcelona").equals(lst2));	}

}

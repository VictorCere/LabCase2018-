package fase3;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import fase1.Request;
import fase1.LstRequest;
public class SharingGraphTest {
	
	public static boolean equalsArrayOfPairs(Pair[] a1, Pair[]a2) {
		if (a1==null && a2!=null) return false;
		if (a1!=null && a2==null) return false;
		if (a1.length!=a2.length) return false;
		
		for (int i=0; i<a1.length;i++) {
			Pair p1=a1[i];
			Pair p2=a2[i];
			if (!p1.equals(p2)) return false;
		}
		
		return true;
		
	}
	
	
	public static final String cities[]={"Madrid",
"Barcelona", "Valencia","Sevilla","Bilbao",
"Granada","Toledo","Salamanca","Alicante","Caceres"};
	String[] fromCaceres=null;
	String[] fromMadrid=null;
	String[] fromBilbao=null;
	String[] depth1=null;
	String[] depth2=null;
	String[] depth3=null;

	
	String[] toMadrid=null;
	String[] toBilbao=null;
	String[] toSalamanca=null;

	SharingGraph graph=new SharingGraph(cities);
	LstRequest lst=new LstRequest();
	
	Pair[] noConnected=null;
	@Before
	public void setUp() throws Exception {
		lst.addLast(new Request(null,"Madrid","Sevilla"));
		lst.addLast(new Request(null,"Madrid","Barcelona"));
		lst.addLast(new Request(null,"Bilbao","Madrid"));
		lst.addLast(new Request(null,"Valencia","Madrid"));
		lst.addLast(new Request(null,"Valencia","Barcelona"));
		lst.addLast(new Request(null,"Madrid","Barcelona"));
		lst.addLast(new Request(null,"Sevilla","Madrid"));
		lst.addLast(new Request(null,"Madrid","Sevilla"));
		lst.addLast(new Request(null,"Alicante","Barcelona"));
		lst.addLast(new Request(null,"Valencia","Madrid"));
		lst.addLast(new Request(null,"Valencia","Barcelona"));
		lst.addLast(new Request(null,"Madrid","Sevilla"));
		lst.addLast(new Request(null,"Madrid","Toledo"));
		lst.addLast(new Request(null,"Toledo","Salamanca"));
		lst.addLast(new Request(null,"Toledo","Salamanca"));
		lst.addLast(new Request(null,"Salamanca","Barcelona"));
		lst.addLast(new Request(null,"Toledo","Caceres"));
		lst.addLast(new Request(null,"Barcelona","Toledo"));
		
		graph.setTravels(lst);
		
		
		String[] auxBil={"Madrid"};
		fromBilbao=auxBil;
		
		String[] auxMad={"Sevilla", "Barcelona", "Toledo"};
		fromMadrid=auxMad;
		Arrays.sort(fromMadrid);
		
		
		
		String[] aux2={"Bilbao","Sevilla","Valencia"};
		toMadrid=aux2;
		Arrays.sort(toMadrid);
		
		String[] aux3={"Toledo"};
		toSalamanca=aux3;
		
		
		
		String[] depth1={"Madrid","Sevilla","Barcelona","Toledo",
				"Salamanca","Caceres","Valencia","Bilbao","Granada","Alicante"};

		String[] depth2={"Madrid","Barcelona","Toledo",
				"Salamanca","Caceres","Sevilla","Valencia","Bilbao","Granada","Alicante"};

		String[] depth3={"Madrid","Toledo",
				"Salamanca","Barcelona", "Caceres","Sevilla","Valencia","Bilbao","Granada","Alicante"};
		
		this.depth1=depth1;
		this.depth2=depth2;
		this.depth3=depth3;

		
		Pair[] noConnected={
				new Pair("Madrid", "Valencia"),
				new Pair("Madrid", "Bilbao"),
				new Pair("Madrid", "Granada"),
				new Pair("Madrid", "Salamanca"),
				new Pair("Madrid", "Alicante"),
				new Pair("Madrid", "Caceres"),
				
				new Pair("Barcelona", "Madrid"),
				new Pair("Barcelona", "Valencia"),
				new Pair("Barcelona", "Sevilla"),
				new Pair("Barcelona", "Bilbao"),
				new Pair("Barcelona", "Granada"),
				new Pair("Barcelona", "Salamanca"),
				new Pair("Barcelona", "Alicante"),
				new Pair("Barcelona", "Caceres"),
				
				new Pair("Valencia", "Sevilla"),
				new Pair("Valencia", "Bilbao"),
				new Pair("Valencia", "Granada"),
				new Pair("Valencia", "Toledo"),
				new Pair("Valencia", "Salamanca"),
				new Pair("Valencia", "Alicante"),
				new Pair("Valencia", "Caceres"),
				
				new Pair("Sevilla", "Barcelona"),
				new Pair("Sevilla", "Valencia"),
				new Pair("Sevilla", "Bilbao"),
				new Pair("Sevilla", "Granada"),
				new Pair("Sevilla", "Toledo"),
				new Pair("Sevilla", "Salamanca"),
				new Pair("Sevilla", "Alicante"),
				new Pair("Sevilla", "Caceres"),
				
				new Pair("Bilbao", "Barcelona"),
				new Pair("Bilbao", "Valencia"),
				new Pair("Bilbao", "Sevilla"),
				new Pair("Bilbao", "Granada"),
				new Pair("Bilbao", "Toledo"),
				new Pair("Bilbao", "Salamanca"),
				new Pair("Bilbao", "Alicante"),
				new Pair("Bilbao", "Caceres"),
				
				new Pair("Granada", "Madrid"),
				new Pair("Granada", "Barcelona"),
				new Pair("Granada", "Valencia"),
				new Pair("Granada", "Sevilla"),
				new Pair("Granada", "Bilbao"),
				new Pair("Granada", "Toledo"),
				new Pair("Granada", "Salamanca"),
				new Pair("Granada", "Alicante"),
				new Pair("Granada", "Caceres"),
				
				new Pair("Toledo", "Madrid"),
				new Pair("Toledo", "Barcelona"),
				new Pair("Toledo", "Valencia"),
				new Pair("Toledo", "Sevilla"),
				new Pair("Toledo", "Bilbao"),
				new Pair("Toledo", "Granada"),
				new Pair("Toledo", "Alicante"),
				
				new Pair("Salamanca", "Madrid"),
				new Pair("Salamanca", "Valencia"),
				new Pair("Salamanca", "Sevilla"),
				new Pair("Salamanca", "Bilbao"),
				new Pair("Salamanca", "Granada"),
				new Pair("Salamanca", "Toledo"),
				new Pair("Salamanca", "Alicante"),
				new Pair("Salamanca", "Caceres"),
				
				new Pair("Alicante", "Madrid"),
				new Pair("Alicante", "Valencia"),
				new Pair("Alicante", "Sevilla"),
				new Pair("Alicante", "Bilbao"),
				new Pair("Alicante", "Granada"),
				new Pair("Alicante", "Toledo"),
				new Pair("Alicante", "Salamanca"),
				new Pair("Alicante", "Caceres"),
				
				new Pair("Caceres", "Madrid"),
				new Pair("Caceres", "Barcelona"),
				new Pair("Caceres", "Valencia"),
				new Pair("Caceres", "Sevilla"),
				new Pair("Caceres", "Bilbao"),
				new Pair("Caceres", "Granada"),
				new Pair("Caceres", "Toledo"),
				new Pair("Caceres", "Salamanca"),
				new Pair("Caceres", "Alicante")
				};
	
		this.noConnected=noConnected;
	}

	
	@Test
	public void testGetListDestination() {
		String[] fromCaceres=graph.getListDestination("Caceres");
		assertEquals("Check testGetListDestination Caceres (null list).", true, 
				Arrays.equals(fromCaceres,null));
		
		String[] fromBilbao=graph.getListDestination("Bilbao");
		assertEquals("Check testGetListDestination Caceres (1 one).", true, 
				Arrays.equals(fromBilbao,this.fromBilbao));
		
		String[] fromMadrid=graph.getListDestination("Madrid");
		Arrays.sort(fromMadrid);
		assertEquals("Check testGetListDestination Madrid.", true, 
				Arrays.equals(fromMadrid,this.fromMadrid));
		
	
		
	}

	@Test
	public void testGetListOrigin() {
		String[] aToBilbao=graph.getListOrigin("Bilbao");

		assertEquals("Check testgetListOrigin Bilbao (null).", true, 
				Arrays.equals(aToBilbao,null));
		
		String[] toSalamanca=graph.getListOrigin("Salamanca");
		assertEquals("Check testgetListOrigin Salamanca (one).", true, 
				Arrays.equals(toSalamanca,this.toSalamanca));
		
		
		String[] aToMadrid=graph.getListOrigin("Madrid");
		Arrays.sort(aToMadrid);
		
		assertEquals("Check testgetListOrigin Madrid.", true, 
				Arrays.equals(aToMadrid,this.toMadrid));
		
		
	}

	@Test
	public void testgetAllCities() {
		String[] depth=graph.getAllCities();
		
		assertEquals("Check getAllCities.", true, 
				Arrays.equals(depth,this.depth1)||Arrays.equals(depth,this.depth2)
				||Arrays.equals(depth,this.depth3));
	}
	
	@Test
	public void testnoConnected() {
		assertEquals("Check noConnected.", false, 
				equalsArrayOfPairs(graph.nonConnectedCities(),null));
		Pair[] nocon=graph.nonConnectedCities();
		boolean result=equalsArrayOfPairs(nocon,this.noConnected);
		assertEquals("Check noConnected.", true, result);
	}
}

package fase3;

public class Pair {
	String origin;
	String destination;
	
	public Pair(String origin, String destination) {
		this.origin=origin;
		this.destination=destination;
	}
	
	public String toString() {
		return origin + " - " + destination;
	}
	
	public boolean equals(Pair p) {
		if (this==p) return true;
		if (p==null) return false;
		
		boolean result=false;
		try {
			result= (this.origin.equalsIgnoreCase(p.origin) &&
					this.destination.equalsIgnoreCase(p.destination));
		} catch (Exception e) {
			//some property is null
		}
		return result;
				
		
	}

}
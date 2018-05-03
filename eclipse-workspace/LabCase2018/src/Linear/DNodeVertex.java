package Linear;

public class DNodeVertex {

	public Integer vertex;
	public Float weight;
	
	public DNodeVertex prev;
	public DNodeVertex next;
	
	public DNodeVertex(Integer v, Float w) {
		vertex = v;
		weight = w;
	}

}


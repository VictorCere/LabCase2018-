package fase1;

public class Request {
	
	public String origin;
	public String destination;
	public String username;
	
	public Request prev;
	public Request next;
	
	public Request(String Origen,String Destino,String idUsuario) {
		this.origin=Origen;
		this.destination=Destino;
		this.username=idUsuario;
	}
	
	
	public boolean equals(Request obj) {
        boolean result=false;
  try {
      result= obj.username.equalsIgnoreCase(this.username) &&
        obj.origin.equalsIgnoreCase(this.origin) &&    obj.destination.equalsIgnoreCase(this.destination);
        } catch (Exception e) {
              //obj is null or some of the attributes are null
              result=false;
        }
        return result;
  }
}
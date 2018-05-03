package fase1;

public class Request {
	
	public String Origen;
	public String Destino;
	public String idUsuario;
	
	public Request prev;
	public Request next;
	
	public Request(String Origen,String Destino,String idUsuario) {
		this.Origen=Origen;
		this.Destino=Destino;
		this.idUsuario=idUsuario;
	}
}
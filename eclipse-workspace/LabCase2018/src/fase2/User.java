package fase2;

public class User {
	String Full_name;
	int Age;
	String Gender;
	String Username;
	int NComplains;
	
	public User(String Username,String Full_name,int Age,String Gender) {
		this.Full_name=Full_name;
		this.Age=Age;
		this.Gender=Gender;
		this.Username=Username;
	}
	public User(String Username,String Full_name,int Age,String Gender,int Ncom) {
		this.Full_name=Full_name;
		this.Age=Age;
		this.Gender=Gender;
		this.Username=Username;
		this.NComplains=Ncom;
	}
}

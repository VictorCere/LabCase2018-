package fase2;
public interface IBSTree {

	public BSTNode findUser(BSTNode node, String Username);

	public void insertuser(String Username ,String Full_name,int Age,int Gender,int NComplains);

	public void removeUser(String Username);

}
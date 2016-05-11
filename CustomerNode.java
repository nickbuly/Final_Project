/*
Final Project: Netflix
CustomerNode for the customer record, including their name, credit card info and email address
*/

public class CustomerNode implements java.io.Serializable// Creates a CustomerNode class
{
	private String name; // These are all instance variables
	private String email; //User's email
	private CustomerNode next;
	//private int key; // Gets the last four digits of the ssn
	private CustomerNode left;
	private CustomerNode right;
	private CustomerNode parent;
	private long cc; // Credit card info from user
	private WishList wishList ;

	// Constructors used to create an object of that class, and assign to instance variables
	public CustomerNode(String name, long cc, String email)
	{
		this.name = name; // Declare variables name, ssn, key and a CustomerNode called next
		this.next = null;
		this.right=null;
		this.left=null;
		this.parent = null;
		this.email = email;
		this.cc = cc;
		wishList = new WishList();
	}

	public String getName() 
	{
		return name; // Method type is a string, so program will return the name as a string
	}

	public void setName(String name) 
	{
		this.name = name; // Void indicates the type of object it reurns. In this case it does not return anything
	}

	public long getcc()
	{
		return cc%10000; // Method type is int, so program will return an integer
	}

	public void setcc(long cc) 
	{
		this.cc = cc; // Void is used because SetSSN does not return anything
	}

	public void setNext(CustomerNode newNext)
	{
		this.next = newNext; // Void is used because setNext is also not returning anything
	}

	public CustomerNode getNext()
	{
		return next; // Method type is CustomerNode, because program is using the CustomerNode pointer
	}
	public CustomerNode getLeft()
	{
		return left;
	}
	public CustomerNode getRight()
	{
		return right;
	}
	public void setRight(CustomerNode newRight)
	{
		this.right=newRight;
	}
	public void setLeft(CustomerNode newLeft)
	{
		this.left=newLeft;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String newEmail)
	{
		this.email = newEmail;
	}

	public WishList getList()
	{
		return wishList;
	}
}
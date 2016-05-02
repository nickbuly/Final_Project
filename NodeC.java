/*
Final Project: Netflix
Node for the customer record, including their name, credit card info and email address
*/

public class NodeC implements java.io.Serializable// Creates a node class
{
	private String name; // These are all instance variables
	private String email; //User's email
	private Node next;
	private int key; // Gets the last four digits of the ssn
	private Node left;
	private Node right;
	private Node parent;
	private int cc; // Credit card info from user
	private int ssn; 

	// Constructors used to create an object of that class, and assign to instance variables
	public NodeC(String name, int cc, String email)
	{
		this.name = name; // Declare variables name, ssn, key and a node called next
		this.ssn = ssn;
		this.key = key;
		this.next = null;
		this.right=null;
		this.left=null;
		this.parent = null;
		this.email = email;
		this.cc = cc;
	}

	public String getName() 
	{
		return name; // Method type is a string, so program will return the name as a string
	}

	public void setName(String name) 
	{
		this.name = name; // Void indicates the type of object it reurns. In this case it does not return anything
	}

	public int getcc()
	{
		return cc; // Method type is int, so program will return an integer
	}

	public void setcc(int cc) 
	{
		this.cc = cc; // Void is used because SetSSN does not return anything
	}

	public int getKey()
	{
		//key = ssn % 10000; // Use modulo to get the last four digits of the ssn
		return key; // 10,000 gets the last four digits 
	}
	public void setKey(int key)
	{
		this.key=key;
	}
	public void setNext(Node newNext)
	{
		this.next = newNext; // Void is used because setNext is also not returning anything
	}

	public Node getNext()
	{
		return next; // Method type is Node, because program is using the node pointer
	}
	public Node getLeft()
	{
		return left;
	}
	public Node getRight()
	{
		return right;
	}
	public void setRight(Node newRight)
	{
		this.right=newRight;
	}
	public void setLeft(Node newLeft)
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


}
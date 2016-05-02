//MovieNode

public class MovieNode implements java.io.Serializable{
	private int ssn;
	private String title;
	private Node next;
	private Node right;
	private Node left;
	
	public MovieNode (int id, int score, String title, int date){
		this.id = id;
		this.score = score;
		this.title = title;
		this.date = date;
	}
//getID method for node
	public int getID(){
		return id;
	}
//getScore method for node
	public int getScore(){
		return score;
	}
//getTitle method for int
	public int getTitle(){
		return title;
	}
//setNext method for node
	public void setNext(Node newNext){
		next = newNext;
	}
//getNext method for node
	public Node getNext(){
		return next;
	}
//setLeft method for node
	public void setRight(Node newRight){
		right = newRight;
	}
//setRight method for node
	public void setLeft(Node newLeft){
		left = newLeft;
	}
//getLeft method for node
	public Node getLeft(){
		return left;
	}
//getRight method for node
	public Node getRight(){
		return right;
	}
}
//MovieMovieNode

public class MovieNode implements java.io.Serializable{
	private int id;
	private int score;
	private int date;
	private String title;
	private MovieNode next;
	private MovieNode right;
	private MovieNode left;
	
	public MovieNode (int id, int score, String title, int date){
		this.id = id;
		this.score = score;
		this.title = title;
		this.date = date;
	}
//getID method for MovieNode
	public int getID(){
		return id;
	}
//getScore method for MovieNode
	public int getScore(){
		return score;
	}
//getTitle method for int
	public String getTitle(){
		return title;
	}
//getDate method for MovieNode
	public int getDate(){
		return date;
	}
//setNext method for MovieNode
	public void setNext(MovieNode newNext){
		next = newNext;
	}
//getNext method for MovieNode
	public MovieNode getNext(){
		return next;
	}
//setLeft method for MovieNode
	public void setRight(MovieNode newRight){
		right = newRight;
	}
//setRight method for MovieNode
	public void setLeft(MovieNode newLeft){
		left = newLeft;
	}
//getLeft method for MovieNode
	public MovieNode getLeft(){
		return left;
	}
//getRight method for MovieNode
	public MovieNode getRight(){
		return right;
	}
}
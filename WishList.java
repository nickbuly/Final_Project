public class WishList implements java.io.Serializable{
	private MovieNode [] wList;
	private int i;

	public WishList(){
		wList = new MovieNode [20];
		i = 0;
	}
	public boolean isEmpty(){
		return i == 0;
	}

	public void insert(MovieNode x){
			wList[i] = x; 
			i++;
		}

	public void accessMovie(){
		if(wList[0] != null){
			System.out.println("The movie ready to play in your wish list is "+wList[0].getTitle()+", enjoy the show!");
		}
		else{
			System.out.println("Unfortunately, that movie is no longer available.");
			System.out.println("The next movie in your wish list is "+wList[1].getTitle()+", enjoy the show!");
			delete(0);
		}
	}

	public void delete(int index){
		i--;
		for (int n = index; n < i; n++){
			wList[n] = wList[n+1];
		}
	}

	public void printWishList(){
		for (int n = 0; n < i; n++){
			System.out.println(wList[n].getTitle());
			System.out.println(wList[n].getID());
		}
	}
}
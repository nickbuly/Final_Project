/* 
Andrew Eigner
Program 5
4/13/16
*/


public class MovieHashTable{
	private int n;
	private MovieNode []h;
	private int TableSize;

	public MovieHashTable(){
		h = new MovieNode [7];
		n=0;
		TableSize = 7;
	}
	public int hash1(int id){ //this method  will try to find a spot in the array with mod 7
		return id%7;
	}
	public int hash2(int id){ //this method will try to find a spot in the array with mod 5
		return id%5;
	}
	public String lookUp(int id){ // this method returns a MovieNode in the hash table with a given key
		int pos1 = hash1(id);
		int pos2 = hash2(id);
		n = 0;
		if (h[pos1].getID() == id){
			return h[pos1].getTitle();
		}
		else if(h[pos2].getID() == id){
			return h[pos2].getTitle();
		}
		else{

			while (h[pos2].getID() != id && n < 7){
			pos2 = (pos2 + 1) % 7;
			n = n +1;
		}
			if (h[pos2].getID() == id){
				return h[pos2].getTitle();
			}
			else{
				return null;
			}
		}	
	}
	public void insert (MovieNode x){ //this method finds a spot in the array and inserts a MovieNode 
		int pos1 = hash1(x.getID());
		int pos2 = hash2(x.getID());
		if (n==7){
			System.out.println("Hash Full");
		}
		else{
			if (h[pos1] == null){
				h[pos1] = x;
			}
			else if (h[pos2] == null){
				h[pos2] = x;
			}
			else{
				while (h[pos2] != null){
					pos2 = (pos2 + 1) % 7;
				}
				
				h[pos2]=x;	
			}
			n++;
		}
	}
	public void delete(int id){ //this method deletes a specific MovieNode in the Hash Table
			int pos1 = hash1(id);
			int pos2 = hash2(id);
			if (lookUp(id) != null){
				if (h[pos1].getID() == id){
					h[pos1] = null;
					n--;
				}
				else if(h[pos2].getID() == id){
					h[pos2] = null;
					n--;
				}
				else{
					while (h[pos2].getID() != id && n < 7){
					pos2 = (pos2 + 1) % 7;
					n = n +1;
					}
					if (h[pos2].getID() == id){
			
						h[pos2] = null;
						n--;
					}
				}	
		}
	}
	public boolean isEmptySet(){ //returns true or false depending on whether or not the Hash Table is empty 
		return h == null;
	}
}